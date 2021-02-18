package com.boxever.business;

import java.util.TreeMap;

public interface IGraphProcessor {
    public char CR = 0x0D;
    public char LR = 0x0A;
    public String CRLR = new String(new char[] {CR, LR});

    TreeMap<Integer, String> getPaths(String origin, String destination);
}
