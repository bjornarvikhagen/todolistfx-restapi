package cleane.json;

import cleane.core.People;
import cleane.core.Tasks;
import cleane.core.Values;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;

public class LocalJsonParser {

  private ObjectMapper mapper = new ObjectMapper();

  /**
   * Creates new LocalJsonParser object.
   */
  public LocalJsonParser() {
    mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  /**
   * Attempts to save people to file.
   *
   * @param file to save to.
   * @param people to save to file.
   */
  public void peopleSave(File file, People people) {
    try {
      mapper.writeValue(file, people);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Attempts to load from file.
   *
   * @param file to load from.
   * @return People loaded from file.
   */
  public People peopleLoad(File file) {
    try {
      People people = mapper.readValue(file, People.class);
      return people;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Attempts to save to file.
   *
   * @param file to save to.
   * @param tasks to save.
   */
  public void tasksSave(File file, Tasks tasks) {
    try {
      mapper.writeValue(file, tasks);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Attempts to load tasks from file.
   *
   * @param file to load from.
   * @return loaded values.
   */
  public Tasks tasksLoad(File file) {
    try {
      Tasks tasks = mapper.readValue(file, Tasks.class);
      return tasks;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Attempts go save values to file.
   *
   * @param file to save to.
   * @param values to save.
   */
  public void valuesSave(File file, Values values) {
    try {
      mapper.writeValue(file, values);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Attempts to load values from File.
   *
   * @param file to load from.
   * @return Values from file.
   */
  public Values valuesLoad(File file) {
    try {
      Values values = mapper.readValue(file, Values.class);
      return values;
    } catch (Exception e) {
      e.printStackTrace();;
      return null;
    }
  }
}
