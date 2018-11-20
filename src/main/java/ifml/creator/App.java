package ifml.creator;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Main class for IFML Creator application.
 */
public class App extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    @Override
    public void init() {
        LOG.info("Initialization...");
    }

    @Override
    public void stop() {
        LOG.info("Finalization...");
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        var resourceBundle = ResourceBundle.getBundle("ifml-creator", new Locale("ru", "RU"));
        var parent = loadParent("/view/Main.fxml", resourceBundle);

        primaryStage.setScene(new Scene(parent, 800.0, 600.0));
        primaryStage.setTitle(resourceBundle.getString("app.title"));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/ifml.png")));

        primaryStage.show();
    }

    private Parent loadParent(final String viewName, final ResourceBundle resourceBundle) {
        try {
            return (Parent) FXMLLoader.load(getClass().getResource(viewName), resourceBundle);
        } catch (IOException ex) {
            LOG.error("Error during load FXML", ex);
        }
        return null;
    }

    public static void main(String...args) {
        LOG.info("The application arguments is {}", Arrays.toString(args));
        if (args.length > 1) {
            //TODO: Pre-load project
        }
        launch(App.class, args);
    }

}
