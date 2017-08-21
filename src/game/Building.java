package game;

import net.datastructures.Graph;
import net.datastructures.AdjacencyMapGraph;
/**
 * A building is just a collection of interconnected rooms.
 *
 * @author Kelan Riley
 */
public class Building {
  // create a graph that is directed because there may be one-way paths
  Graph<Location, String> g = new AdjacencyMapGraph<>(true);
  public Building() {

  }
}
