package com.boxever.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportsGraphTest {
    AirportsGraph ag = new AirportsGraph();

    @Test
    void testAddEdge() {
//        String source = "DUB";
//        String destination = "CDG";
//        int duration = 2;

        //ag.addEdge(source, destination, duration);
        ag.addEdge("DUB", "CDG", 2);
        ag.addEdge("ORD", "LAS", 2);
        ag.addEdge("DUB", "ORD", 6);

        assertEquals(2, ag.countAirports());  // Notice, there are 2 entries, Dublin has 2 edges but is only 1 entry
    }
}
