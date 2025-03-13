package org.CMH5_Wash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX extends Application{

    public void start(Stage primaryStage) {
        Label label = new Label("Excel Data Processed!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        public static void startApp() {
            launch();
        }
}
