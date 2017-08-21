package test;

import org.junit.BeforeClass;
import org.junit.Test;

import net.datastructures.Graph;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.Vertex;
import net.datastructures.Edge;

import game.GameWorld;
import game.Location;
import game.Transition;
import game.Area;
import game.Player;

public class GameWorldTest {
  private static GameWorld gw;
  private static Player p;

  @BeforeClass
  public static void setupGameWorld() {
    gw = new GameWorld("Test World", "A test world.");
    // first create the graph of areas and transitions
    Location bedroom = new Location("Bedroom", "A small room with a computer and bookshelf.");
    Location hallway = new Location("Hallway", "A narrow hallway leading to a kitchen.");

    Transition t1 = new Transition("You move from the bedroom to the kitchen.");
    Transition t2 = new Transition("You move from the kitche to the bedroom.");

    Vertex<Location> v1 = gw.insertLocation(bedroom);
    Vertex<Location> v2 = gw.insertLocation(hallway);

    gw.insertTransition(v1, v2, t1);
    gw.insertTransition(v2, v1, t2);
  }

  @Test
  public void TestGameWorld() {

  }
}
