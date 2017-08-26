package game;

/**
 * Class represents a generic item in the game.
 */
public class Item extends GameObject {
  public Item(String name, String description) {
    super(name, description);
  }

  public boolean equals(Object o) {
    if(o instanceof Item) {
      Item i = (Item) o;
      return super.equals(i);
    }
    else {
      return false;
    }
  }
}
