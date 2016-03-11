package f14;
import java.util.*;

public class GraphExample {
	public static void mst() {
        Graph<String> graph = new Graph<String>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addEdge("A","B",5);
        graph.addEdge("A","C",4);
        graph.addEdge("B", "A",5);
        graph.addEdge("B","C",3);
        graph.addEdge("B","E",4);
        graph.addEdge("C","A",4);
        graph.addEdge("C","B",3);
        graph.addEdge("C","D",5);
        graph.addEdge("D","C",5);
        graph.addEdge("D","E",5);
        graph.addEdge("E","B",4);
        graph.addEdge("E","D",5);
        graph.printGraph();
        Graph<String> mst = GraphSearch.minimumSpanningTree(graph, "A"); // Ändra till B och jämför resultat
        mst.printGraph();
	}
	
    public static void demo() {
        Graph<String> graph = new Graph<String>();
        graph.addVertex("Åhus");
        graph.addVertex("Lund");
        graph.addVertex("Simrishamn");
        graph.addVertex("Ystad");
        graph.addEdge("Simrishamn","Åhus",52);
        graph.addEdge("Simrishamn","Ystad",36);
        graph.addEdge("Ystad", "Simrishamn",36);
        graph.addEdge("Simrishamn","Lund",75);
        graph.addEdge("Lund","Simrishamn",75);
        graph.addEdge("Lund","Ystad",56);
        graph.addEdge("Ystad","Lund",56);
        graph.printGraph();
        Iterator<String> iter = GraphSearch.traversalBF(graph, "Lund");
        System.out.print("\nStart i Lund: ");
        while(iter.hasNext())
            System.out.print(iter.next() + " ");
//        ArrayList<Edge<String>> res = GraphSearch.breadthFirstSearch(graph, "Lund", "Åhus");
//        System.out.println("\nLund till Åhus");
//        for( Edge<String> edge : res )
//            System.out.println(edge);
    }
    
    public static void main(String[] args) {
		GraphExample.demo();
//		GraphExample.mst();
	}
}
