package f13;

public class StopWatch {
	  private long timeStart;
	  private long timeStop;

	  public void start() {
	    timeStart = timeStop = System.currentTimeMillis();
	  }

	  public void stop() {
	    timeStop = System.currentTimeMillis();
	  }

	  public long getMilliseconds() {
	    return timeStop-timeStart;
	  }

	  public double getSeconds() {
	    return (timeStop-timeStart)/1000.0;
	  }
	}