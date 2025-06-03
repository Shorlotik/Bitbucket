package com.railninja.cli;

import com.railninja.models.Ticket;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    public void writeToCsv(List<Ticket> tickets, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            // Write CSV header
            writer.write("Departure Station,Arrival Station,Departure Time,Arrival Time,Duration,Price,Class,Fare Type\n");

            // Write ticket data
            for (Ticket ticket : tickets) {
                writer.write(String.format("%s,%s,%s,%s,%s,%.2f,%s,%s\n",
                        ticket.getDepartureStation(),
                        ticket.getArrivalStation(),
                        ticket.getDepartureTime(),
                        ticket.getArrivalTime(),
                        ticket.getDuration(),
                        ticket.getPrice(),
                        ticket.getServiceClass(),
                        ticket.getFareType()));
            }
        }
    }
}