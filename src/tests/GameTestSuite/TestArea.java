package test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;

import net.datastructures.Vertex;
import net.datastructures.Edge;

import game.Location;
import game.Transition;
import game.Character;
import game.Player;

public class TestArea {
/*
  private static Area a;
  private static Vertex<Location> bed;
  private static Vertex<Location> computer;
  private static Vertex<Location> bookshelf;
  private static Player p;

  @BeforeClass
  public static void SetupArea() {
    a = new Area("bedroom", "It's my bedroom. There's a pc in the corner and a book shelf near the entrance.");
    Location l1 = new Location("bed", "It's a small twin bed.");
    p = new Player("Kelan", l1);
    Location l2 = new Location("computer", "It's a desktop computer.");
    Location l3 = new Location("bookshelf", "It's a small bookshelf.");

    Vertex<Location> v1 = a.insertLocation(l1);
    bed = v1;
    Vertex<Location> v2 = a.insertLocation(l2);
    computer = v2;
    Vertex<Location> v3 = a.insertLocation(l3);
    bookshelf = v3;

    Transition t1 = new Transition("You go from the computer to the bed.");
    Transition t2 = new Transition("You go from the bed to the computer.");

    Transition t3 = new Transition("You go from the computer to the bookshelf.");
    Transition t4 = new Transition("You go from the the bookshelf to the computer.");

    Transition t5 = new Transition("You go from the bed to the bookshelf.");
    Transition t6 = new Transition("You go from the bookshelf to the bed.");

    Edge<Transition> e1 = a.insertTransition(v1, v2, t2);
    Edge<Transition> e2 = a.insertTransition(v2, v1, t1);

    Edge<Transition> e3 = a.insertTransition(v2, v3, t3);
    Edge<Transition> e4 = a.insertTransition(v3, v2, t4);

    Edge<Transition> e5 = a.insertTransition(v1, v3, t5);
    Edge<Transition> e6 = a.insertTransition(v3, v1, t6);
  }

  /**
   * Simulate moving from location to location.
   */
/*
  @Test
  public void TestArea() {
    // just check that the number of outgoing edges makes sense
    assertEquals(2, a.outDegree(bed));

    // check that the outgoing edges from the start location make sense
    Transition t = a.getEdge(bed, computer).getElement();
    assertEquals("You go from the bed to the computer.", t.getTransition());

    t = a.getEdge(bed, bookshelf).getElement();
    assertEquals("You go from the bed to the bookshelf.", t.getTransition());

    // move the player to a different location
    a.move(p, computer);
    assertEquals(computer.getElement(), p.getLocation());
  }
*/
}
