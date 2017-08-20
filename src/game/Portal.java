package game;
/**
 * A portal is a very general thing that basically teleports the player from
 * one location to another.
 */
public abstract class Portal {
  private Transition fromAtoB;
  private Transition fromBtoA;
  private Location a;
  private Location b;
  /**
   * Constructs a new Portal with one location transporting to another.
   */
  public Portal(Transition transition, Location a, Location b) {
    this.a = a;
    this.b = b;
    fromAtoB = transition;
    fromBtoA = transition;
  }

  public Portal(Transition fromAtoB, Transition fromBtoA, Location a, Location b) {
    this.a = a;
    this.b = b;
    this.fromAtoB = fromAtoB;
    this.fromBtoA = fromBtoA;
  }

  public void setFromAtoB(Transition fromAtoB) {
    this.fromAtoB = fromAtoB;
  }

  public Transition getFromAtoB() {
    return fromAtoB;
  }

  public void setFromBtoA(Transition fromBtoA) {
    this.fromBtoA = fromBtoA;
  }

  public Transition getFromBtoA() {
    return fromBtoA;
  }

  public void enterFront(Character c) {
    c.setLocation(b);
  }

  public void enterBack(Character c) {
    c.setLocation(a);
  }
}
