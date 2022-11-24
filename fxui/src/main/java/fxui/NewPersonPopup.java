package fxui;

import cleane.core.Person;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewPersonPopup {

  static Person person;
  /**
   * Creates a popup in the fxui, allowing the user
   * to define a new person object.
   *
   * @param title title of the window.
   * @param message message in the window.
   * @return Person that gets created.
   */

  public Person display(String title, String message) {
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(250);
    window.setMinHeight(250);
    Label label = new Label();
    label.setText(message);
    Button createButton = new Button("Create new person");
    createButton.setId("popupButton");
    TextField nameField = new TextField();
    nameField.setId("popupField");

    nameField.setMaxWidth(200);

    createButton.setOnAction(e -> {
      person = new Person(nameField.getText());
      window.close();
    });

    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, nameField, createButton);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    return new Person(person.getName());
  }

}
