// Abstract Clock class. Creates Clock object and provdes the foundation for other Clock classses.
public abstract class Clock {
  // Protected name variable.
  protected String name;
  // Protected object using the ClockTime class. Allows other classes to use methods defined in ClockTime.
  protected ClockTime clockTime;
  // Creates the Clock object with parameters for name and drift per second.
  public Clock(String name, double driftPerSecond) {
    this.name = name;
    this.clockTime = new ClockTime(driftPerSecond);
  }

  // Abstract reset(), tick(), and displayTime() methods. Serves as the foundation for other clock classes. 
  public abstract void reset();
  public abstract void tick();
  public abstract void displayTime();
}