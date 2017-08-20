package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;
import game.Game;

/**
 * Make sure to test the functionality of the game class.
 */
public class GameTest {
  private static Game g;
  @BeforeClass
  public static void SetupGame() {
    g = new Game();
  }

  @Test
  public void TestValidCommand() {
    //try sending a couple different valid commands
    String response = g.sendCommand("move");
    assertEquals("player wants to move", response);
    response = g.sendCommand("inspect");
    assertEquals("player wants to view", response);
  }

  @Test
  public void TestInvalidCommand() {
    //try sending a couple different invalid commands
    String response = g.sendCommand("rawr");
    assertEquals("invalid command", response);
    response = g.sendCommand("attack");
    assertEquals("invalid command", response);
  }
}
