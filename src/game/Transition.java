package game;
/**
 * A portal is a very general thing that basically teleports the player from
 * one location to another.
 */
public class Transition {
  private String transition;
  /**
   * Constructs a new Portal with one location transporting to another.
   */
  public Transition(String transition) {
    this.transition = transition;
  }

  public void setTransition(String transition) {
    this.transition = transition;
  }

  public String getTransition() {
    return transition;
  }

  public boolean equals(Object o) {
    if(o instanceof Transition) {
      Transition t = (Transition) o;
      return this.getTransition().equals(t.getTransition());
    }
    else {
      return false;
    }
  }
}
