package sample;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.MatriceView;

import java.util.ArrayList;

public class BetterTab extends Tab {
    private int nombreDeMatrices;

    private ArrayList<MatriceView> matrices = new ArrayList<>();
    private MatriceView resultatView;

    private ArrayList<Label> labels = new ArrayList<>();
    private ArrayList<VBox> vBoxes = new ArrayList<>();
    private HBox hBoxRoot = new HBox();

    public BetterTab(int nombreDeMatrices) {
        this.nombreDeMatrices = nombreDeMatrices;
        this.resultatView = new MatriceView(new Matrice(3,3));

        creerMatrices(nombreDeMatrices);
        creerLabels(nombreDeMatrices);
        arrangerDisposition(nombreDeMatrices);

        super.setText("Nouvel onglet");
        this.setContent(hBoxRoot);
    }

    public BetterTab(int nombreDeMatrices, ArrayList<Matrice> liste) {
        this.nombreDeMatrices = nombreDeMatrices;
        this.resultatView = new MatriceView(new Matrice(3,3));

        for (int i=0; i<liste.size(); i++)
            matrices.add(new MatriceView(liste.get(i)));
        matrices.add(resultatView);

        creerLabels(nombreDeMatrices);
        arrangerDisposition(nombreDeMatrices);

        super.setText("Nouvel onglet");
        this.setContent(hBoxRoot);
    }


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
                if (i==nombre){
                    TextArea demarche = new TextArea();
                    demarche.setWrapText(true);
                    vBox.getChildren().add(demarche);
                }

                vBox.setSpacing(50);
                vBoxes.add(vBox);
        }

        hBoxRoot.getChildren().addAll(vBoxes);
        hBoxRoot.getChildren().add(nombre, new Separator(Orientation.VERTICAL));
        hBoxRoot.setSpacing(100);
        hBoxRoot.setAlignment(Pos.CENTER);
        hBoxRoot.setPadding(new Insets(50));
    }


    public MatriceView getResultatView() {
        return resultatView;
    }

    public void setResultatView(MatriceView resultatView) {
        this.resultatView = resultatView;
        System.out.println("setResultatView    "+resultatView.getMatriceVraie().getMatriceTab()[0][0]);
        matrices.remove(this.nombreDeMatrices);
        matrices.add(this.nombreDeMatrices, this.resultatView);
        vBoxes.get(nombreDeMatrices).getChildren().set(1, resultatView);
        for (int j=0; j<resultatView.getMatriceVraie().getDescription().size(); j++){
            TextArea textArea = (TextArea) getvBoxes().get(nombreDeMatrices).getChildren().get(getvBoxes().get(nombreDeMatrices).getChildren().size()-1);
            textArea.setPromptText(textArea.getPromptText() + resultatView.getMatriceVraie().getDescription().get(j)+"\n");
        }
    }

    public int getNombreDeMatrices() {
        return nombreDeMatrices;
    }

    public void setNombreDeMatrices(int nombreDeMatrices) {
        this.nombreDeMatrices = nombreDeMatrices;
    }

    public ArrayList<MatriceView> getMatrices() {
        return matrices;
    }

    public void setMatrices(ArrayList<MatriceView> matrices) {
        this.matrices = matrices;
    }

    public ArrayList<Label> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Label> labels) {
        this.labels = labels;
    }

    public ArrayList<VBox> getvBoxes() {
        return vBoxes;
    }

    public void setvBoxes(ArrayList<VBox> vBoxes) {
        this.vBoxes = vBoxes;
    }
}
