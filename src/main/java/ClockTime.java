// ClockTime class that handles all of the clock logic. Ticking, calculating the drift and printing are all handled here. 
public class ClockTime{
  // Variables for seconds, minutes, hours, days and years for use in all of the methods within the ClockTime class.
  private int hours, mins, secs, days, years;
  // Variable for driftPerSecond which uses values from the individual clocks.
  private double driftPerSecond;
  // Variable to store the total drift after a certain amount of time.
  private double totalDrift;

  // ClockTime object.
  public ClockTime(double driftPerSecond){
    this.driftPerSecond = driftPerSecond;
  }
  // Reset method. Sets all time-based variables and total drift to 0.
  public void reset(){
    hours = 0;
    mins = 0;
    secs = 0;
    days = 0;
    years = 0;
    totalDrift = 0;
  }
  // Tick method, follows normal time logic.
  public void tick(){
    // If you reach 60 seconds, add one minute and reset the seconds counter..
    secs++;
    if (secs == 60){
      secs = 0;
      mins++;
      // If you reach 60 minutes, add one hour and reset the seconds counter..
      if (mins == 60){
        mins = 0;
        hours++;
        // If you reach 24 hours, add one day. Hours counter isn't reset so that the total hours can be viewed by the user. 
        if (hours % 24 == 0){
          days++;
        // If you reach 365 days, add one year and reset the days counter..
          if(days == 365){
            days = 0;
            years++;
          }
        }
      }
    }
    // For every second, increment driftPerSecond to come up with the total drift.
    totalDrift += driftPerSecond;
    // Special case for radio clocks. Since they reset daily (some even more frequently), their drift doesn't add up. 
    if (driftPerSecond == 0.000016) {
      totalDrift = driftPerSecond * 86400;
    }
    // Special case for tower clocks. They are reset weekly so their drift should reset every 7 days
    if (driftPerSecond == 0.0000228) {
      // days > 7 condition exists so that the user can see how long the tower clock drifts on the inital 1 week run. 
      if (days % 7 == 0 && days > 7) {
        totalDrift = 0;
      }
    }
  }
  // Print method. Prints the values for each clock (time elapsed and total drift, then calls the reset() method.
  public void printTime(){
    // If there aren't any years, only show how many days the clock ran for.
    if(years == 0){
     System.out.printf("%d days [%02d:%02d:%02d] - total drift = %.6f seconds%n", days, hours, mins, secs, totalDrift);
    }
    // If the clock runs for an exact amount of years, only show how many years the clock ran for. (ex: 20 years)
    else if(days % 365 == 0){
      System.out.printf("%d years [%02d:%02d:%02d] - total drift = %.6f seconds%n", years, hours, mins, secs, totalDrift);
    }
    // If the clock runs for some years + some days, show both years and days.
    else{
      System.out.printf("%d years, %d days [%02d:%02d:%02d] - total drift = %.6f seconds%n", years, days, hours, mins, secs, totalDrift);
    }
    // Call to the reset() method. The reset ensures that time isn't just added to the previous clock run. (ex: Program starts with running for 7 days, then user runs it for 5 days after. Without the reset, it would be 12 days.)
    reset();
  }
}