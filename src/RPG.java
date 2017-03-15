/**
 * This is the main class where development starts!
 */
import java.util.Scanner;
import java.io.Console;

public class RPG {
  public static void main(String[] args) {
    //First we need to set up interaction through the console.
    //Make sure to refer to this in order to know how to use the console!
    //https://docs.oracle.com/javase/tutorial/essential/io/cl.html
    Console console = System.console();

    //Something bad happened. We don't have access to the system console.
    if(console == null) {
      //For now, just quit the program.
      return;
    }
    //Begin the game loop here!
    boolean keepPlaying = true;

    while(keepPlaying) {
      System.out.println("Enter some input. Enter 'N' to quit.");
      String input = console.readLine();
      if(input.equals("N")) {
        keepPlaying = false;
      }
    }
    System.out.println("Thanks for playing!");
  }
}
