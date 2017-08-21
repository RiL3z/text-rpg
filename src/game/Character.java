package game;

import net.datastructures.Vertex;
/**
 * General class for characters in the game.
 */
public class Character {
  private String name;
  private Vertex<Location> loc;

  public Character(String name, Vertex<Location> loc) {
    this.name = name;
    this.loc = loc;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLocation(Vertex<Location> loc) {
    this.loc = loc;
  }

  public Vertex<Location> getLocation() {
    return loc;
  }

}
