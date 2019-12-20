package snapshottelajavafx;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Paulo Collares
 */
public class SnapshotTelaJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        Button btn = new Button();
        btn.setText("Snapshot");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                final WritableImage snapshot = primaryStage.getScene().snapshot(new WritableImage(1920, 1080));

                File file = new File(System.getProperty("java.io.tmpdir") + File.separator + "snapshot_" + System.currentTimeMillis() + ".png");

                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
                } catch (IOException ex) {
                    Logger.getLogger(SnapshotTelaJavaFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Snapshot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
