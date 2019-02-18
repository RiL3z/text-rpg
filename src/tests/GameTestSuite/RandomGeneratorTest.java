package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.BeforeClass;

import game.RandomGenerator;
import game.Location;
import game.GameWorld;

public class RandomGeneratorTest {
  @Test
  public void testGenerateString() {
    String result = RandomGenerator.getString();
    assertTrue("something went wrong with random string generation", result.length() != 0);
  }

  @Test
  public void testGenerateLocation() {
    Location result = RandomGenerator.getLocation();
    String locationName = result.getName();
    String locationDescription = result.getDescription();
    assertTrue("something went wrong with random location generation", locationName.length() != 0 && locationDescription.length() != 0);
  }

  @Test
  public void testGenerateWorld() {
    GameWorld gw = RandomGenerator.getGameWorld();
    assertTrue("something went wrong with random world generation", gw != null);
    String name = gw.getName();
    String description = gw.getDescription();
    assertTrue("something went wrong with random world name generation", gw.getName().equals("TestWorld"));
    assertTrue("something went wrong with random world description generation", gw.getDescription().equals("It's a test world yo!"));
    assertTrue("something went wrong with random world location generation", gw.getNumLocations() != 0);
    //assertTrue("something went wrong with random world generation", result.getNumTransitions() != 0);
  }
}
