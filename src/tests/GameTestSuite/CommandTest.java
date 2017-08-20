package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;
import java.util.List;
import java.util.ArrayList;
import game.Command;
/**
 * This class should run all the tests for various data structures that I
 * build in making the game.
 */
public class CommandTest {
  private static Command c;

  @BeforeClass
  public static void SetupCommand() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("move");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("go");
    moveWords.add("travel");

    c = new Command(moveWords, Command.Actions.MOVE);
  }

  @Test
  public void TestRecognize() {
    String goodMove = "move";
    assertEquals(true, c.recognize(goodMove));
  }

  @Test
  public void TestUnRecognized() {
    String badMove = "waddle";
    assertEquals(false, c.recognize(badMove));
  }
}
