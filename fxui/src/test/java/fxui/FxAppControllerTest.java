package fxui;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class FxAppControllerTest extends ApplicationTest {



    private FxAppController controller;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("FXUI.fxml"));
        root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public Parent getRootNode() {
        return root;
    }


    @Test
    void testProgram() {
        clickOn("#addPersonButton");
        clickOn("#popupField").write("person1");
        clickOn("#popupButton");
        clickOn("#descField").write("do a thing");
        clickOn("#deadField").write("20/04/2069").press(KeyCode.ENTER).release(KeyCode.ENTER);
        clickOn("#makeTaskButton");
        clickOn("#addPersonButton");
        clickOn("#popupField").write("person2");
        clickOn("#popupButton");
        clickOn("#descField").write("do another thing");
        clickOn("#deadField").write("20/04/2069").press(KeyCode.ENTER).release(KeyCode.ENTER);
        clickOn("#makeTaskButton");
        int tasksCount = controller.tasks.size();
        clickOn("#delete"+tasksCount);
        clickOn("#deletePersonButton");
    }
}