package com.boxever.main;

import com.boxever.business.DFSGraphProcessor;
import com.boxever.business.IGraphProcessor;
import com.boxever.business.SuperFastDublinOriginGraphProcessor;
import com.boxever.domain.AirportsGraph;
import com.boxever.parser.RoutesFileParser;

import java.io.FileNotFoundException;
import java.util.TreeMap;

public class main {

    public static void main(String[] args) {
        RoutesFileParser rfp = new RoutesFileParser("src/main/resources/routes.txt");
        AirportsGraph graph = null;

        try {
             graph = rfp.parseFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(1);
        }

        //graph.print();

        if (args.length != 2) {
            System.out.println("Usage Option[1]: java -jar BoxeverCodingChallenge-1.0-SNAPSHOT.jar sourceAiport DestinationAirport");
            System.out.println("Usage Option[2]: java com.boxever.main.main sourceAiport DestinationAirport");
            System.exit(1);
        }

        IGraphProcessor graphProcessor = new DFSGraphProcessor(graph.getGraph());
        TreeMap<Integer, String> map = graphProcessor.getPaths(args[0], args[1]);
        System.out.println(map.firstEntry() != null? map.firstEntry().getValue(): "Itinerary unavailable");

        /*
        IGraphProcessor fastGraphProcessor = new SuperFastDublinOriginGraphProcessor(graph.getGraph());
        TreeMap<Integer, String> map2 = fastGraphProcessor.getPaths("DUB", "SYD");
        System.out.println(map2.firstEntry() != null? map2.firstEntry().getValue(): "Itinerary unavailable");
        */

    }
}
