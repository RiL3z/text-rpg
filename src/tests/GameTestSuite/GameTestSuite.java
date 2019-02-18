package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  StringUtilitiesTest.class,
  RandomGeneratorTest.class
})

public class GameTestSuite {
  // the class remains empty,
  // used only as a holder for the above annotations
}
