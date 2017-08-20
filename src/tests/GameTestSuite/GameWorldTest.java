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
    Location l = new Location("bed", "A small twin bed.");
    p = new Player("Kelan", l);
    gw = new GameWorld("Test World", "A test world.", p);
    // first create the graph of areas and transitions
    Area bedroom = new Area("Bedroom", "A small room with a computer and bookshelf.");
    Area hallway = new Area("Hallway", "A narrow hallway leading to a kitchen.");

    Transition t1 = new Transition("You move from the bedroom to the kitchen.");
    Transition t2 = new Transition("You move from the kitche to the bedroom.");

    Vertex<Area> v1 = gw.insertArea(bedroom);
    Vertex<Area> v2 = gw.insertArea(hallway);

    gw.insertTransition(v1, v2, t1);
    gw.insertTransition(v2, v1, t2);
  }

  @Test
  public void TestGameWorld() {

  }
}
