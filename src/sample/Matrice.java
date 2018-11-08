package sample;

import javafx.scene.layout.GridPane;

public class Matrice {
    int width;
    int height;
    int[][] tab;

    public Matrice(int width, int height) {
        this.width = width;
        this.height = height;
        this.tab = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }
}
