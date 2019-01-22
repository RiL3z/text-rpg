package game;

import java.util.Objects;

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
     * @param description
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

    /**
     *
     * @return
     */
    @Override
  public String view() {
    return getDescription();
  }

    /**
     *
     * @param o
     * @return
     */
    @Override
  public boolean equals(Object o) {
    if(o instanceof GameObject) {
      GameObject go = (GameObject) o;
      return this.getName().equals(go.getName()) && this.getDescription().equals(go.getDescription());
    }
    else {
      return false;
    }
  }
}
