// Cuckoo clock with a drift of 0.000694444. Part of the Mechanical Clock group.
public class CuckooClock extends MechanicalClock {
  // Creates the CuckooClock object
  public CuckooClock(){
    // Directly uses the Clock method in Clock.java to create a new object.
    super("Cuckoo Clock", 0.000694444);
  }
  // Implementing the 3 abstract methods Clock.java. This will be done for every single clock.
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