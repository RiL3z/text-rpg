package test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import game.GameObject;
import game.Location;
import game.Item;

public class LocationTest {
  private static Location loc;
  private static ArrayList<GameObject> gameObjectSet1;
  private static ArrayList<GameObject> gameObjectSet2;
  private static ArrayList<GameObject> gameObjectSet3;
  // set up a location object before tests
  @BeforeClass
  public static void setupLocation() {
    loc = new Location("Bedroom", "A small bedroom with a computer and bookshelf.");
  }

  private static ArrayList<GameObject> getBedroomObjects() {
    ArrayList<GameObject> locationItems = new ArrayList<>();
    Item bed = new Item("Bed", "A small bed meant for a single person.");
    Item computer = new Item("Computer", "An expensive computer meant for gaming.");
    Item[] items = {bed, computer};

    for(Item item: items) {
      locationItems.add(item);
    }

    return locationItems;
  }

  @Test
  public static void TestAddOneGameObject() {
    ArrayList<GameObject> locationItems = new ArrayList<>();
    Item bed = new Item("Bed", "A small bed meant for a single person.");
    locationItems.add(bed);
    loc.setGameObjects(locationItems);

    assertEquals();
  }

  @Test
  public static void TestTwoGameObjects() {

  }
}
