package com.railninja.cli;

import com.railninja.models.Ticket;
import com.railninja.models.TripRequest;
import com.railninja.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class RailNinjaClient {
    private final String apiKey;
    private final String baseUrl;
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public RailNinjaClient() throws IOException {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

        this.apiKey = System.getenv("RAIL_NINJA_API_KEY") != null ?
                System.getenv("RAIL_NINJA_API_KEY") : props.getProperty("railninja.api.key");
        this.baseUrl = props.getProperty("railninja.api.url");
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper();
    }

    public List<Ticket> searchTickets(TripRequest request) throws ApiException {
        HttpUrl url = HttpUrl.parse(baseUrl + "/search").newBuilder()
                .addQueryParameter("from", request.getDepartureCity())
                .addQueryParameter("to", request.getArrivalCity())
                .addQueryParameter("date", request.getTravelDate())
                .addQueryParameter("passengers", String.valueOf(request.getPassengers()))
                .build();

        Request httpRequest = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(httpRequest).execute()) {
            if (!response.isSuccessful()) {
                throw new ApiException("API request failed: " + response.code() + " - " + response.message());
            }

            String responseBody = response.body().string();
            return mapper.readValue(responseBody,
                    mapper.getTypeFactory().constructCollectionType(List.class, Ticket.class));
        } catch (IOException e) {
            throw new ApiException("Failed to process API response: " + e.getMessage());
        }
    }
}