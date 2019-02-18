package game;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ResourceReader {
  public static Item[] getItems() throws IOException {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    Item[] items = mapper.readValue(ResourceReader.class.getClassLoader().getResourceAsStream("items.yml"), Item[].class);
    return items;
  }
}
