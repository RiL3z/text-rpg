/**
 * Making a generic graph class. This will be useful
 * as representing the game world.
 */
import java.util.ArrayList;

public class Graph<E, W> {
  private ArrayList<Position<E>> allNodes;
  private ArrayList<W> allWeights;

  private Position<E> root;
  //Every node is associated with one graph.
  private class Node<E> implements Position<E> {
    //Every node has a list of neighbors that it's connected to.
    private ArrayList<Position<E>> neighbors;
    private ArrayList<W> weights;
    private ArrayList<Pair<E, W>> nodesAndWeights;
    private E element;

    public Node(E element) {
      neighbors = new ArrayList<>();
      weights = new ArrayList<>();
      nodesAndWeights = new ArrayList<>();
      this.element = element;
    }

    //Get the element stored at this position.
    public E getElement() {
      return element;
    }

    public Position<E> addNeighbor(E element, W weight) {
      Position neighbor = new Node<E>(element);
      neighbors.add(neighbor);
      weights.add(weight);
      allNodes.add(neighbor);
      allWeights.add(weight);
      Pair<E, W> pair = new Pair<>(element, weight);
      nodesAndWeights.add(pair);
      return neighbor;
    }

    /**
     * Get all the neighbors of a node.
     */
    public ArrayList<Position<E>> getNeighbors() {
      return neighbors;
    }

    /**
     * Get all the weights of this position.
     */
    public ArrayList<W> getWeights() {
      return weights;
    }

    /**
     * Get all neighbor and weight pairs of a node.
     */
    public ArrayList<Pair<E, W>> getNeighborsAndWeights() {
      return nodesAndWeights;
    }

    //Return the element stored at this node.
    public String toString() {
      return element.toString();
    }
  }

  /**
   * Private pair class that can hold a neighbor node plus the cost to get to it.
   */
  private class Pair<K, V> {
    K key;
    V value;
    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public String toString() {
      return "{" + key.toString() + ", " + value.toString() + "}";
    }
  }

  public Graph() {
    allNodes = new ArrayList<>();
    allWeights = new ArrayList<>();
  }

  //Add the root node to the graph.
  public Position<E> addRoot(E element) {
    root = new Node<E>(element);
    allNodes.add(root);
    return root;
  }

  public Position<E> getRoot() {
    return root;
  }

  /**
   * Method should add a new element as the neighbor of the node at position p.
   */
  public Position<E> addElementToNode(Position<E> p, E element, W weight) {
    for(Position<E> pos: allNodes) {
      if(pos == p) {
        Node<E> node = (Node<E>) pos;
        return node.addNeighbor(element, weight);
      }
    }
    return null;
  }

  /**
   * Get all the neighbors and weights to those neighbors of a position in the graph.
   */
  public ArrayList<Pair<E, W>> getNeighborsAndWeights(Position<E> pos) {
    Node<E> node = (Node<E>) pos;
    return node.getNeighborsAndWeights();
  }

  /**
   * Get all the neighbors of a position in the graph.
   */
  public ArrayList<Position<E>> getNeighbors(Position<E> pos) {
    Node<E> node = (Node<E>) pos;
    return node.getNeighbors();
  }

  /**
   * Get all the weights of the neighbors of a position in the graph.
   */
  public ArrayList<W> getWeights(Position<E> pos) {
    Node<E> node = (Node<E>) pos;
    return node.getWeights();
  }

  /**
   * Get all the nodes in the graph.
   */
  public ArrayList<Position<E>> getNodes() {
    return allNodes;
  }

  /**
   * Get all the weights in the graph.
   */
  public ArrayList<W> getWeights() {
    return allWeights;
  }
}
