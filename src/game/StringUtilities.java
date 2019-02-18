package game;

import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;
/**
 * Handy utility functions for dealing with text in the rpg.
 */
public class StringUtilities {
  public static String yaml(Object o) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
    mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    return mapper.writeValueAsString(o);
  }

  public static String json(Object o) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(o);
  }

  public static String repeatChar(char c, int length) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < length; i ++) {
      sb.append(c);
    }
    return sb.toString();
  }

  public static String formatGameOutput(String message, int columns, char topLeftChar, char topBorder, char topRightChar, char bottomLeftChar, char bottomBorder, char bottomRightChar, char leftBorder, char rightBorder) {
    String regex = "\\s+";
    // don't modify the incoming reference to change what it points at
    String aA = message.trim();
    String[] words = aA.split(regex);
    int lengthOfLongestWord = 0;
    for(String word: words) {
      if(word.length() + 2 > lengthOfLongestWord) {
        lengthOfLongestWord = word.length() + 2;
      }
    }

    if(lengthOfLongestWord > columns) {
      columns = lengthOfLongestWord;
    }

    int lineCharCount = 0;
    StringBuilder sb = new StringBuilder();
    sb.append(topLeftChar + repeatChar(topBorder, columns - 2) + topRightChar);
    sb.append(String.format("%n"));
    sb.append(leftBorder);
    lineCharCount += 1;
    for(String word: words) {
      lineCharCount += word.length();
      if(lineCharCount > columns) {
        int numSpaces = columns - ((lineCharCount - word.length()) + 1);
        if(numSpaces >= 0) {
          sb.append(repeatChar(' ', numSpaces));
        }
        else {
          sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(rightBorder + String.format("%n") + leftBorder + word + " ");
        lineCharCount = 0;
        lineCharCount += word.length() + 2;
      }
      else {
        sb.append(word + " ");
        lineCharCount += 1;
      }
    }
    int numSpaces = (columns - lineCharCount) - 1;
    if(numSpaces >= 0) {
      sb.append(repeatChar(' ', numSpaces));
    }
    else {
      sb.deleteCharAt(sb.length() - 1);
    }
    sb.append(rightBorder);
    sb.append(String.format("%n") + bottomLeftChar + repeatChar(bottomBorder, columns - 2) + bottomRightChar);
    return sb.toString();
  }

  public static String plainGameOutput(String message, int columns) {
    return formatGameOutput(message, columns, '+', '-', '+', '+', '-', '+', '|', '|');
  }
  // sanitize input by trimming spaces, replaces spaces and downcasing
  public static String sanitize(String a) {
    // regex matches all substrings that match two or more spaces
    String regex = "\\s{2,}";
    // don't modify the incoming reference to change what it points at
    String aA = a.trim();
    aA = aA.replaceAll(regex, " ");
    aA = aA.toLowerCase();
    return aA;
  }

  public static boolean match(String regex, String input) {
    // all commands should be between the beginning and end of line
    return Pattern.compile("^" + regex + "$", Pattern.CASE_INSENSITIVE).matcher(sanitize(input)).matches();
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
