package game;

import net.datastructures.Graph;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Vertex;
import net.datastructures.Edge;

/**
 * Class contains the game world.
 *
 */
public class GameWorld extends GameObject {
  private Player p;
  private Graph<Area, Transition> g = new AdjacencyMapGraph<>(true);

  public GameWorld(String name, String description, Player p) {
    super(name, description);
    this.p = p;
  }

  public void setPlayer(Player p) {
    this.p = p;
  }

  public Player getPlayer() {
    return p;
  }

  public Vertex<Area> insertArea(Area area) {
    return g.insertVertex(area);
  }

  public Edge<Transition> insertTransition(Vertex<Area> a, Vertex<Area> b, Transition t) {
    return g.insertEdge(a, b, t);
  }
}
