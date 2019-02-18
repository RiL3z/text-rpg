package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.BeforeClass;
import java.util.List;
import java.util.ArrayList;
import game.VerbCommand;
/**
 * This class should run all the tests for various data structures that I
 * build in making the game.
 */
public class CommandTest {
  @Test
  public void TestVerbCommand() {
    VerbCommand c = new VerbCommand(".*(exits|paths?).*");
    assertTrue("command not recognized", c.recognize("list path out"));
    assertTrue("command not recognized", c.recognize("get me the exits"));
  }
}
