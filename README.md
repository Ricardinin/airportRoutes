# Coding Challenge
## Statement
You run an airline that has planes that fly to different destinations around the world. 
Given a task to fly between two airports you must ensure that each airplane takes the shortest time to reach 
its destination. 

## Solution
By the statement we can match this problem to a directed graph where we need to find the shortest path between two 
nodes or vertex. 
-   Vertex (Node) = City airport
-   Edge = Connection between 2 different city airports (origin and destination)
-   Weight = Flight duration time
-   Directed = True. Every edges has a direction, for example there is DUB --> CDG, but not CDG --> DUB

## Data Structure
Map<String, Map<String, Edge>>

In order to seek city airports fast, it makes sense to use a Map. Then for every aiport we can have several connections, for 
example DUB --> LHR, DUB --> CDG and DUB --> ORD, they are all in the same outer map, for key "DUB"
The internal data structure might be either a list or a map, depending if we have to traverse all nodes.
I selected an inner map, Map<String, Edge>, where the key is the destination airport and in the edge we have 3 attributes,
source, destination and flight duration. As we traverse all the nodes, I could have selected a list, but at the beginning 
I thought I would look up the destination the same way as the source airport in outer map.

##Algorithm
Most commom algorithm to find the shortest path is Dijkstra, that uses different loops and a list to mark visited nodes 
and not process them again once visited. However with this algorithm it turned out very difficult to keep track of the visited
airports visited that will conform the successful path. 
The algorithm used for keeping track of the whole path navigated is DFS, Depth First Search, which will go visiting each 
of the nodes until we reach a leaf (tree term, with no more children). When we reach the leaf, we store the path (kind 
of breadcrumbs) and the sum of all flight durations. 
You can switch to different processors to run the process of find the shortest path with different IGraphProcessor 
implementations.

##Inconvinients
* Algorithm used here used recursion, stack recursion, so for each recursive call it store data in the stack, so in case of
many used nodes there will be an StackOverflow error. For sure there must be a tail recursive solution in Scala.
* This algorithm traverses all nodes, so the worst case scenarion in time and space complexity could be big if the 
number of nodes is big. Please check (https://en.wikipedia.org/wiki/Depth-first_search)
* it need to be tested well in case of cyclic connections

##Improvements
* Origin and destination passed as command line parameters
* Create an executable jar
* Graphprocessor should be injected in AirportGraph and the process run from there, not the other way around. 
* Do an exhaustive check of main input parameters
* Add a new parameter, for example -f, which will indicate to use SuperFastProcessor
* Create a factory method that will instantiate different processors depending on an input paramter -p

##Run Commands
* java -jar BoxeverCodingChallenge-1.0-SNAPSHOT.jar DUB SYD    (need to assemble the artifact with before with: mvn clean package)
* java com.boxever.main.main DUB SYD
* mvn exec:java -Dexec.mainClass=com.boxever.main.main -Dexec.args="DUB SYD"


