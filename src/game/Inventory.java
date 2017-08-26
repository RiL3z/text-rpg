package game;

import java.util.List;
import java.util.ArrayList;
/**
 * This class represents an item inventory that a player carries
 * around.
 */
public class Inventory {
  // a list of items a character is keeping in their inventory
  List<Item> inventory = new ArrayList<Item>();
  
  public Inventory() {

  }

  public boolean addItem(Item item) {
    return inventory.add(item);
  }

  // takes an index and returns the removed item
  public Item removeItem(int index) {
    return inventory.remove(index);
  }

  // takes an object and returns whether or not the specified
  // item was removed
  public boolean removeItem(Item item) {
    return inventory.remove(item);
  }

  public Item getItem(int index) {
    return inventory.get(index);
  }

  public int size() {
    return inventory.size();
  }
}
