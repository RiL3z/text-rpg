package game;

import net.datastructures.Graph;
import net.datastructures.AdjacencyMapGraph;

/**
 * Class contains the game world.
 *
 */
public class GameWorld extends GameObject {
  private Player p;
  private Location playerLocation;
  private Graph<Area, Portal> g = new AdjacencyMapGraph<>(true);

  public GameWorld(String name, String description, Player p, Graph<Area, Portal> world) {
    super(name, description);
    this.p = p;
    g = world;
  }

  public void setPlayerLocation(Location playerLocation) {
    this.playerLocation = playerLocation;
  }

  public void setPlayer(Player p) {
    this.p = p;
  }

  public Player getPlayer() {
    return p;
  }
}
