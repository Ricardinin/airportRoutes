package com.boxever.domain;

import java.util.*;

/**
 * Data structure is represented by a map of maps to enable quick searches by airport name in both maps
 * Example of Edge from DUB to LHR with 1 hour duration:  {'DUB' -> {'LHR' -> Edge('DUB', 'LHR', 1)}}
 * Notice that in the inner map the key is the destination airport
 */
public class AirportsGraph {
    private Map<String, Map<String, Edge>> graph = new HashMap<String, Map<String, Edge>>();

    public Map<String, Map<String, Edge>> getGraph() {
        return graph;
    }

    public void addEdge(String source, String destination, int duration) {
        Map<String, Edge> destMap = new HashMap<String, Edge>();
        destMap.put(destination, new Edge(source, destination, duration));
        if (graph.containsKey(source)) {
            graph.get(source).put(destination, new Edge(source, destination, duration));
        } else {
            graph.put(source, destMap);
        }
    }

    public int countAirports() {
        return graph.size();
    }

    public void print() {
        graph.forEach((src, destMap) -> destMap.forEach((dest, edge) -> System.out.println(edge)));
    }
}
