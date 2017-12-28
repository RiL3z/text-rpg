package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;

import game.GameCommands;
import game.Command;

public class GameCommandsTest {
  private static GameCommands gcs = new GameCommands();


  @Test
  public void TestGarbage() {
    String cmd = "jk\nf\\n ldjs \t /sm81u     8DFSjIijfF";
    Command.Actions expected = Command.Actions.NONE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestMove1() {
    String cmd = "I want to move there.";
    Command.Actions expected = Command.Actions.MOVE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestMove2() {
    String cmd = "go to the house";
    Command.Actions expected = Command.Actions.MOVE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestMove3() {
    String cmd = "I'm gOING to the house";
    Command.Actions expected = Command.Actions.NONE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestMove4() {
    String cmd = "tRaVel downstairs";
    Command.Actions expected = Command.Actions.MOVE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestView1() {
    String cmd = "view the building over there";
    Command.Actions expected = Command.Actions.VIEW;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestView2() {
    String cmd = "look at the broom on the wall";
    Command.Actions expected = Command.Actions.VIEW;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestView3() {
    String cmd = "i want to see the best views";
    Command.Actions expected = Command.Actions.NONE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestExits1() {
    String cmd = "how do i get out of here?";
    Command.Actions expected = Command.Actions.EXITS;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestExits2() {
    String cmd = "i want to leave this place";
    Command.Actions expected = Command.Actions.NONE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestExits3() {
    String cmd = "what are the paths I can take";
    Command.Actions expected = Command.Actions.EXITS;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestQuit1() {
    String cmd = "I WANT TO QUIT";
    Command.Actions expected = Command.Actions.QUIT;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestQuit2() {
    String cmd = "I WANT TO be done";
    Command.Actions expected = Command.Actions.NONE;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }

  @Test
  public void TestObjects1() {
    String cmd = "are there things in here";
    Command.Actions expected = Command.Actions.OBJECTS;
    Command.Actions actual = gcs.getCommandAction(cmd);
    assertEquals(expected, actual);
  }
}
