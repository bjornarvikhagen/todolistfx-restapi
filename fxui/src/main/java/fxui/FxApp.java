package fxui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App.
 */
public class FxApp extends Application {

  @Override
  public void start(Stage stage) throws IOException {

    FXMLLoader loader;

    Boolean server = false; // Velge om bruke server eller ikke.
    if (server) {
      loader = new FXMLLoader(getClass().getResource("FXUIUsingRest.fxml"));
    } else {
      loader = new FXMLLoader(getClass().getResource("FXUI.fxml"));
    }
    Parent root = loader.load();
    stage.setScene(new Scene(root));
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}
