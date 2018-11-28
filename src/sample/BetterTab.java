package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.MatriceView;

public class BetterTab extends Tab {

    MatriceView matriceView1;
    MatriceView matriceView2;
    MatriceView resultatView;

    Label[] labels = new Label[3];
    VBox[] vBoxes = new VBox[3];
    HBox hBoxRoot = new HBox();

    public BetterTab(MatriceView matriceView1, MatriceView matriceView2) {
        this.matriceView1 = matriceView1;
        this.matriceView2 = matriceView2;
        this.resultatView = new MatriceView(new Matrice(3,3));

        creerLabels();
        arrangerDisposition();

        super.setText("Nouvel onglet");
        this.setContent(hBoxRoot);
    }

    public void creerLabels(){
        for (int i=0; i<3; i++){
            labels[i] = new Label("Matrice 1");
            labels[i].setScaleX(3);
            labels[i].setScaleY(3);
        }
        labels[1].setText("Matrice 2");
        labels[2].setText("Résultat");
    }

    public void arrangerDisposition(){

        for (int i=0; i<3; i++){
            vBoxes[i] = new VBox(labels[i]);
            vBoxes[i].setSpacing(50);
        }
        vBoxes[0].getChildren().add(matriceView1);
        vBoxes[1].getChildren().add(matriceView2);
        vBoxes[2].getChildren().add(resultatView);

        hBoxRoot.getChildren().addAll(vBoxes);
        hBoxRoot.setSpacing(100);
        hBoxRoot.setAlignment(Pos.CENTER);
        hBoxRoot.setPadding(new Insets(50));
    }

    public MatriceView getMatriceView1() {
        return matriceView1;
    }

    public void setMatriceView1(MatriceView matriceView1) {
        this.matriceView1 = matriceView1;
    }

    public MatriceView getMatriceView2() {
        return matriceView2;
    }

    public void setMatriceView2(MatriceView matriceView2) {
        this.matriceView2 = matriceView2;
    }

    public MatriceView getResultatView() {
        return resultatView;
    }

    public void setResultatView(MatriceView resultatView) {
        this.resultatView = resultatView;
        vBoxes[2].getChildren().remove(1);
        vBoxes[2].getChildren().add(1, this.resultatView);
    }
}
