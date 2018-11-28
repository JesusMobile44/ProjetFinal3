package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import view.MatriceView;

public class Controller {



    public void multiplicationParScalaire(){
            TextInputDialog alerte = new TextInputDialog("Entrez ici");
            alerte.setTitle("Multiplication par scalaire");
            alerte.setHeaderText("Quel est le scalaire à multiplier");
            alerte.setContentText(
                    "Nombre: ");
            String resultat = alerte.showAndWait().get();
            System.out.println(resultat);

        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.multiParNombre(Integer.parseInt(resultat))));
    }


    public void genererMatrices(){
        TextInputDialog alerte = new TextInputDialog("Entrez ici");
        alerte.setTitle("Nouvel onglet");
        alerte.setHeaderText("Combien de matrices doit contenir le nouvel onglet? (1 à 4)");
        alerte.setContentText(
                "Nombre: ");
        String resultat = alerte.showAndWait().get();
        System.out.println(resultat);

        Main.tabPane.getTabs().add(new BetterTab(Integer.valueOf(resultat)));
    }


    public void importerMatrice(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.additionSoustraction(betterTab.getMatrice2(), true));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */

    }

    public void importerOperations(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.additionSoustraction(betterTab.getMatrice2(), false));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */

    }


    public void addition(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.additionSoustraction(matrice2, true)));
    }


    public void soustraction(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.additionSoustraction(matrice2, false)));
    }

    public void puissance(){
        TextInputDialog alerte = new TextInputDialog("Entrez ici");
        alerte.setTitle("Puissance de matrice");
        alerte.setHeaderText("Quelle est la puissance de la matrice");
        alerte.setContentText(
                "Nombre: ");
        String resultat = alerte.showAndWait().get();
        System.out.println(resultat);

        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.puissance(Integer.parseInt(resultat))));
    }

    public void transposition(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.transposition()));
    }

    public void inversion(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.inversion()));
    }

    public void produitMatriciel(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.produitMatriciel(matrice2)));
    }

    public void produitVectoriel(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.produitVectoriel(matrice2)));
    }

    public void produitHadamard(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.produitHadamard(matrice2)));
    }

    public void produitTensoriel(){
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.produitTensoriel(matrice2)));
    }


    public void calculDeterminant(){
/*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.multiParNombre(2));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */


    }

    public int trouverMatrice(){
        for (int i = 0; i<Main.tabPane.getTabs().size(); i++){
            if (Main.tabPane.getTabs().get(i).isSelected())
                return i;
        }
        return 0;
    }
}
