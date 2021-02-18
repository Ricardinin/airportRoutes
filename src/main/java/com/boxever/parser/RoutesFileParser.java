package com.boxever.parser;

import com.boxever.domain.AirportsGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoutesFileParser {
    private String fileName;

    public RoutesFileParser(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads the configuration file with routes.
     * FORMAT:  originAirport DestinationAirport flightDuration
     * Example: DUB LHR 1
     * @return AirportGraph object
     * @throws FileNotFoundException
     */
    public AirportsGraph parseFile() throws FileNotFoundException {
        File configFile = new File(fileName);
        Scanner scnr = new Scanner(configFile);
        AirportsGraph ag = new AirportsGraph();

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            String[] lineItems = line.split(" ");
            ag.addEdge(lineItems[0], lineItems[1], Integer.parseInt(lineItems[2]));
        }

        return ag;
    }
}
