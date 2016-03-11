package f14;
import java.util.*;
import f11.ArrayHeap;

public class GraphSearch {

    /*************************** DEPTH FIRST TRAVERSAL **********************
     * Traverserar grafen genom sökning på djupet. Noderna returneras
     * som en Iterator-implementering
     * @param graph grafen som traverseras
     * @param from nod i vilken travereringen startar
     * @return noderna som besökts
     */
    public static <T> Iterator<T> traversalDF(Graph<T> graph, T start) {
        LinkedList<Edge<T>> stack = new LinkedList<Edge<T>>();
        LinkedHashSet<T> visited = new LinkedHashSet<T>();
        Edge<T> edge;

        visited.add(start);
        stack.addAll(graph.getAdjacentList(start));
        while( !stack.isEmpty() ) {
            edge = stack.removeLast();
            if(!visited.contains(edge.getTo())) {
                visited.add(edge.getTo());
                stack.addAll(graph.getAdjacentList(edge.getTo()));
            }
        }
        return visited.iterator();
    }
    /*************************** DEPTH FIRST SEARCH *************************
     * Sökning av väg från <code>from</code> till <code>to</code> sker på djupet.
     * Den först funna vägen returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return En väg från <code>from</code> till <code>to</code>. Går det inte 
     * att komma till <code>to</code> returneras en tom lista.
     */
    public static <T> ArrayList<Edge<T>> depthFirstSearch(Graph<T> graph, T from, T to) {
        LinkedList<Edge<T>> stack = new LinkedList<Edge<T>>();
        HashMap<T,Edge<T>> visited = new HashMap<T,Edge<T>>();
        boolean arrived = from.equals(to);
        Edge<T> edge;

        visited.put(from,null);
        stack.addAll(graph.getAdjacentList(from));
        while( !stack.isEmpty() && !arrived ) {
            edge = stack.removeLast();
            if(!visited.containsKey(edge.getTo())) {
                visited.put(edge.getTo(),edge);
                stack.addAll(graph.getAdjacentList(edge.getTo()));
                arrived = to.equals(edge.getTo());
            }
        }
        return getPath(from, to, visited);
    }


    /*************************** BREADTH FIRST TRAVERSAL **********************
     * Traverserar grafen genom sökning på bredden. Noderna returneras
     * som en Iterator-implementering
     * @param graph grafen som traverseras
     * @param from nod i vilken travereringen startar
     * @return noderna som besökts
     */
    public static <T> Iterator<T> traversalBF(Graph<T> graph, T start) {
        LinkedList<Edge<T>> queue = new LinkedList<Edge<T>>();
        LinkedHashSet<T> visited = new LinkedHashSet<T>();
        Edge<T> edge;

        visited.add(start);
        queue.addAll(graph.getAdjacentList(start));
        while( !queue.isEmpty() ) {
            edge = queue.removeFirst();
            if(!visited.contains(edge.getTo())) {
                visited.add(edge.getTo());
                queue.addAll(graph.getAdjacentList(edge.getTo()));
            }
        }
        return visited.iterator();
    }
    /*************************** BREADTH FIRST SEARCH *************************
     * Sökning av väg från <code>from</code> till <code>to</code> sker på bredden.
     * Den först funna vägen returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return En väg från <code>from</code> till <code>to</code>. Går det inte 
     * att komma till <code>to</code> returneras en tom lista.
     */
    public static <T> ArrayList<Edge<T>> breadthFirstSearch(Graph<T> graph, T from, T to) {
        LinkedList<Edge<T>> queue = new LinkedList<Edge<T>>();
        HashMap<T,Edge<T>> visited = new HashMap<T,Edge<T>>();
        boolean arrived = from.equals(to);
        Edge<T> edge;

        visited.put(from,null);
        queue.addAll(graph.getAdjacentList(from));
        while( !queue.isEmpty() && !arrived ) {
            edge = queue.removeFirst();
            if(!visited.containsKey(edge.getTo())) {
                visited.put(edge.getTo(),edge);
                queue.addAll(graph.getAdjacentList(edge.getTo()));
                arrived = to.equals(edge.getTo());
            }
        }
        return getPath(from, to, visited);
    }
    /*************************** BREADTH FIRST SEARCH *************************
     * Sökning av väg från <code>from</code> till <code>to</code> sker på bredden.
     * Den först funna vägen returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return En väg från <code>from</code> till <code>to</code>. Går det inte 
     * att komma till <code>to</code> returneras en tom lista.
     */
    public static <T> Graph<T> minimumSpanningTree(Graph<T> graph, T from) {
    	Graph<T> minmumSpanningTree = new Graph<T>();
    	ArrayHeap<Edge<T>> heap = new ArrayHeap<Edge<T>>(10);
        ArrayList<Edge<T>> adjacentList = graph.getAdjacentList(from);
        Edge<T> edge;
        
        minmumSpanningTree.addVertex(from);
        for(Edge<T> e : adjacentList)
            heap.insert(e);
        while( heap.size()>0 ) {
            edge = heap.delete();
            if(!minmumSpanningTree.containsVertex(edge.getTo())) {
            	minmumSpanningTree.addVertex(edge.getTo());
            	minmumSpanningTree.addEdge(edge.getFrom(), edge.getTo(), edge.getWeight());
                adjacentList = graph.getAdjacentList(edge.getTo());
                for(Edge<T> e : adjacentList)
                    heap.insert(e);
            }
        }
    	
    	return minmumSpanningTree;
    }
    

    /**
     * Sökning av väg från <code>from</code> till <code>to</code> sker på bredden.
     * Vägen med lägst vikt returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return Vägen med lägst vikt som leder från <code>from</code> till 
     * <code>to</code>. Går det inte att komma till <code>to</code> returneras 
     * en tom lista.
     */
    public static <T> ArrayList<Edge<T>> dijkstraSearch(Graph<T> graph, T from, T to) {
        Candidate<T> candidate;
        PriorityQueue<Candidate<T>> queue = new PriorityQueue<Candidate<T>>();
        HashMap<T,Edge<T>> visited = new HashMap<T,Edge<T>>();
        boolean arrived = from.equals(to);
        ArrayList<Edge<T>> adjacentList = graph.getAdjacentList(from);

        visited.put(from,null);
        for(Edge<T> edge : adjacentList)
            queue.add(new Candidate<T>(edge,edge.getWeight()));
        while( queue.size()>0 && !arrived ) {
            candidate = queue.remove();
            if(!visited.containsKey(candidate.edge.getTo())) {
                visited.put(candidate.edge.getTo(),candidate.edge);
                adjacentList = graph.getAdjacentList(candidate.edge.getTo());
                for(Edge<T> edge : adjacentList)
                    queue.add(new Candidate<T>(edge,candidate.totalWeight + edge.getWeight()));
                arrived = to.equals(candidate.edge.getTo());
            }
        }
        return getPath(from, to, visited);
    }

    // Klass som används i dijkstraSearch
    private static class Candidate<T> implements Comparable<Candidate<T>> {
        private Edge<T> edge;
        private int totalWeight;

        public Candidate(Edge<T> edge, int totalWeight) {
            this.edge = edge;
            this.totalWeight = totalWeight;
        }

        public int compareTo(Candidate<T> cand) {
            return totalWeight - cand.totalWeight;
        }

    }

    private static <T> ArrayList<Edge<T>> getPath(T from, T to, HashMap<T,Edge<T>> visited) {
        ArrayList<Edge<T>> path = new ArrayList<Edge<T>>();
        Edge<T>  edge = visited.get(to);
        while( edge != null ) {
            path.add(0,edge);
            edge = visited.get(edge.getFrom());
        }
        return path;
    }
}


