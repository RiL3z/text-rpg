package game;

import java.util.ArrayList;
import java.util.List;

// wrap up the concept of multiple game commands
public class GameCommands {
  // an array of commands the the game recognizes
  private Command[] commands;
  // words that map to the move action
  private List<String> moveWords;
  // words that map to the view action
  private List<String> viewWords;
  // words that indicate the player wants to list all the visible locations
  // they can go to
  private List<String> exitWords;
  // words that indicate that the player would like to gracefully quit the game
  private List<String> quitWords;
  // words that indicate the player wants to know about objects in the room
  private List<String> objectsWords;

  public GameCommands() {
    initCommands();
  }

  /**
   * Method sets up default commands that the game will recognize
   */
  private void initCommands() {
    initMoveWords();
    initViewWords();
    initExitWords();
    initQuitWords();
    initObjectsWords();
    commands = new Command[5];
    commands[0] = new Command(moveWords, Command.Actions.MOVE);
    commands[1] = new Command(viewWords, Command.Actions.VIEW);
    commands[2] = new Command(exitWords, Command.Actions.EXITS);
    commands[3] = new Command(quitWords, Command.Actions.QUIT);
    commands[4] = new Command(objectsWords, Command.Actions.OBJECTS);
  }

  public Command.Actions getCommandAction(String cmd) {
    // determine if the user input matched any command
    boolean foundCommand = false;
    Command.Actions action = Command.Actions.NONE;

    // find if any word in the input the user sent matches a command
    String[] words = cmd.split(" ");

    for(String word: words) {
      for(Command c: commands) {
        if(c.recognize(word.toLowerCase())) {
          foundCommand = true;
          return c.getAction();
        }
      }
    }
    return Command.Actions.NONE;
  }

  /**
   * method sets up the move word sequence
   */
  private void initMoveWords() {
    String[] words = {"move", "go", "walk", "travel", "run"};
    moveWords = new ArrayList<>();

    for(String word: words) {
      moveWords.add(word);
    }
  }

  /**
   * method sets up the view word sequence
   */
  private void initViewWords() {
    String[] words = {"look", "view", "inspect", "observe", "scrutinize"};
    viewWords = new ArrayList<>();

    for(String word: words) {
      viewWords.add(word);
    }
  }

  private void initExitWords() {
    String[] words = {"exits", "paths", "ways", "outs", "out"};
    exitWords = new ArrayList<>();

    for(String word: words) {
      exitWords.add(word);
    }
  }

  private void initQuitWords() {
    String[] words = {"quit", "stop", "exit"};
    quitWords = new ArrayList<>();

    for(String word: words) {
      quitWords.add(word);
    }
  }

  private void initObjectsWords() {
    String[] words = {"object", "objects", "item", "items", "thing", "things"};
    objectsWords = new ArrayList<>();

    for(String word: words) {
      objectsWords.add(word);
    }
  }

}
