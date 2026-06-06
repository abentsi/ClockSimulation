// ElectricClock class. The electric clocks (Quartz Clock and Radio Clock) will extend to this class.
public abstract class ElectricClock extends Clock {
  public ElectricClock(String name, double driftPerSecond){
    super(name, driftPerSecond);
  }
}