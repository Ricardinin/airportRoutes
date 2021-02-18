package com.boxever.domain;

public class Edge {
    private String src;
    private String dest;
    private int duration;

    public Edge(String src, String dest, int duration) {
        this.src = src;
        this.dest = dest;
        this.duration = duration;
    }

    public String getSrc() {
        return src;
    }

    public String getDest() {
        return dest;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "" + src + " -- " + dest +  " (" + duration + ")";
    }

}
