package com.boxever.business;

import com.boxever.domain.AirportsGraph;
import com.boxever.parser.RoutesFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class DFSGraphProcessorTest {
    IGraphProcessor graphProcessor;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        RoutesFileParser rfp = new RoutesFileParser("src/test/resources/testroutes.txt");
        graphProcessor = new DFSGraphProcessor(rfp.parseFile().getGraph());
    }

    @Test
    void getPaths() {
        TreeMap<Integer, String> map = graphProcessor.getPaths("NYC", "MEX");
        System.out.println(map.firstEntry());
        assertEquals("NYC -- LAS (3)\r\nLAS -- MEX (5)\r\nTime: 8\r\n", map.firstEntry().getValue());
    }
}