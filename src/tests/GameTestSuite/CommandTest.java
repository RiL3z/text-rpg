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

  @Test
  public void TestGetWords() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    List<String> expected = new ArrayList<>();
    expected.add("move");
    expected.add("walk");
    expected.add("run");
    expected.add("go");
    expected.add("travel");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    assertEquals(expected, c.getWords());
  }

  @Test
  public void TestSetWords() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    List<String> words = new ArrayList<>();
    words.add("dance");
    words.add("skip");
    words.add("Hop");
    words.add("GaLlop");

    c.setWords(words);

    List<String> expected = new ArrayList<>();
    expected.add("dance");
    expected.add("skip");
    expected.add("hop");
    expected.add("gallop");

    assertEquals(expected, c.getWords());
  }

  @Test
  public void TestRecognize1() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String goodMove = "move";
    assertEquals(true, c.recognize(goodMove));
  }

  @Test
  public void TestRecognize2() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String goodMove = "MOVE";
    assertEquals(true, c.recognize(goodMove));
  }

  @Test
  public void TestRecognize3() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String goodMove = "MoVe";
    assertEquals(true, c.recognize(goodMove));
  }

  @Test
  public void TestRecognize4() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String goodMove = "go";
    assertEquals(true, c.recognize(goodMove));
  }

  @Test
  public void TestUnRecognized1() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String badMove = "waddle";
    assertEquals(false, c.recognize(badMove));
  }

  @Test
  public void TestUnRecognized2() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String badMove = "";
    assertEquals(false, c.recognize(badMove));
  }

  @Test
  public void TestUnRecognized3() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String badMove = "go ";
    assertEquals(false, c.recognize(badMove));
  }

  @Test
  public void TestUnRecognized4() {
    List<String> moveWords = new ArrayList<String>();
    // think of some possible ways a player might want to communicate that their
    // character should move
    moveWords.add("mOVE");
    moveWords.add("walk");
    moveWords.add("run");
    moveWords.add("GO");
    moveWords.add("travEl");

    Command c = new Command(moveWords, Command.Actions.MOVE);

    String badMove = "balk";
    assertEquals(false, c.recognize(badMove));
  }
}
