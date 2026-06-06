// DigitalClock class. The digital clocks (Wrist Clock) will extend to this class.
public abstract class DigitalClock extends Clock {
  public DigitalClock(String name, double driftPerSecond){
    super(name, driftPerSecond);
  }
}