// Grandfather clock with a drift of 0.000347222. Part of the Mechanical Clock group.
public class GrandFatherClock extends MechanicalClock {
  public GrandFatherClock(){
    super("Grandfather Clock", 0.000347222);
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