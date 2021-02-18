package com.boxever.business;

import com.boxever.parser.RoutesFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class SuperFastDublinOriginGraphProcessorTest {
    IGraphProcessor graphProcessor;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        RoutesFileParser rfp = new RoutesFileParser("src/test/resources/testroutes.txt");
        graphProcessor = new SuperFastDublinOriginGraphProcessor(rfp.parseFile().getGraph());
    }

    @Test
    void getPaths() {
        TreeMap<Integer, String> map = graphProcessor.getPaths("NYC", "MEX");
        System.out.println(map.firstEntry());
        assertEquals("DUB -- SYD (0) \r\nTime: 0\r\n", map.firstEntry().getValue());
    }
}