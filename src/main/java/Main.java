package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/view/MainWindow.fxml"));
        primaryStage.setTitle("CalcFX");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setMaxWidth(235);
        primaryStage.setMinHeight(350);

        // Remove minimize and maximize
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
