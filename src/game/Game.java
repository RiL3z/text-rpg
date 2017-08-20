package game;

import java.util.List;
import java.util.ArrayList;

/**
 * This class should encapsulate the whole game engine.
 */
public class Game {
  // the gameworld this game refers to
  private GameWorld gw;
  // an array of commands the the game recognizes
  private Command[] commands;
  // words that map to the move action
  private List<String> moveWords;
  // words that map to the view action
  private List<String> viewWords;
  /**
   * Construct a new game object.
   *
   * @param startLocation the starting location for the player in the game
   */
  public Game() {
    initCommands();
  }

  /**
   * Method sets up default commands that the game will recognize
   */
  private void initCommands() {
    initMoveWords();
    initViewWords();
    commands = new Command[2];
    commands[0] = new Command(moveWords, Command.Actions.MOVE);
    commands[1] = new Command(viewWords, Command.Actions.VIEW);
  }

  /**
   * method sets up the move word sequence
   */
  private void initMoveWords() {
    String[] words = {"move", "go", "walk", "travel", "run"};
    moveWords = new ArrayList<>();

    for(String word: words) {
      moveWords.add(word);
    }
  }

  /**
   * method sets up the view word sequence
   */
  private void initViewWords() {
    String[] words = {"look", "view", "inspect", "observe", "scrutinize"};
    viewWords = new ArrayList<>();

    for(String word: words) {
      viewWords.add(word);
    }
  }

  private void move(Character c, Location l) {
    c.setLocation(l);
  }

  /**
   * the game should decide what to do with the user input here
   */
  public String sendCommand(String cmd) {
    // determine if the user input matched any command
    boolean foundCommand = false;
    Command.Actions action = Command.Actions.NONE;
    
    for(Command c: commands) {
      if(c.recognize(cmd)) {
        foundCommand = true;
        action = c.getAction();
      }
    }

    if(foundCommand) {
      switch(action) {
        case MOVE:
          return "player wants to move";

        case VIEW:
          return "player wants to view";
        default:
          return "player doesn't want to do anything";
      }
    }
    else {
      return "invalid command";
    }
  }
}
