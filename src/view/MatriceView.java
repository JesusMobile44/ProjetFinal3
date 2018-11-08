package view;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import sample.Matrice;

public class MatriceView extends GridPane{
    public MatriceView(Matrice matrice) {
        addColumn(matrice.getWidth());
        addRow(matrice.getHeight());
        for (int y=0;y<matrice.getHeight();y++){
            for (int x=0;x<matrice.getWidth();x++){
                TextField tf = new TextField();
                tf.setPrefHeight(50);
                tf.setPrefWidth(50);
                tf.setAlignment(Pos.CENTER);
                tf.setEditable(true);

                if (String.valueOf(matrice.getTab()[x][y])==null){
                    tf.setText("0");
                }
                else {
                    tf.setText(String.valueOf(matrice.getTab()[x][y]));
                }

                setRowIndex(tf,y);
                setColumnIndex(tf,x);
                getChildren().add(tf);
            }
        }
    }
}
