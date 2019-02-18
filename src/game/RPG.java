package game;

/**
 * This is the main class where development starts!
 */
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class RPG {
  public static void main(String[] args) throws IOException {
    //First we need to set up interaction through the console.
    //Make sure to refer to this in order to know how to use the console!
    //https://docs.oracle.com/javase/tutorial/essential/io/cl.html
    Console console = System.console();
    //Something bad happened. We don't have access to the system console.
    if(console == null) {
      //For now, just quit the program.
      return;
    }
    //Get a way to print to the console.
    PrintWriter pw = console.writer();
    //Create a new game!
    Game game = new Game(RandomGenerator.getGameWorld(6));
    pw.println("Welcome to a new game!");
    //Begin the game loop here!
    boolean keepPlaying = true;
    while(keepPlaying) {
      String input = console.readLine(">");
      String response = game.sendInput(input);
      if(response.equals("QUIT")) {
        keepPlaying = false;
        pw.println("Thanks for playing.");
      }
      else {
        pw.println(response);
      }
    }
  }
}
