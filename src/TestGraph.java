public class TestGraph {
  public static void testGraph() {
    Graph<String, Integer> graph = new Graph<>();
    System.out.println("Instantiating a new graph.");
    String rootElement = "Kelan";
    System.out.println("Putting as the root element the String: " + rootElement);
    graph.addRoot(rootElement);
    System.out.println("Getting the root element back:");
    System.out.println(graph.getRoot().getElement());
    System.out.println("Adding onto the root node");
    Position<String> added = graph.addElementToNode(graph.getRoot(), "Riley", 1);
    added = graph.addElementToNode(graph.getRoot(), "Patrick", 1);
    System.out.println("Getting the added node back:");
    System.out.println(added.getElement());
    System.out.println("Get neighors of root:");
    System.out.println(graph.getNeighbors(graph.getRoot()));
    System.out.println(graph.getNodes());
  }

  //Method simply builds a test graph for me to use in testing.
  private static Graph<String, Integer> buildTestGraph() {
    //Instantiate an empty graph.
    Graph<String, Integer> graph = new Graph<>();
    
  }
}
