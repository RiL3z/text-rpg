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
  // words that indicate that the player would like to gracefully quit the game
  private List<String> quitWords;
  // words that indicate the player wants to know about objects in the room
  private List<String> objectsWords;
  /**
   * Construct a new game object.
   *
   * @param startLocation the starting location for the player in the game
   */
  public Game() {
    initCommands();
    setupGameWorld();
  }

  /**
   * Method sets up default commands that the game will recognize
   */
  private void initCommands() {
    initMoveWords();
    initViewWords();
    initExitWords();
    initQuitWords();
    initObjectsWords();
    commands = new Command[5];
    commands[0] = new Command(moveWords, Command.Actions.MOVE);
    commands[1] = new Command(viewWords, Command.Actions.VIEW);
    commands[2] = new Command(exitWords, Command.Actions.EXITS);
    commands[3] = new Command(quitWords, Command.Actions.QUIT);
    commands[4] = new Command(objectsWords, Command.Actions.OBJECTS);
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
    String[] words = {"exits", "paths", "ways", "outs", "out"};
    exitWords = new ArrayList<>();

    for(String word: words) {
      exitWords.add(word);
    }
  }

  public void initQuitWords() {
    String[] words = {"quit", "stop", "exit"};
    quitWords = new ArrayList<>();

    for(String word: words) {
      quitWords.add(word);
    }
  }

  public void initObjectsWords() {
    String[] words = {"object", "objects", "item", "items", "thing", "things"};
    objectsWords = new ArrayList<>();

    for(String word: words) {
      objectsWords.add(word);
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


    // find if any word in the input the user sent matches a command
    String[] words = cmd.split(" ");

    for(String word: words) {
      for(Command c: commands) {
        if(c.recognize(word)) {
          foundCommand = true;
          action = c.getAction();
          break;
        }
      }
    }

    if(foundCommand) {
      switch(action) {
        case MOVE: {
          Vertex<Location>[] outVerts = gw.outGoingVertices(p.getLocation());
          Vertex<Location> moveVert = null;
          boolean found = false;
          for(Vertex<Location> v: outVerts) {
            Location l = v.getElement();
            if(cmd.toLowerCase().contains(l.getName().toLowerCase())) {
              found = true;
              moveVert = v;
              break;
            }
          }

          if(found) {
            StringBuilder sb = new StringBuilder();

            Edge<Transition> edge = gw.getEdge(p.getLocation(), moveVert);
            p.setLocation(moveVert);
            // get the location that the player wants to move to
            Location loc = moveVert.getElement();
            Transition t = edge.getElement();
            sb.append(t.getTransition());

            if(!loc.isVisited()) {
              sb.append("\n" + loc.getDescription());
              loc.setVisited(true);
            }
            return sb.toString();
          }
          else {
            return "That is not a location you can move to.";
          }
        }
        case VIEW: {
          // try to determine if it's the location description or
          // an object description that the player wants
          Location l = p.getLocation().getElement();
          List<GameObject> locationObjects = l.getGameObjects();
          for(String word: words) {
            for(GameObject go: locationObjects) {
              if(word.toLowerCase().equals(go.getName().toLowerCase())) {
                return go.getDescription();
              }
            }
          }

          return l.getDescription();
        }
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
        case OBJECTS: {
          Location l = p.getLocation().getElement();
          ArrayList<GameObject> locationObjects = l.getGameObjects();
          if(locationObjects.size() != 0) {
            StringBuilder objectList = new StringBuilder();

            for(i = 0; i < locationObjects.size(); i ++) {
              if(i != locationObjects.size() - 1) {
                objectList.append(locationObjects.get(i).getName() + "\n");
              }
              else {
                objectList.append(locationObjects.get(i).getName());
              }
            }
            return objectList.toString();
          }
          else {
            return "There are no objects in this location.";
          }
        }
        case QUIT:
          System.out.println("Thanks for playing!");
          System.exit(0);
        default:
          return "player doesn't want to do anything";
      }
    }
    else {
      return "invalid command";
    }
  }

  /*public static int indexOfObjectByName(String[] words, Location loc) {
    int index = -1;
    for(String word: words) {
      index ++;
      if(loc.containsObjectByName(word)) {
        return index;
      }
    }
    return index;
  }*/

  public void setupGameWorld() {
    // first create the graph of areas and transitions
    gw = new GameWorld("Test World", "A test world.");

    Location bedroom = new Location("Bedroom", "A small bedroom with a computer and bookshelf.", getBedroomObjects());
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

  private ArrayList<GameObject> getBedroomObjects() {
    ArrayList<GameObject> locationItems = new ArrayList<>();
    Item bed = new Item("Bed", "A small bed meant for a single person.");
    Item computer = new Item("Computer", "An expensive computer meant for gaming.");
    Item[] items = {bed, computer};

    for(Item item: items) {
      locationItems.add(item);
    }

    return locationItems;
  }
}
