// Wrist clock with a drift of 0.000034722. Part of the Digital Clock group.
public class WristClock extends DigitalClock {
  public WristClock(){
    super("Wrist Clock", 0.000034722);
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