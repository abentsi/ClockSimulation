// Radio clock with a drift of 0.000016. Part of the Electric Clock group.
public class RadioClock extends ElectricClock {
  public RadioClock(){
    // Radio clocks drift very slightly but typically correct themselves daily. Some radio clocks update even more frequently.
    super("Radio Clock", 0.000016);
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