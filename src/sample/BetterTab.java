package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.MatriceView;

import java.util.ArrayList;

public class BetterTab extends Tab {
    int nombreDeMatrices;

    ArrayList<MatriceView> matrices = new ArrayList<>();
    MatriceView resultatView;

    ArrayList<Label> labels = new ArrayList<>();
    ArrayList<VBox> vBoxes = new ArrayList<>();
    HBox hBoxRoot = new HBox();

    public BetterTab(int nombreDeMatrices) {
        this.nombreDeMatrices = nombreDeMatrices;
        this.resultatView = new MatriceView(new Matrice(3,3));

        creerMatrices(nombreDeMatrices);
        creerLabels(nombreDeMatrices);
        arrangerDisposition(nombreDeMatrices);

        super.setText("Nouvel onglet");
        this.setContent(hBoxRoot);
    }

    /*
    public BetterTab(MatriceView matriceView1, MatriceView matriceView2) {
        this.resultatView = new MatriceView(new Matrice(3,3));

        creerLabels();
        arrangerDisposition();

        super.setText("Nouvel onglet");
        this.setContent(hBoxRoot);
    }
*/

    public void creerMatrices(int nombre){
        for (int i=0; i<nombre; i++)
            matrices.add(genererMatrice());
        matrices.add(resultatView);
    }

    public MatriceView genererMatrice(){
        Spinner spinnerHauteur = new Spinner(1,10,1);
        Spinner spinnerLargeur = new Spinner(1,10,1);

        HBox root = new HBox(
                new Label("Matrice 1"),
                creation(spinnerLargeur, spinnerHauteur)
        );


        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);

        dialog.getDialogPane().getButtonTypes().add(
                new ButtonType("Générer", ButtonBar.ButtonData.OK_DONE)
        );

        dialog.setHeaderText("Entrez les dimensions des nouvelles matrices");

        dialog.showAndWait();

        int[] dimensions = {
                (int)spinnerLargeur.getValue(),
                (int)spinnerHauteur.getValue()};

        return new MatriceView(
                new Matrice(dimensions[0], dimensions[1])
        );
    }

    public static HBox creation(Spinner spinnerLargeur, Spinner spinnerHauteur){
        Label hauteur = new Label("Hauteur");
        Label largeur = new Label("Largeur");
        VBox vBox1 = new VBox(largeur, spinnerLargeur);
        VBox vBox2 = new VBox(hauteur, spinnerHauteur);
        HBox hBox = new HBox(vBox1, vBox2);
        hBox.setSpacing(30);
        return hBox;
    }

    public void creerLabels(int nombre){
        for (int i=0; i<=nombre; i++){
            Label label = new Label("Matrice "+ (char)(i+65));
            label.setScaleX(2);
            label.setScaleY(2);
            if (i==nombre)
                label.setText("Résultat");
            labels.add(label);
        }
    }

    public void arrangerDisposition(int nombre){

        for (int i=0; i<=nombre; i++){
                VBox vBox = new VBox();
                vBox.getChildren().add(labels.get(i));
                vBox.getChildren().add(matrices.get(i));
                vBox.setSpacing(50);
                vBoxes.add(vBox);
        }

        hBoxRoot.getChildren().addAll(vBoxes);
        hBoxRoot.setSpacing(100);
        hBoxRoot.setAlignment(Pos.CENTER);
        hBoxRoot.setPadding(new Insets(50));
    }


    public MatriceView getResultatView() {
        return resultatView;
    }

    public void setResultatView(MatriceView resultatView) {
        this.resultatView = resultatView;
        matrices.remove(this.nombreDeMatrices);
        matrices.add(this.nombreDeMatrices, this.resultatView);
    }
}
