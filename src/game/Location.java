package game;

public class Location extends GameObject {
  /**
   * Constructs a new location
   *
   * @param name the name of the location
   * @param description a description of the location
   */

  // keep track of whether or not the location has been visited by
  // the player already or not
  private boolean visited;

  public Location(String name, String description) {
    super(name, description);
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public boolean isVisited() {
    return visited;
  }
}
