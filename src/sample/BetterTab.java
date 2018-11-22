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
    Label label1;
    Label label2;
    Label label3;
    VBox vBox1 = new VBox();
    VBox vBox2= new VBox();
    VBox vBox3= new VBox();
    HBox hBox= new HBox();

    public BetterTab(Matrice matrice1, Matrice matrice2, MatriceView matriceView1, MatriceView matriceView2) {
        this.matriceView1 = matriceView1;
        this.matriceView2 = matriceView2;
        this.resultatView = new MatriceView(new Matrice(1,1));
        label1= new Label("Matrice 1");
        label2= new Label("Matrice 2");
        label3= new Label("Résultat");

        vBox1.getChildren().addAll(label1, matriceView1);
        vBox2.getChildren().addAll(label2, matriceView2);
        vBox3.getChildren().addAll(label3, resultatView);
        hBox.getChildren().addAll(vBox1, vBox2, vBox3);
        super.setText("Nouvel onglet");

        this.setContent(hBox);
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
    }

    public Label getLabel1() {
        return label1;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public Label getLabel3() {
        return label3;
    }

    public void setLabel3(Label label3) {
        this.label3 = label3;
    }

    public VBox getvBox1() {
        return vBox1;
    }

    public void setvBox1(VBox vBox1) {
        this.vBox1 = vBox1;
    }

    public VBox getvBox2() {
        return vBox2;
    }

    public void setvBox2(VBox vBox2) {
        this.vBox2 = vBox2;
    }

    public VBox getvBox3() {
        return vBox3;
    }

    public void setvBox3(VBox vBox3) {
        this.vBox3 = vBox3;
    }

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }
}
