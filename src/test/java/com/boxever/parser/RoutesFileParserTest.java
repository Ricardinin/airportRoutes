package com.boxever.parser;

import com.boxever.domain.AirportsGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoutesFileParserTest {
    RoutesFileParser rfp;

    @BeforeEach
    void setup() {
        rfp = new RoutesFileParser("src/test/resources/testroutes.txt");
    }

    @Test
    void parseFile() throws FileNotFoundException {
        AirportsGraph ag = rfp.parseFile();
        assertNotNull(ag);
        assertEquals(3, ag.countAirports());
    }
}