// Tower clock with a drift of 0.0000228. Part of the Mechanical Clock group.
public class TowerClock extends MechanicalClock {
  public TowerClock(){
    // Due to their size and structural integrity, tower clocks are very accurate. They are typically reset weekly.
    super("Tower Clock", 0.0000228);
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