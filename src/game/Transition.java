package game;
/**
 * This interface defines what all transitions should support. A transition is
 * just what gets displayed in the game when moving from one thing to the next.
 */
public abstract class Transition {
  private String transitionText;
  
  public Transition(String transitionText) {
    this.transitionText = transitionText;
  }

  public void setTransitionText(String transitionText) {
    this.transitionText = transitionText;
  }

  public String getTransitionText() {
    return transitionText;
  }
}
