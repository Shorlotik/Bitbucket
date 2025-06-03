package com.railninja.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {
    @JsonProperty("departure_station")
    private String departureStation;

    @JsonProperty("arrival_station")
    private String arrivalStation;

    @JsonProperty("departure_time")
    private String departureTime;

    @JsonProperty("arrival_time")
    private String arrivalTime;

    private String duration;
    private double price;

    @JsonProperty("service_class")
    private String serviceClass;

    @JsonProperty("fare_type")
    private String fareType;

    // Getters and Setters
    public String getDepartureStation() { return departureStation; }
    public void setDepartureStation(String departureStation) { this.departureStation = departureStation; }

    public String getArrivalStation() { return arrivalStation; }
    public void setArrivalStation(String arrivalStation) { this.arrivalStation = arrivalStation; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getServiceClass() { return serviceClass; }
    public void setServiceClass(String serviceClass) { this.serviceClass = serviceClass; }

    public String getFareType() { return fareType; }
    public void setFareType(String fareType) { this.fareType = fareType; }
}