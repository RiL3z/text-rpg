package game;
/**
 * General class for characters in the game.
 */
public class Character {
  private String name;
  private Location loc;

  public Character(String name, Location loc) {
    this.name = name;
    this.loc = loc;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setLocation(Location loc) {
    this.loc = loc;
  }

  public Location getLocation() {
    return loc;
  }

}
