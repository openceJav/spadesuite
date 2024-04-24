package org.opencejav.spadesuite;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {
    private static final String DEFAULT_CSS_RESOURCE_FILE_PATH = "css/";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("spade-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Spade Suite - Apartment Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static void setupStyleSheets(Scene scene, String... styleSheets) {
        for (String sheet : styleSheets) {
            scene.getStylesheets().add(
                    Objects.requireNonNull(
                            App.class.getResource(DEFAULT_CSS_RESOURCE_FILE_PATH + sheet)).toExternalForm());
        }
    }
}