package sample;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.MatriceView;

public class BetterTab extends Tab {

    MatriceView matriceView1;
    MatriceView matriceView2;
    MatriceView resultatView;
    Matrice matrice1;
    Matrice matrice2;
    Matrice resultat;
    Label label1;
    Label label2;
    Label label3;
    VBox vBox1;
    VBox vBox2;
    VBox vBox3;
    HBox hBox;

    public BetterTab(Matrice matrice1, Matrice matrice2, MatriceView matriceView1, MatriceView matriceView2) {
        this.matrice1 = matrice1;
        this.matrice2 = matrice2;
        this.matriceView1 = matriceView1;
        this.matriceView2 = matriceView2;
        this.resultatView = new MatriceView(
                resultat);
        label1.setText("Matrice 1");
        label2.setText("Matrice 2");
        label3.setText("Résultat");
        vBox1.getChildren().addAll(label1, matriceView1);
        vBox2.getChildren().addAll(label2, matriceView2);
        vBox3.getChildren().addAll(label3, resultatView);
        hBox.getChildren().addAll(vBox1, vBox2, vBox3);
        super.setText("Nouvel onglet");
    }
}
