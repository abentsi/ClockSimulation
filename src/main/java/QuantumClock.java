// QuantumClock class. The quantum clocks (Atomic Clock) will extend to this class.
public abstract class QuantumClock extends Clock {
  public QuantumClock(String name, double driftPerSecond){
    super(name, driftPerSecond);
  }
}