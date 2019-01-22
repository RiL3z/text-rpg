package test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.ArrayList;

import game.GameObject;
import game.Location;
import game.Item;

public class LocationTest {
  private static Location loc;
  private static ArrayList<GameObject> gameObjectSet1 = getBedroomObjects();
  private static ArrayList<GameObject> gameObjectSet2;
  private static ArrayList<GameObject> gameObjectSet3;

  // method that constructs 3 simple game objects (2 of them being items)
  private static ArrayList<GameObject> getBedroomObjects() {
    ArrayList<GameObject> locationItems = new ArrayList<>();
    Item bed = new Item("Bed", "A small bed meant for a single person.");
    Item computer = new Item("Computer", "An expensive computer meant for gaming.");
    Item rug = new Item("Rug", "A plain white rug on the floor.");
    Item[] items = {bed, computer, rug};

    for(Item item: items) {
      locationItems.add(item);
    }

    return locationItems;
  }
  // set up a location object before tests
  @BeforeClass
  public static void setupLocation() {
    loc = new Location("Bedroom", "A small bedroom with a computer and bookshelf.");
    loc.setGameObjects(getBedroomObjects());
  }

  @Test
  public void TestGameObject() {
    ArrayList<Item> actual = loc.getItems();
    assertEquals(gameObjectSet1, actual);
  }
}
