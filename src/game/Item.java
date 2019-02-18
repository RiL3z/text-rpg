package game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class represents a generic item in the game.
 */
public class Item extends GameObject {

  @JsonCreator
  public Item(@JsonProperty("name") String name, @JsonProperty("description") String description) {
    super(name, description);
  }

  public boolean equals(Object o) {
    if(o instanceof Item) {
      Item i = (Item) o;
      return super.equals(i);
    }
    return false;
  }
}
