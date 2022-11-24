package fxui;

import cleane.core.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class AbstractAppController {

    NewPersonPopup newPersonPopup;

    @FXML
    public AnchorPane anchor;

    @FXML
    public TextField descField;

    @FXML
    public DatePicker deadField;

    @FXML
    public Button makeTaskButton;

    @FXML
    public ChoiceBox<String> personSelect;

    public People people;

    public Tasks tasks;

    @FXML
    public void initialize() {
        if (people == null) {
            people = new People();
        }
        if (tasks == null) {
            tasks = new Tasks();
        }
    }

    /**
     * Opens a "New Task" window in the ui, allowing the user to
     * create a new Task object, and assign it to a Person.
     */

    public Task taskToBeLoaded;

    @FXML
    public void makeTask() {
        Task task;

        if(taskToBeLoaded == null){
            if (deadField.getValue() == null || deadField.getValue().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("ugyldig dato");
            }
            if (descField.getText() == null) {
                throw new IllegalArgumentException("du må beskrive aktiviteten");
            }
            if (descField.getText() == null) {
                throw new IllegalArgumentException("du må skrive inn navn");
            }
            if (personSelect.getValue() == null) {
                throw new IllegalArgumentException("velg en ansvarlig");
            }
            String selectedItem = personSelect.getValue();
            List<String> peoplesNames = new ArrayList<String>();
            for (int i = 0; i < people.size(); i++) {
                peoplesNames.add(people.get(i).getName());
            }
            int indexOfName = peoplesNames.indexOf(selectedItem);
            task = new Task(descField.getText(), deadField.getValue(), people.get(indexOfName));
            if (tasks == null) {
                tasks = new Tasks();
            }
            tasks.add(task);

        } else {
            task = taskToBeLoaded;
            Task newTask = new Task(task.getDescription(), task.getDeadline(), task.getPerson());
            if (tasks == null) {
                tasks = new Tasks();
            }
            tasks.add(newTask);
        }

        descField.clear();
        deadField.setValue(null);

        final Label descriptionLabel = new Label(task.getDescription());
        final Label deadlineLabel = new Label(task.getDeadline().toString());
        final Label nameLabel = new Label(task.getPerson().getName());

        Pane taskPane = new Pane();
        taskPane.setMinWidth(400);
        taskPane.setMinHeight(80);
        taskPane.setLayoutX(70);
        taskPane.setStyle("-fx-background-color: lightgrey");

        Label label1 = new Label("Oppgave:");
        label1.setLayoutX(14);
        label1.setLayoutY(10);
        Label label2 = new Label("Frist:");
        label2.setLayoutX(169);
        label2.setLayoutY(10);
        Label label3 = new Label("Ansvarlig:");
        label3.setLayoutX(275);
        label3.setLayoutY(10);

        taskPane.getChildren().add(descriptionLabel);
        taskPane.getChildren().add(deadlineLabel);
        taskPane.getChildren().add(nameLabel);

        taskPane.getChildren().add(label1);
        taskPane.getChildren().add(label2);
        taskPane.getChildren().add(label3);

        descriptionLabel.setLayoutY(40);
        descriptionLabel.setLayoutX(14);
        deadlineLabel.setLayoutY(40);
        deadlineLabel.setLayoutX(169);
        nameLabel.setLayoutY(40);
        nameLabel.setLayoutX(275);

        if (anchor.getChildren().size() == 0) {
            taskPane.setLayoutY(14);
        }
        else {
            taskPane.setLayoutY(anchor.getChildren().size() * 6 * anchor.getChildren().get(0).getLayoutY() + 14);
        }
        anchor.getChildren().add(taskPane);
        anchor.setPrefHeight(140);

        Button button = new Button();
        button.setText("Delete");
        button.setId("delete"+tasks.size());
        taskPane.getChildren().add(button);
        button.setLayoutX(-60);
        button.setLayoutY(20);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < anchor.getChildren().size(); i++) {
                    if (anchor.getChildren().indexOf(anchor.getChildren().get(i)) != 0) {
                        anchor.getChildren().get(i).setLayoutY(anchor.getChildren().get(i).getLayoutY() - 80);
                    }
                }
                anchor.getChildren().remove(taskPane);
                tasks.remove(task);
            }

        });
    }



    /**
     * Creates a new display in the ui, allowing the user to create
     * a new Person object, and writes it to the file.
     *
     * @param event .
     * @throws FileNotFoundException if file not found.
     * @throws IOException if error during writing to file.
     */
    @FXML
    public void makeNewPerson(ActionEvent event) throws FileNotFoundException, IOException {
        newPersonPopup = new NewPersonPopup();
        Person newPerson = newPersonPopup.display("create new person", "enter name");
        if (people == null) {
            people = new People();
        }
        people.add(newPerson);

        personSelect.getItems().add(newPerson.getName());
        personSelect.setValue(newPerson.getName());
    }

    @FXML
    public void handleDeletePerson() {
        personSelect.getItems().remove(personSelect.getSelectionModel().getSelectedIndex());
    }
}
