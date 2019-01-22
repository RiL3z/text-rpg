package test;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import game.StringUtilities;

public class StringUtilitiesTest {

  @Test
  public void testCompareEmpty() {
    String a = "";
    String b = "";
    assertTrue(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompareNull1() {
    String a = null;
    String b = null;
    assertTrue(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompareNull2() {
    String a = "";
    String b = null;
    assertFalse(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompareNull3() {
    String a = null;
    String b = "";
    assertFalse(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompare1() {
    String a = "string";
    String b = "buttz";
    assertFalse(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompare2() {
    String a = "test";
    String b = "TeSt";
    assertTrue(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompareSpacingIssues1() {
    String a = "  A damn   string ";
    String b = "A Damn  StRing";
    assertTrue(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompareSpacingIssues2() {
    String a = "A damn string";
    String b = "A Damn String";
    assertTrue(StringUtilities.compare(a, b));
  }

  @Test
  public void testCompareNoRefMod() {
    String a = "A damn string";
    String b = "A Damn String";
    StringUtilities.compare(a, b);
    assertEquals("A damn string", a);
    assertEquals("A Damn String", b);
  }

  @Test
  public void testContainsEmpty() {
    String a = "";
    String b = "";
    assertTrue(StringUtilities.contains(a, b));
  }

  @Test
  public void testContainsNull1() {
    String a = null;
    String b = null;
    assertTrue(StringUtilities.contains(a, b));
  }

  @Test
  public void testContainsNull2() {
    String a = "";
    String b = null;
    assertFalse(StringUtilities.contains(a, b));
  }

  @Test
  public void testContainsNull3() {
    String a = null;
    String b = "";
    assertFalse(StringUtilities.contains(a, b));
  }

  @Test
  public void testContains1() {
    String a = "this is a sentence.";
    String b = "sentence";
    assertTrue(StringUtilities.contains(a, b));
  }

  @Test
  public void testContains2() {
    String a = "sentence";
    String b = "this is a sentence.";
    assertFalse(StringUtilities.contains(a, b));
  }

  @Test
  public void testContains3() {
    String a = "  I waNt   to move   to thE grUnGy VillAge, please ";
    String b = " grungy   village";
    assertTrue(StringUtilities.contains(a, b));
  }
}
