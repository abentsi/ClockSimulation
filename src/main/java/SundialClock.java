// Sundial clock which has no drift. Part of the Natural Clock group.
public class SundialClock extends NaturalClock{
  public SundialClock(){
    super("Sundial Clock", 0.0);
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