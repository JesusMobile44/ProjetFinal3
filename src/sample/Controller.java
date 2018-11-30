package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import view.MatriceView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    //Opérations
    public void multiplicationParScalaire(){

        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()==1)
        ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(choixMatrice().get(0).multiParNombre(dialogueMultiplicationParScalaire())));

        else
            erreurNombreMatrice("Veuillez ne sélectionner qu'une seule matrice lors de la multiplication par un scalaire.");
    }


    public int dialogueMultiplicationParScalaire(){
        TextInputDialog alerte = new TextInputDialog("Entrez ici");
        alerte.setTitle("Multiplication par scalaire");
        alerte.setHeaderText("Quel est le scalaire à multiplier");
        alerte.setContentText(
                "Nombre: ");
        return Integer.parseInt(alerte.showAndWait().get());
    }

    public void addition(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()!=1) {
            Matrice resultatIntermediaire = listeMatricesAOperer.get(0);
            for (int i=0; i<listeMatricesAOperer.size()-1;i++) {
                System.out.println("listeMatricesAOperer    "+listeMatricesAOperer.get(i).getMatriceTab()[0][0]);
                resultatIntermediaire = resultatIntermediaire.additionSoustraction(listeMatricesAOperer.get(i + 1), true);
            }

            System.out.println("resultat intermediaire    "+resultatIntermediaire.getMatriceTab()[0][0]);
            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(resultatIntermediaire));

            System.out.println("final    "+((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).getResultatView().getMatriceVraie().getMatriceTab()[0][0]);
        }

        else
            erreurNombreMatrice("Veuillez sélectionner plus qu'une matrice lors de l'addition de matrices");
    }


    public void soustraction(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()!=1) {
            Matrice resultatIntermediaire = listeMatricesAOperer.get(0);
            for (int i=0; i<listeMatricesAOperer.size()-1;i++)
                resultatIntermediaire=resultatIntermediaire.additionSoustraction(listeMatricesAOperer.get(i+1), false);

            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(resultatIntermediaire));
        }

        else
            erreurNombreMatrice("Veuillez sélectionner plus qu'une matrice lors de la soustraction de matrices");
    }

    public void puissance(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()==1)
            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(listeMatricesAOperer.get(0).puissance(dialoguePuissance())));

        else
            erreurNombreMatrice("Veuillez ne sélectionner qu'une seule matrice lors de la puissance de matrice.");
    }

    public int dialoguePuissance(){
        TextInputDialog alerte = new TextInputDialog("Entrez ici");
        alerte.setTitle("Puissance de matrice");
        alerte.setHeaderText("Quelle est la puissance de la matrice");
        alerte.setContentText(
                "Nombre: ");
        return Integer.parseInt(alerte.showAndWait().get());
    }

    public void transposition(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()==1)
            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(listeMatricesAOperer.get(0).transposition()));

        else
            erreurNombreMatrice("Veuillez ne sélectionner qu'une seule matrice lors de la transposition d'une matrice.");
    }

    public void inversion(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()==1)
            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(listeMatricesAOperer.get(0).inversion()));

        else
            erreurNombreMatrice("Veuillez ne sélectionner qu'une seule matrice lors de l'inversion d'une matrice.");
    }

    public void produitMatriciel(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()!=1) {
            Matrice resultatIntermediaire = listeMatricesAOperer.get(0);
            for (int i=0; i<listeMatricesAOperer.size()-1;i++)
                resultatIntermediaire=resultatIntermediaire.produitMatriciel(listeMatricesAOperer.get(i+1));

            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(resultatIntermediaire));
        }

        else
            erreurNombreMatrice("Veuillez sélectionner plus qu'une matrice lors du produit matriciel");
    }

    public void produitVectoriel(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()!=1) {
            Matrice resultatIntermediaire = listeMatricesAOperer.get(0);
            for (int i=0; i<listeMatricesAOperer.size()-1;i++)
                resultatIntermediaire=resultatIntermediaire.produitVectoriel(listeMatricesAOperer.get(i+1));

            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(resultatIntermediaire));
        }

        else
            erreurNombreMatrice("Veuillez sélectionner plus qu'une matrice lors du produit vectoriel");
    }

    public void produitHadamard(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()!=1) {
            Matrice resultatIntermediaire = listeMatricesAOperer.get(0);
            for (int i=0; i<listeMatricesAOperer.size()-1;i++)
                resultatIntermediaire=resultatIntermediaire.produitHadamard(listeMatricesAOperer.get(i+1));

            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(resultatIntermediaire));
        }

        else
            erreurNombreMatrice("Veuillez sélectionner plus qu'une matrice lors du produit d'Hadamard");
    }

    public void produitTensoriel(){
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()!=1) {
            Matrice resultatIntermediaire = listeMatricesAOperer.get(0);
            for (int i=0; i<listeMatricesAOperer.size()-1;i++)
                resultatIntermediaire=resultatIntermediaire.produitTensoriel(listeMatricesAOperer.get(i+1));

            ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                    new MatriceView(resultatIntermediaire));
        }

        else
            erreurNombreMatrice("Veuillez sélectionner plus qu'une matrice lors du produit tensoriel");
    }


    public void calculDeterminant(){
/*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.multiParNombre(2));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        System.out.println(matrice.determinant());
    }

    //Fichiers
    public void genererMatrices(){
        TextInputDialog alerte = new TextInputDialog("Entrez ici");
        alerte.setTitle("Nouvel onglet");
        alerte.setHeaderText("Combien de matrices doit contenir le nouvel onglet? (1 à 4)");
        alerte.setContentText(
                "Nombre: ");
        String resultat = alerte.showAndWait().get();
        System.out.println(resultat);

        Main.getTabPane().getTabs().add(new BetterTab(Integer.valueOf(resultat)));
    }


    public void importerMatrice(){
        boolean ok = true;
        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Veuillez sélectionner un fichier");
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Fichier CSV","*.csv")
            );
            File file = fc.showOpenDialog(Main.getStage());

            //lire la matrice
            BufferedReader entree = new BufferedReader(
                    new FileReader(file));
            List<String> allLines = new ArrayList<>();
            for (int i=0;i<file.length();i++){
                String s = entree.readLine();
                if (s==null){
                    break;
                }
                allLines.add(s);

            }
        }catch (Exception e){
            System.out.println("Erreur, fichier non compatible");
        }

    }

    public void importerOperations(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.additionSoustraction(betterTab.getMatrice2(), false));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */

    }


    //Autres fonctions utiles
    public ArrayList<Matrice> choixMatrice(){
        int positionTabActive = trouverMatrice();
        BetterTab betterTab =((BetterTab)Main.getTabPane().getTabs().get(positionTabActive));
        int nombreMatrice = betterTab.getNombreDeMatrices();
        HBox[] hBoxes = new HBox[nombreMatrice+1];
        VBox root = new VBox();
        root.getChildren().add(new Label("Veuillez cocher la ou les matrices sur laquelle ou lesquelles effectuer l'opération"));
        root.setSpacing(30);
        CheckBox[] checkBoxes = new CheckBox[nombreMatrice+1];

        for (int i=0; i<nombreMatrice+1; i++){
            checkBoxes[i]= new CheckBox();
            hBoxes[i] = new HBox();
            if (i!=nombreMatrice)
                hBoxes[i].getChildren().add(new Label("Matrice "+ (char)(i+65)));
            else
                hBoxes[i].getChildren().add(new Label("Résultat"));
            hBoxes[i].getChildren().get(0).setScaleX(1);
            hBoxes[i].getChildren().get(0).setScaleY(1);
            hBoxes[i].getChildren().add(checkBoxes[i]);
            hBoxes[i].setSpacing(20);
            hBoxes[i].setAlignment(Pos.CENTER);
            root.getChildren().add(hBoxes[i]);
        }

        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);

        dialog.getDialogPane().getButtonTypes().add(
                new ButtonType("Opérer", ButtonBar.ButtonData.OK_DONE)
        );

        dialog.setHeaderText("Nouvelle opération");

        dialog.showAndWait();

        ArrayList<Matrice> retour = new  ArrayList<Matrice>();
        for (int i=0; i<checkBoxes.length; i++){
            if (checkBoxes[i].isSelected())
                retour.add(convertirMatrice(
                        betterTab.getMatrices().get(i).getMatriceVraie().getMatriceTab(),
                        betterTab.getMatrices().get(i).getMatriceVraie().getHeight(),
                        betterTab.getMatrices().get(i).getMatriceVraie().getWidth()
                ));
        }
        return retour;
    }


    public void erreurNombreMatrice(String message){
        Alert alerte = new Alert(Alert.AlertType.INFORMATION);
        alerte.setTitle("Information importante");
        alerte.setHeaderText("Erreur lors de l'opération");
        alerte.setContentText(message);
        alerte.showAndWait();
    }

    public int trouverMatrice(){
        for (int i = 0; i<Main.getTabPane().getTabs().size(); i++){
            if (Main.getTabPane().getTabs().get(i).isSelected())
                return i;
        }
        return 0;
    }

    public Matrice convertirMatrice(int[][] tableau, int hauteur, int largeur){
        Matrice matrice = new Matrice(hauteur, largeur);
        for (int i=0; i<hauteur; i++){
            for (int j=0; j<largeur; j++)
                matrice.getMatriceTab()[i][j] = tableau[i][j];
        }
        System.out.println("convertir matrice    "+matrice.getMatriceTab()[0][0]);
        return matrice;
    }
}
