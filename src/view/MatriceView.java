package view;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import sample.Main;
import sample.Matrice;

public class MatriceView extends GridPane{

    Matrice matriceVraie = new Matrice(0,0);

    public MatriceView(Matrice matrice) {
        this.matriceVraie = matrice;
        addColumn(matrice.getWidth());
        addRow(matrice.getHeight());

        for (int y=0;y<matrice.getHeight();y++){
            for (int x=0;x<matrice.getWidth();x++){
                TextField tf = new TextField();
                tf.setPrefHeight(50);
                tf.setPrefWidth(50);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(true);
                tf.setOnAction(event -> {
                    int[][] temporaire = matriceVraie.getMatriceTab();
                    temporaire[getRowIndex(tf)][getColumnIndex(tf)]= Integer.valueOf(tf.getText());
                    matriceVraie.setMatriceTab(temporaire);

                });

                if (String.valueOf(matrice.getMatriceTab()[y][x]).equals("")){
                    tf.setText("0");
                }
                else {
                    tf.setText(String.valueOf(matrice.getMatriceTab()[y][x]));
                }

                setRowIndex(tf,y);
                setColumnIndex(tf,x);
                getChildren().add(tf);

            }
        }
    }

    public void changerVraieMatrice(Matrice matrice){
    }

    public Matrice getMatriceVraie() {
        return matriceVraie;
    }

    public void setMatriceVraie(Matrice matriceVraie) {
        this.matriceVraie = matriceVraie;
    }
}
