package fxui;

import cleane.core.People;
import cleane.core.Tasks;
import cleane.restapi.ValuesService;
import java.io.IOException;
import javafx.fxml.FXML;

public class FxAppControllerUsingRest extends AbstractAppController {

  private ValuesService service;

  /**
   * initializes the fields.
   */
  @FXML 
  public void initialize() {
    if (people == null) {
      people = new People();
    }
    if (tasks == null) {
      tasks = new Tasks();
    }
    service = new ValuesService();
    try {
      people = service.getPeople();
      tasks = service.getTasks();
    } catch (IOException e) {
      e.printStackTrace();
    }
  
    if (people != null) {
      for (int i = 0; i < people.size(); i++) {
        personSelect.getItems().add(people.get(i).getName());
        System.out.println("Sucess loading People from file.");
      }
    }
    if (tasks != null) {
      for (int i = 0; i < tasks.size(); i++) {
        //makeTask(tasks.getTask(i));
        System.out.println("Sucess loading Tasks from file.");
      }
    }
  }

  /**
   * Using ValuesService to handle save. 
   *
   * @throws IOException if error during saving.
   */
  @FXML
  public void handleSave() throws IOException {
    service.postPeople(people);
    service.postTasks(tasks);
    System.out.println("Sucess saving People and Tasks to file.");
  }

  @FXML
  public void handleLoad() {
    initialize();
  }
}
