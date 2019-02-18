package game;

import java.util.Random;

import net.datastructures.Vertex;
import net.datastructures.Edge;

public class RandomGenerator {
  private static final Random r = new Random();
  private static final char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
  /**
   * generate a randomized string
   */
  public static String getString() {
    int randomLength = r.nextInt(25) + 1;
    String randomString = "";
    for(int i = 0; i < randomLength; i ++) {
      char randomChar = chars[r.nextInt(chars.length)];
      randomString += randomChar;
    }
    return randomString;
  }


  public static int randomNum(int lowerbound, int upperbound) {
    int nums = upperbound - lowerbound + 1;
    return r.nextInt(nums) + lowerbound;
  }

  public static Location getLocation() {
    return new Location(getString(), getString());
  }

  public static Location getLocation(String name) {
    return new Location(name, getString());
  }

  public static GameWorld getGameWorld(int numLocations) {
    GameWorld gw = new GameWorld("TestWorld", "It's a test world yo!");
    for(int i = 0; i < numLocations; i ++) {
      Location l = getLocation(i + "");
      gw.insertLocation(l);
    }
    Vertex<Location>[] verts = gw.getLocations();
    for(Vertex<Location> vert0: verts) {
      if(gw.getNumExits(vert0) != gw.getNumLocations() - 1) {
        for(Vertex<Location> vert1: verts) {
          // don't connect a vert to itself
          if(!vert0.getElement().equals(vert1.getElement())) {
            String fromName = vert0.getElement().getName();
            String toName = vert1.getElement().getName();
            Transition t = new Transition(fromName + " to " + toName);
            gw.insertTransition(vert0, vert1, t);
          }
        }
      }
    }
    return gw;
  }
}
