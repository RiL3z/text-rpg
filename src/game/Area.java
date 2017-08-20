package game;

import net.datastructures.Graph;
import net.datastructures.Vertex;
import net.datastructures.AdjacencyMapGraph;
/**
 * This class represents a room in the game. A room is a collection of
 * rooms.
 */
public class Area extends GameObject {
  private String name;
  private String description;
  // a room could have portals in it that are one-way
  private Graph<Location, Portal> g = new AdjacencyMapGraph<>(true);

  /**
   * Construct a room object.
   *
   * @param name the name of the room
   * @param description the description of the room
   */

   public Area(String name, String description) {
     super(name, description);
   }

   /**
    * Inserts a location into the room.
    *
    * @param loc the location to add to the room
    * @return the vertex in the graph of the room
    */
   public Vertex<Location> insertLocation(Location loc) {
     return g.insertVertex(loc);
   }

   /**
    * Inserts a portal in between two locations.
    *
    * @param a a vertex containing a location
    * @param b a vertex containing a location
    * @param p the portal that goes from location a to location b (one
    * direction)
    */
   public void insertPortal(Vertex<Location> a, Vertex<Location> b, Portal p) {
     g.insertEdge(a, b, p);
   }
}
