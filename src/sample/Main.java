package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static TabPane tabPane = new TabPane();

    public static TabPane getTabPane() {
        return tabPane;
    }

    public static void setTabPane(TabPane tabPane) {
        Main.tabPane = tabPane;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = primaryStage;

        root.setCenter(tabPane);

        primaryStage.setTitle("Outil matriciel");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("darcula.css");  //https://github.com/Mouse0w0/JavaFXDarculaTheme
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
