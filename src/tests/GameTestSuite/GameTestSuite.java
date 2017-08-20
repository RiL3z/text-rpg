package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  CommandTest.class,
  GameTest.class,
  TestArea.class
})

public class GameTestSuite {
  // the class remains empty,
  // used only as a holder for the above annotations
}
