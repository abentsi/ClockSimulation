// MechanicalClock class. The mechanical clocks (Cuckoo Clock, Grandfather Clock and Tower Clock) will extend to this class.
public abstract class MechanicalClock extends Clock {
  public MechanicalClock(String name, double driftPerSecond){
    super(name, driftPerSecond);
  }
}
// Sundial clock which has no drift. Part of the Natural Clock group.
class test extends MechanicalClock{
  public test(){
    super("test", 0.06598);
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