package fxui;

import cleane.core.People;
import cleane.core.Tasks;
import cleane.core.Values;
import cleane.json.LocalJsonParser;
import java.io.File;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FxAppController extends AbstractAppController {

  private LocalJsonParser jsonParser;
  private FileChooser fileChooser;
  private ExtensionFilter eFilter;
  protected Values values;

  /**
   * Initializes the filechooser to only get .json files.
   */
  @FXML
  public void initialize() {
    jsonParser = new LocalJsonParser();
    eFilter = new FileChooser.ExtensionFilter("Json files (*.json)", "*.json");
    fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(eFilter);
  }

  /**
   * Handles saving by using LocalJsonParser.
   */
  @FXML
  public void handleSave() {
    File file = fileChooser.showSaveDialog(null);
    values = new Values(people, tasks);
    jsonParser.valuesSave(file, values);
  }

  /**
   * Handler loading by using LocalJsonParser.
   */
  @FXML
  public void handleLoad() {
      File file = fileChooser.showOpenDialog(null);
      Values valuesNew = jsonParser.valuesLoad(file);
      People people = valuesNew.getPeople();
      Tasks tasks = valuesNew.getTasks();

      for (int i = 0; i < tasks.size(); i++) {
          taskToBeLoaded = tasks.getTask(i);
          makeTask();
      }

      for (int i = 0; i < people.size(); i++) {
          personSelect.getItems().add(people.get(i).getName());
      }

      for (int i = 0; i < people.size(); i++) {
          personSelect.getItems().add(people.get(i).getName());

      }
  }
}
