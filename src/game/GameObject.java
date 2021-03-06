package game;

public abstract class GameObject implements Viewable {
  private String name;
  private String description;

  public GameObject(String name, String description) {
    this.name = name;
    this.description = description;
  }

  /**
   * Sets the name of the object.
   *
   * @param name the name of the object
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the object.
   *
   * @return the name of the object
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the description of the object.
   *
   * @param name the description of the object
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets the description of the object.
   *
   * @return the description of the object
   */
  public String getDescription() {
    return description;
  }

  public String view() {
    return getDescription();
  }

  public boolean equals(Object o) {
    if(o instanceof GameObject) {
      GameObject go = (GameObject) o;
      return this.getName().equals(go.getName()) && this.getDescription().equals(go.getDescription());
    }
    else {
      return false;
    }
  }

  public String toString() {
    return String.format("");
  }

  public String debugString() {
    return String.format("");
  }
}
