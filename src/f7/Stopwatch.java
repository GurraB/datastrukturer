package f7;
/**
 * Klassen kan användas för att mäta tid. Metoden <code>start()</code> anropas
 * för att starta tidtagningen och metoden <code>stop()</code> anropas för att
 * avsluta tidtagningen.
 * @author Rolf Axelsson
 */
public class Stopwatch {
    private long startTime;
    private long stoptime;
    private boolean start = false;
    
    /**
     * Anropa <code>start()</code> då tidtagningen ska börja.
     */
    public void start() {
    	this.startTime = System.currentTimeMillis();
        this.stoptime = this.startTime;
        start = true;
    }
    
    /**
     * Anropa <code>stop()</code> då tidtagningen ska avslutas.
     */
    public void stop() {
    	this.stoptime = System.currentTimeMillis();
    }
    
    /**
     * Metoden returnerar antalet millisekunder det gått mellan senaste anropet
     * till <code>start()</code>  och senaste anropet till <code>stop()</code>.
     * @return antalet millisekunder det gått mellan senaste anropet till
     *         <code>start()</code>  och senaste anropet till <code>stop()</code>.<br>
     *         Om <code>start()</code> ej anropats returneras värdet 0.<br>
     *         Om <code>stop()</code> ej anropats efter <code>start()</code>
     *         returneras värdet 0.
     */
    public long getMilliseconds() {
        if(start==true)
            return (this.stoptime-this.startTime);
        else
            return 0;
    }
    
    /**
     * Metoden returnerar antalet sekunder det gått mellan senaste anropet
     * till <code>start()</code>  och senaste anropet till <code>stop()</code>.
     * @return antalet sekunder det gått mellan senaste anropet till
     *         <code>start()</code>  och senaste anropet till <code>stop()</code>.<br>
     *         Om <code>start()</code> ej anropats returneras värdet 0.<br>
     *         Om <code>stop()</code> ej anropats efter <code>start()</code>
     *         returneras värdet 0.
     */
    public double getSeconds() {
        return getMilliseconds()/1000.0;
    }
}