package game;

import java.util.List;
import java.util.ArrayList;

public class Location extends GameObject {
  // keep track of whether or not the location has been visited by
  // the player already or not
  private boolean visited;
  // every location has a list of game objects that are inside of it
  private ArrayList<GameObject> gameObjects = new ArrayList<>();
  /**
   * Constructs a new location
   *
   * @param name the name of the location
   * @param description a description of the location
   */
  public Location(String name, String description) {
    super(name, description);
  }

  public Location(String name, String description, ArrayList<GameObject> gameObjects) {
    super(name, description);
    this.gameObjects = gameObjects;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public boolean isVisited() {
    return visited;
  }

  public ArrayList<GameObject> getGameObjects() {
    return gameObjects;
  }

  // specifically get the items in the room
  public ArrayList<Item> getItems() {
    ArrayList<Item> items = new ArrayList<>();
    for(GameObject go: gameObjects) {
      if(go instanceof Item) {
        items.add((Item) go);
      }
    }
    return items;
  }

  public void setGameObjects(ArrayList<GameObject> gameObjects) {
    this.gameObjects = gameObjects;
  }

  // returns the index of the object that goes by a certain name
  public int indexOfObjectByName(String name) {
    int index = -1;
    for(GameObject go: gameObjects) {
      index ++;
      if(name.toLowerCase().equals(go.getName().toLowerCase())) {
        return index;
      }
    }
    return index;
  }

  // remove an item from the gameobjects in the location
  public Item removeOneItem(Item item) {
    for(GameObject go: gameObjects) {
      if(item.equals(go)) {
        gameObjects.remove(item);
        return item;
      }
    }
    return null;
  }

  public String toString() {
    return String.format("harhar");
  }
}
