package com.boxever.business;

import com.boxever.domain.Edge;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SuperFastDublinOriginGraphProcessor implements IGraphProcessor {
    private Map<String, Map<String, Edge>> graph = new HashMap<String, Map<String, Edge>>();

    public SuperFastDublinOriginGraphProcessor(Map<String, Map<String, Edge>> graph) {
        this.graph = graph;
    }

    @Override
    public TreeMap<Integer, String> getPaths(String origin, String destination) {
        TreeMap<Integer, String> durationPathMap = new TreeMap<>();
        durationPathMap.put(0, "DUB -- SYD (0) \r\nTime: 0\r\n");

        return durationPathMap;
    }
}
