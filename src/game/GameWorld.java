package game;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import net.datastructures.Graph;
import net.datastructures.Vertex;
import net.datastructures.Edge;
import net.datastructures.AdjacencyMapGraph;
/**
 * This class represents a room in the game. A room is a collection of
 * rooms.
 */
public class GameWorld extends GameObject {
  private String name;
  private String description;
  private List<Character> characters;
  // a room could have portals in it that are one-way
  private Graph<Location, Transition> g = new AdjacencyMapGraph<>(true);

  /**
   * Construct an area object.
   *
   * @param name the name of the area
   * @param description the description of the area
   */

   public GameWorld(String name, String description) {
     super(name, description);
     characters = new ArrayList<>();
   }

   /**
    * Inserts a location into the area.
    *
    * @param loc the location to add to the area
    * @return the vertex in the graph of the area
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
   public Edge<Transition> insertTransition(Vertex<Location> a, Vertex<Location> b, Transition t) {
     return g.insertEdge(a, b, t);
   }

   public int outDegree(Vertex<Location> loc) {
     return g.outDegree(loc);
   }

   public Iterable<Edge<Transition>> outGoingEdges(Vertex<Location> loc) {
     return g.outgoingEdges(loc);
   }

   public Edge<Transition> getEdge(Vertex<Location> v1, Vertex<Location> v2) {
     return g.getEdge(v1, v2);
   }

   public Vertex<Location>[] endVertices(Edge<Transition> e) {
     return g.endVertices(e);
   }

   /**
    * This method should get an array of all vertices that have edges outgoing
    * from the given vertex.
    */
   public Vertex<Location>[] outGoingVertices(Vertex<Location> v) {
     Vertex<Location>[] verts = (Vertex<Location>[]) new Vertex[g.outDegree(v)];

     int i = 0;
     for(Edge<Transition> e: g.outgoingEdges(v)) {
       Vertex<Location>[] endpoints = g.endVertices(e);
       Vertex<Location> outV = endpoints[1];
       verts[i] = outV;
       i ++;
     }

     return verts;
   }

   /**
    * Each area can have a set of characters associated with it.
    */
   public void addCharacter(Character c) {
     characters.add(c);
   }

   public void move(Character c, Vertex<Location> v) {
     c.setLocation(v);
   }
}
