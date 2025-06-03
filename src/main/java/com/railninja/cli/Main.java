package com.railninja.cli;

import com.railninja.models.TripRequest;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rail Ninja Ticket Finder");
        System.out.println("------------------------");

        TripRequest request = new TripRequest();

        System.out.print("Enter departure city: ");
        request.setDepartureCity(scanner.nextLine());

        System.out.print("Enter arrival city: ");
        request.setArrivalCity(scanner.nextLine());

        System.out.print("Enter travel date (YYYY-MM-DD): ");
        request.setTravelDate(scanner.nextLine());

        System.out.print("Enter number of passengers: ");
        request.setPassengers(Integer.parseInt(scanner.nextLine()));

        try {
            RailNinjaClient client = new RailNinjaClient();
            var tickets = client.searchTickets(request);

            CsvWriter writer = new CsvWriter();
            String filename = "tickets_" + System.currentTimeMillis() + ".csv";
            writer.writeToCsv(tickets, filename);

            System.out.println("Success! Tickets saved to " + filename);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}