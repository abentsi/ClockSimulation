// Atomic clock which has no drift. Part of the Quantum Clock group.
public class AtomicClock extends QuantumClock {
  public AtomicClock(){
    super("Atomic Clock", 0.0);
  }
  public void reset(){
    clockTime.reset();
  }
  public void tick(){
    clockTime.tick();
  }
  public void displayTime(){
    System.out.print(name + ": ");
    clockTime.printTime();
  }
}