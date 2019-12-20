package capturatelajava;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Paulo Collares
 */
public class CapturaTelaJava extends Application {

    private Robot robot;

    @Override
    public void start(Stage primaryStage) throws AWTException {

        robot = new Robot();

        Button btn = new Button();
        btn.setText("Capturar Tela");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Rectangle tamanhoTela = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

                BufferedImage captura = robot.createScreenCapture(tamanhoTela);

                File file = new File(System.getProperty("java.io.tmpdir") + File.separator + "captura_tela_teste_" + System.currentTimeMillis() + ".png");

                try {
                    ImageIO.write(captura, "png", file);
                } catch (IOException ex) {
                    Logger.getLogger(CapturaTelaJava.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Captura de Tela");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
