/*
  Program name: Clocks Final
  Description: Runs a simulation of 1 week for various clocks with different drifts. Following the simulation, the program takes user input for an amount of time the user wants to simulate.
  Developers: Abraham Ntsi & Alejandro Joya
  Class: CIS 131 Data Structures using Java.
  Date: May 30th, 2025
  Program version: 2.5
*/

// ArrayList to store clock names.
import java.util.ArrayList;
// Scanner for user input.
import java.util.Scanner;
// Random number generator for Water Clock temeperatures.
import java.util.Random;

public class Main {
  // The amount of seconds in a week used for the programs inital simulation.
  public static final int SECS_PER_WEEK = 604800;
  // Will store the user's input for how many days they want to run the simulation.
  public static int userTime;
  // Creating the Scanner object.
  public static Scanner scnr = new Scanner(System.in);

  // getInt class. Regulates user input and does exception handling. 
  public static int getInt() {
    // Boolean used in the for loop.
    boolean valid = false;
    // Takes the user's integer as a string.
    String userInput;
    // Will store the user's integer using the parseInt function.
    int userInt;
    
    while (valid == false) {
      userInput = scnr.nextLine();
      try {
        userInt = Integer.parseInt(userInput);
        // Doesn't take integers that are 0 or lower.
        if (userInt <= 0) {
          System.out.println("Invalid input. Please input a valid number greater than 0.");
        }
        // Doesn't take integers higher than 24,855, as the second count would be higher than Java's maximum integer value (2,147,483,647). Program will exhibit improper values if you type anything higher.
        else if (userInt > 24855) {
          System.out.println("Invalid input. Any number greater than 24,855 yields a second count that's higher than Java's integer limit (2,147,483,647). Please input a lower number.");
        }
        // If the user inputs a valid number, return that number. 
        else {
          return userInt;
        }
      } 
      // Catches the NumberFormatException if user doesn't input an integer.
      catch (Exception e) {
        System.out.println("Invalid input. Please input a valid integer.");
      }
    }
    // Return statement outside the loop for a non-void type method. Will never be reached. 
    return -1;
  }

  // Main. Initalizes the clocks and runs the first simulation, then handles the user input.
  public static void main(String[] args) throws InterruptedException{
    // ArrayList to store each of the clocks tha will be used in the 'for' loops.
    ArrayList<Clock> clockList = new ArrayList<>();
    clockList.add(new SundialClock());
    clockList.add(new CuckooClock());
    clockList.add(new GrandFatherClock());
    clockList.add(new WristClock());
    clockList.add(new AtomicClock());
    clockList.add(new WaterClock());
    clockList.add(new QuartzClock());
    clockList.add(new RadioClock());
    clockList.add(new TowerClock());
    clockList.add(new test());

    // Displays the time of each clock when reset which is currently at 00:00:00.
    System.out.println("Reported clock times after resetting:\n=====================================");
    for (Clock clocks: clockList){
      clocks.displayTime();
    }
    
    // Runs each of the clocks for 604,800 ticks, or one week.
    System.out.println("\nRunning the clocks for one (1) week...\n");
    for(int i = 0; i < SECS_PER_WEEK; i++){
      for(Clock clocks: clockList){
        clocks.tick();
      } 
    }
    Thread.sleep(1000);
    // Displays the times/drift of each clock.
    System.out.println("Reported clock times after running:\n=====================================");
    for(Clock clocks: clockList){
      clocks.displayTime();
      Thread.sleep(175);
    }

    // Boolean used in the for loop.
    boolean run = true;
    // String to take user's "yes" or "no" answers.
    String yesNo = "";
    // Java label for the first loop. Will be used to break this loop if the user closes the program.
    firstLoop:
    // Will run until the user closes the program. 
    while (run == true) {
      //Temp variable for the user input so that it can be compared in the if statements for the delays
      int tempTime;
      // Ask the user how many days they want to run the clocks for.
      System.out.println("\nHow many days would you like the clock to run for?");
      // Use the getInt() method so that exceptions are handled and input is regulated.
      userTime = getInt();
      tempTime = userTime;
      // If the user puts a single day, output "day" instead of "days." Otherwise, just put "days."
      if (userTime == 1) {
        System.out.println("\nRunning the clocks for " + userTime + " day...\n");
      }
      else {
        System.out.println("\nRunning the clocks for " + userTime + " days...\n");
      }
      // Multiplies the user's amount of days by the amount of seconds in a day (86,400).
      userTime = userTime * 86400;
      
      if(tempTime >= 5000){
        Thread.sleep(1000);
        System.out.println("Ah man, this is gonna take me a while..\n");
      }
      // Ticks each clock for the appropriate amount of seconds. (ex: One day ticks 86,400 times.)
      for(int i = 0; i < userTime;i++){
        for(Clock clocks: clockList){
          clocks.tick();
        }
      }
      // Sleep timers in order to delay displays depending on the amount of days the user (a week, a month, more than 1000, and more than 5000) inputs using if statements.
      if(tempTime <= 7){
      Thread.sleep(1000);
      }
      else if(tempTime > 7 && tempTime <= 999){
        Thread.sleep(2000);
      }
      else if(tempTime >= 1000 && tempTime <= 4999){
        System.out.println("Wow, that's a lot of days, almost done...");
        Thread.sleep(2000);
        System.out.println("\nThere!\n");
        Thread.sleep(100);
      }
      else{
        System.out.println("Do humans even live this long?!\n");
        Thread.sleep(2500);
        System.out.println("Finally! Here we go..\n");
        Thread.sleep(100);
      }
      System.out.println("Reported clock times after running:\n=====================================");
      
      // Displays the time/drift for each of the clocks.
      for(Clock clocks: clockList){
        clocks.displayTime();
        Thread.sleep(175);
      }
      // Boolean for the second while loop.
      boolean restart = true;
      // Restart will be set false every time the user says yes, which breaks this loop and sends them back to the first one. 
      while (restart == true) {
        System.out.println("\nWould you like to run the clocks again?");
        yesNo = scnr.nextLine();
        // If the user says no, display a goodbye message and end the program.
        if (yesNo.toLowerCase().equals("no") || yesNo.toLowerCase().equals("n")) {
          System.out.println("Goodbye! Let's spend more time together another day!"); 
          // Using a label, you can break the first loop so that the program ends. If you just break this loop, it's no different than if the user says "yes."
          break firstLoop;
        }
        // As mentioned earlier, if the user says yes, send the user back to the first loop. 
        else if (yesNo.toLowerCase().equals("yes") || yesNo.toLowerCase().equals("y")) {
          restart = false;
        }
        // If the user doesn't say yes or no, display an error.
        else {
          System.out.println("Invalid input. Please type yes to continue, or no to close the program. (y/n)");
        }
      }
    }
    clockList.clear();
  }
}