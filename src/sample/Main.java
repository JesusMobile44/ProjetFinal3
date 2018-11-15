package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.MatriceView;

import java.util.ArrayList;

public class Main extends Application {

    public static TabPane tabPane = new TabPane();



    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        tabPane.getTabs().add(new BetterTab(
                new Matrice(3,3 ),
                new Matrice(3,3 ),
                new MatriceView(
                        new Matrice(3,3)
                ),
                new MatriceView(
                        new Matrice(3,3)
                )
        ));


        root.setCenter(tabPane);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void generer(){
        Spinner spinnerHauteur = new Spinner(1,10,1);
        Spinner spinnerLargeur = new Spinner(1,10,1);

        Spinner spinnerHauteur2 = new Spinner(1,10,1);
        Spinner spinnerLargeur2 = new Spinner(1,10,1);

        HBox hBox1 = new HBox(
                new Label("Matrice 1"),
                creation(spinnerLargeur, spinnerHauteur)
        );
        HBox hBox2 = new HBox(
                new Label("Matrice 2"),
                creation(spinnerLargeur2, spinnerHauteur2)
        );
        VBox root = new VBox(hBox1, new Separator(), hBox2);

        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);

        dialog.getDialogPane().getButtonTypes().add(
                new ButtonType("Générer", ButtonBar.ButtonData.OK_DONE)
        );

        dialog.setHeaderText("Entrez les dimensions des nouvelles matrices");

        dialog.showAndWait();

        int[][] dimensions = {{
                (int)spinnerLargeur.getValue(),
                (int)spinnerHauteur.getValue()},
        {
                (int)spinnerLargeur2.getValue(),
                (int)spinnerHauteur2.getValue()
        }};

        Matrice tempo1= new Matrice(dimensions[1][1], dimensions[1][2]);
        Matrice tempo2= new Matrice(dimensions[2][1], dimensions[2][2]);


        tabPane.getTabs().add(
                new BetterTab(
                        tempo1,
                        tempo2,
                        new MatriceView(tempo1),
                        new MatriceView(tempo2)
        ));
    }



    public static HBox creation(Spinner spinnerLargeur, Spinner spinnerHauteur){
        Label hauteur = new Label("Hauteur");
        Label largeur = new Label("Largeur");
        VBox vBox1 = new VBox(largeur, spinnerLargeur);
        VBox vBox2 = new VBox(hauteur, spinnerHauteur);
        HBox hBox = new HBox(vBox1, vBox2);
        return hBox;
    }
}
