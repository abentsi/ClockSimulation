// Quartz clock with a drift of 0.0000058. Part of the Electric Clock group.
public class QuartzClock extends ElectricClock {
  public QuartzClock(){
    // Quartz clocks are incredibly accurate and only lose about half a second per day.
    super("Quartz Clock", 0.0000058);
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