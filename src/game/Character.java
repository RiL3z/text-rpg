package game;

import net.datastructures.Vertex;
/**
 * General class for characters in the game.
 */
public class Character {
  private String name;
  private Vertex<Location> loc;
  // every player has an inventory of items they can carry
  private Inventory inventory = new Inventory();

  public Character(String name, Vertex<Location> loc) {
    this.name = name;
    this.loc = loc;
  }

  // some characters locations may not be known initially
  public Character(String name) {
    this.name = name;
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

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  // pick up an item and add it to the inventory of the character
  public void pickUpItem(Item item) {
    this.inventory.addItem(item);
  }

}
