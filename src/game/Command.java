package game;

import java.util.List;

/**
 * This class represents a command that the rpg game should recognize. Every
 * command recognized by the game should map to some sort of action.
 *
 * @author Kelan Riley
 */
public class Command {
  /**
   * A set of actions that the player may perform over the course of the game.
   */
  public enum Actions {
    MOVE, VIEW, NONE
  }
  // A list of words that map to one action
  private List<String> words;
  private Actions action;

  /**
   * Creates a command that associates a sequence of trigger words with an
   * action.
   *
   * @param words an array of strings that the game recognizes as mapping
   * to a command
   * @param action an action that the player can perform in the game
   */
  public Command(List<String> words, Actions action) {
    this.words = words;
    this.action = action;
  }

  /**
   * Sets the sequence of words mapped to a particular action.
   *
   * @param words the list of words that map to an action
   */
  public void setWords(List<String> words) {
    this.words = words;
  }

  /**
   * Gets the list of words.
   *
   * @return the list of words
   */
  public List<String> getWords() {
    return words;
  }

  /**
   * Sets the action associated with a sequence of words.
   *
   * @param action the action mapped to a sequence of words
   */
  public void setAction(Actions action) {
    this.action = action;
  }

  /**
   * Gets the action.
   *
   * @return the action
   */
  public Actions getAction() {
    return action;
  }

  /**
   * Gets whether or not the word is recognized as a command.
   * @return true if the command is recognized, false if not
   */
  public boolean recognize(String word) {
    return words.contains(word);
  }
}
