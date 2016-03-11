package f14;

/**
 * Klassen Edge representerar en båge mellan två noder i en riktad graf. En båge
 * har en vikt vilken anges vid konstruktion.
 * 
 * @author tsroax
 */
public class Edge<T> implements Comparable<Edge<T>> {
    private T from;
    private T to;
    private int weight;

    /**
     * Konstruktion av ett Edge-objekt.
     * 
     * @param from Den nod där bågen startar
     * @param to Den nod där bågen slutar
     * @param weight Bågens vikt
     */
    public Edge(T from, T to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    /**
     * Returnerar startnod för bågen.
     * 
     * @return returnerar startnod för bågen
     */
    public T getFrom() {
        return from;
    }

    /**
     * Returnerar slutnoden för bågen.
     * 
     * @return returnerar slutnod för bågen
     */
    public T getTo() {
        return to;
    }

    /**
     * Returnerar bågens vikt.
     * 
     * @return returnerar bågens vikt
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Returnerar en strängrepresentation för bågen på formen: <br>
     * <code>"Edge, from=node1, to=node2, weight=vikt</code>
     * 
     * @return returnerar en strängrepresentation för bågen
     */
    public String toString() {
        return "Edge, from=" + from + ", to=" + to + ", weight=" + weight;
    }

    /**
     * Metod för att jämför två Edge-objekt. Två Edge-objekt är lika om de
     * startar i samma nod och slutar i samma nod.
     * 
     * @param obj Edge-objekt att jämföra med
     * @return true om objekten är lika, annars false
     */
    public boolean equals(Object obj) {
        Edge<T> edge;
        boolean res = false;
        if (obj instanceof Edge ) {
            edge = (Edge<T>) obj;
            res = this.from.equals(edge.from) && this.to.equals(edge.to);
        }
        return res;
    }
    
    /**
     * Metoden jämför två Edge-objekt avseende weight och returnerar:
     * <0 om aktuellt objekt har lägst weight
     * 0  om objekten har samma weight
     * >0 om argumentet har lägst weight
     * @param e Edge-objektet att jämför weight med
     * @return metoden returnerar:
     * <0 om aktuellt objekt har lägst weight
     * 0  om objekten har samma weight
     * >0 om argumentet har lägst weight
     */
    public int compareTo(Edge<T> e) {
    	return this.weight-e.weight;
    }
}
