package game;

/**
 * Handy utility functions for dealing with text in the rpg.
 */
public class StringUtilities {

  // sanitize input by trimming spaces, replaces spaces and downcasing
  private static String sanitize(String a) {
    // regex matches all substrings that match two or more spaces
    String regex = "\\s{2,}";
    // don't modify the incoming reference to change what it points at
    String aA = a.trim();
    aA = aA.replaceAll(regex, " ");
    aA = aA.toLowerCase();
    return aA;
  }

  public static boolean compare(String a, String b) {
    if(a == null && b == null) {
      return true;
    }
    else if(a == null && b != null) {
      return false;
    }
    else if(a != null && b == null) {
      return false;
    }

    String aA = sanitize(a);
    String bB = sanitize(b);

    return aA.equals(bB);
  }

  public static boolean contains(String a, String b) {
    if(a == null && b == null) {
      return true;
    }
    else if(a == null && b != null) {
      return false;
    }
    else if(a != null && b == null) {
      return false;
    }

    String aA = sanitize(a);
    String bB = sanitize(b);

    return aA.contains(bB);
  }
}
