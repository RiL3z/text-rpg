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
  // a game needs a GameCommands instance
  private GameCommands gcs = new GameCommands();
  /**
   * Construct a new game object.
   *
   * @param startLocation the starting location for the player in the game
   */
  public Game() {
    setupGameWorld();
  }

  /*
  private void move(Character c, Location l) {
    c.setLocation(l);
  }*/

  /**
   * the game should decide what to do with the user input here
   */
  public String sendCommand(String cmd) {
    Command.Actions action = gcs.getCommandAction(cmd);

    switch(action) {
      case MOVE:
        return move(cmd);
      case VIEW:
        return view(cmd);
      case EXITS:
        return exits();
      case OBJECTS:
        return objects();
      case QUIT:
        System.out.println("Thanks for playing!");
        System.exit(0);
      default:
        return "that command is not recognized";
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

  public Vertex<Location> determineMoveLocation(String cmd) {
    Vertex<Location>[] outVerts = gw.outGoingVertices(p.getLocation());
    Vertex<Location> moveVert = null;
    for(Vertex<Location> v: outVerts) {
      Location l = v.getElement();
      if(StringUtilities.contains(cmd, l.getName())) {
        moveVert = v;
        break;
      }
    }
    return moveVert;
  }

  public String moveString(Vertex<Location> moveVert) {
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

  public String move(String cmd) {
    Vertex<Location> moveVert = determineMoveLocation(cmd);

    if(moveVert != null) {
      return moveString(moveVert);
    }
    else {
      return "That is not a location you can move to.";
    }
  }

  public String view(String cmd) {
    String[] words = cmd.split("\\s+");
    // try to determine if it's the location description or
    // an object description that the player wants
    Location l = p.getLocation().getElement();
    List<GameObject> locationObjects = l.getGameObjects();
    for(String word: words) {
      for(GameObject go: locationObjects) {
        if(StringUtilities.contains(go.getName(), word.toLowerCase())) {
          return go.getDescription();
        }
      }
    }

    return l.getDescription();
  }

  public String exits() {
    // list all the exits that are available for the player
    StringBuilder exitList = new StringBuilder("List of exits:\n");

    int i = 0;
    Vertex<Location>[] outVertices = gw.outGoingVertices(p.getLocation());

    for(Vertex<Location> v: outVertices) {
      if(i != outVertices.length - 1) {
        exitList.append(v.getElement().getName() + "\n");
      }
      else {
        exitList.append(v.getElement().getName());
      }
      i ++;
    }
    return exitList.toString();
  }

  public String objects() {
    Location l = p.getLocation().getElement();
    ArrayList<GameObject> locationObjects = l.getGameObjects();
    if(locationObjects.size() != 0) {
      StringBuilder objectList = new StringBuilder();

      for(int i = 0; i < locationObjects.size(); i ++) {
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

  public void quit() {

  }

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
    Item bed1 = new Item("Big Bed", "A BIG bed meant for whole bunches of people.");
    Item computer = new Item("Computer", "An expensive computer meant for gaming.");
    Item[] items = {bed, bed1, computer};

    for(Item item: items) {
      locationItems.add(item);
    }

    return locationItems;
  }
}
