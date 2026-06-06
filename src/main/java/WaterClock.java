// Water clock with variable drift based on the temperature. Part of the Natural Clock group.
import java.util.Random;

public class WaterClock extends NaturalClock{
  private static Random rand = new Random();
  // Random temperature in the range of 20 to 30 degrees Celsius. 
  public static double celsius = rand.nextDouble(10) + 20;
  
  public WaterClock(){
    // From 20 to 30 degrees Celsius, a change of 1 degree changes the viscosity of the water about 2 percent, shifting the clock about 30 minutes. In other words, they are pretty inaccurate. 
    super("Water Clock", celsius * 0.02);
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