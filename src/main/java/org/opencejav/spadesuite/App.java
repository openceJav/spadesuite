package org.opencejav.spadesuite;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.opencejav.spadesuite.exceptions.StylesheetNotFoundException;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.Objects;

@SuppressWarnings("all")
public class App extends Application {
    private static final String RELATIVE_PATH = "src/main/java/org/opencejav/spadesuite/css/";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("spade-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Spade Suite - Apartment Management System");
        setupStyleSheets(scene, "base.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static void checkStyleSheetExistence(String sheet) throws StylesheetNotFoundException {
        var resource = App.class.getResource("css/%s".formatted(sheet));

        if (Objects.isNull(resource)) {
            Logger.error("Stylesheet %s not found".formatted(sheet));
            throw new StylesheetNotFoundException("Stylesheet %s not found".formatted(sheet));
        }

        Logger.info("Stylesheet %s found".formatted(sheet));
    }

    private static void setupStyleSheets(Scene scene, String... styleSheets) {
        for (String sheet : styleSheets) {
            checkStyleSheetExistence(sheet);
            scene.getStylesheets()
                    .add(App.class.getResource("css/%s".formatted(sheet)).toExternalForm());
        }
    }
}
