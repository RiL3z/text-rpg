package game;

import net.datastructures.Graph;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Vertex;
import net.datastructures.Edge;

import java.util.List;
import java.util.ArrayList;

/**
 * This class should encapsulate the whole game engine.
 */
public class Game {
  // the gameworld this game refers to
  private GameWorld gw;
  // game needs a reference to the player
  private Player p;
  // an array of commands the the game recognizes
  private Command[] commands;
  // words that map to the move action
  private List<String> moveWords;
  // words that map to the view action
  private List<String> viewWords;
  // words that indicate the player wants to list all the visible locations
  // they can go to
  private List<String> exitWords;
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
    initExitWords();
    commands = new Command[3];
    commands[0] = new Command(moveWords, Command.Actions.MOVE);
    commands[1] = new Command(viewWords, Command.Actions.VIEW);
    commands[2] = new Command(exitWords, Command.Actions.EXITS);
    setupGameWorld();
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

  private void initExitWords() {
    String[] words = {"exits", "paths", "ways", "outs"};
    exitWords = new ArrayList<>();

    for(String word: words) {
      exitWords.add(word);
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
          return p.getLocation().getDescription();
        case EXITS:
          return "player is looking for exits";
        default:
          return "player doesn't want to do anything";
      }
    }
    else {
      return "invalid command";
    }
  }

  public void setupGameWorld() {
    Location l = new Location("bed", "A small twin bed.");
    p = new Player("Kelan", l);
    gw = new GameWorld("Test World", "A test world.", p);
    // first create the graph of areas and transitions
    Area bedroom = new Area("Bedroom", "A small bedroom with a computer and bookshelf.");
    Area hallway = new Area("Hallway", "A narrow hallway leading to a kitchen.");

    Transition t1 = new Transition("You move from the bedroom to the kitchen.");
    Transition t2 = new Transition("You move from the kitche to the bedroom.");

    Vertex<Area> v1 = gw.insertArea(bedroom);
    Vertex<Area> v2 = gw.insertArea(hallway);

    gw.insertTransition(v1, v2, t1);
    gw.insertTransition(v2, v1, t2);
  }
}
