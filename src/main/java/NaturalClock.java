// NaturalClock class. The natural clocks (Sundial Clock and Water Clock) will extend to this class.
public abstract class NaturalClock extends Clock {
  public NaturalClock(String name, double driftPerSecond){
    super(name, driftPerSecond);
  }
}