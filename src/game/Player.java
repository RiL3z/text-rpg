package game;

import net.datastructures.Vertex;
/**
 * All state for a player should be kept here.
 */
public class Player extends Character {
  public Player(String name, Vertex<Location> loc) {
    super(name, loc);
  }
}
