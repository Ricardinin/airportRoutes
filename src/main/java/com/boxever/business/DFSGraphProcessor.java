package com.boxever.business;

import com.boxever.domain.Edge;

import java.util.*;

public class DFSGraphProcessor implements IGraphProcessor {
    private Map<String, Map<String, Edge>> graph = new HashMap<String, Map<String, Edge>>();

    public DFSGraphProcessor(Map<String, Map<String, Edge>> graph) {
        this.graph = graph;
    }

    @Override
    public TreeMap<Integer, String> getPaths(String origin, String destination) {
        Map<String, Boolean> visited = new HashMap<>();
        TreeMap<Integer, String> durationPathMap = new TreeMap<>();
        processNode(origin, "", 0, visited, destination, durationPathMap);
        return durationPathMap;
    }

    private void processNode(String currentAirport, String currentPath, int totalDuration,  Map<String, Boolean> visited,
                             String destination, Map<Integer, String> durationPathMap) {

        Map<String, Edge> currentAirportConnections = graph.getOrDefault(currentAirport, Collections.emptyMap());

        if (currentAirport.equals(destination)) {
            durationPathMap.put(totalDuration, currentPath + "Time: " + totalDuration + CRLR);
        }
        else {
            Iterator<Map.Entry<String, Edge>> iter = currentAirportConnections.entrySet().iterator();
            while (iter.hasNext()) {
                Edge currendEdge = iter.next().getValue();
                processNode(currendEdge.getDest(), currentPath + currendEdge.toString() + CRLR,
                        totalDuration + currendEdge.getDuration(), visited, destination, durationPathMap);
            }
            visited.put(currentAirport, true);
        }
    }
}
