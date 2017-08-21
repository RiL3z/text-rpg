package game;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import net.datastructures.Graph;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Vertex;
import net.datastructures.Edge;

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

  /*
  private void move(Character c, Location l) {
    c.setLocation(l);
  }*/

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
          return p.getLocation().getElement().getDescription();
        case EXITS:
          // list all the exits that are available for the player
          StringBuilder exitList = new StringBuilder("List of exits:\n");

          int i = 0;
          Vertex<Location>[] outVertices = gw.outGoingVertices(p.getLocation());

          for(Vertex<Location> v: outVertices) {
            if( i != outVertices.length - 1) {
              exitList.append(v.getElement().getName() + "\n");
            }
            else {
              exitList.append(v.getElement().getName());
            }
            i ++;
          }

          return exitList.toString();
        default:
          return "player doesn't want to do anything";
      }
    }
    else {
      return "invalid command";
    }
  }

  public void setupGameWorld() {
    gw = new GameWorld("Test World", "A test world.");
    // first create the graph of areas and transitions
    Location bedroom = new Location("Bedroom", "A small bedroom with a computer and bookshelf.");
    Location hallway = new Location("Hallway", "A narrow hallway leading to a living room and a bedroom");
    Location livingRoom = new Location("Living Room", "A kitchen and living room.");

    Transition t1 = new Transition("You move from the bedroom to the hallway.");
    Transition t2 = new Transition("You move from the hallway to the bedroom.");
    Transition t3 = new Transition("You move from the hallway to the living room.");
    Transition t4 = new Transition("You move from the living room to the hallway.");

    Vertex<Location> v1 = gw.insertLocation(bedroom);
    Vertex<Location> v2 = gw.insertLocation(hallway);
    Vertex<Location> v3 = gw.insertLocation(livingRoom);

    p = new Player("Kelan", v2);

    gw.insertTransition(v1, v2, t1);
    gw.insertTransition(v2, v1, t2);
    gw.insertTransition(v2, v3, t3);
    gw.insertTransition(v3, v2, t4);
  }
}
