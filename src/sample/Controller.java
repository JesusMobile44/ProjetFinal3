package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.print.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import view.MatriceView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {

    //Opérations
    public void operationsMixtes(){
        int positionTabActive = trouverMatrice();
        ArrayList[] retour = dialogueMixtes();
        ArrayList<Matrice> matrices = retour[0];
        ArrayList<String> operations =retour[1];
        Matrice resultatTemp= matrices.get(0);
        for (int i=0; i<operations.size(); i++){
            switch (operations.get(i).toUpperCase()){
                case "ADDITION":
                    resultatTemp=resultatTemp.additionSoustraction(matrices.get(i+1), true);
                    break;
                case "SOUSTRACTION":
                    resultatTemp=resultatTemp.additionSoustraction(matrices.get(i+1), false);
                    break;
                case "PRODUIT MATRICIEL":
                    resultatTemp=resultatTemp.produitMatriciel(matrices.get(i+1));
                    break;
                case "PRODUIT VECTORIEL":
                    resultatTemp=resultatTemp.produitVectoriel(matrices.get(i+1));
                    break;
                case "PRODUIT D'HADAMARD":
                    resultatTemp=resultatTemp.produitHadamard(matrices.get(i+1));
                    break;
                case "PRODUIT TENSORIEL":
                    resultatTemp=resultatTemp.produitTensoriel(matrices.get(i+1));
                    break;
            }
        }

        ((BetterTab) Main.getTabPane().getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(resultatTemp));

    }

    public ArrayList[] dialogueMixtes(){
        ArrayList[] retour = new ArrayList[2];
        ArrayList<Matrice> matrices = new ArrayList<>();
        ArrayList<String> operations = new ArrayList<>();

        int positionTabActive = trouverMatrice();
        BetterTab betterTab =((BetterTab)Main.getTabPane().getTabs().get(positionTabActive));
        int nombreMatrice = betterTab.getNombreDeMatrices();
        HBox optionsPossibles = new HBox();
        VBox root = new VBox();

        for (int i=0; i<nombreMatrice+1; i++) {
            if (i != nombreMatrice)
                optionsPossibles.getChildren().add(new Label("Matrice " + (char) (i + 65)));
            else
                optionsPossibles.getChildren().add(new Label("Résultat"));
            optionsPossibles.getChildren().get(i).setScaleX(1);
            optionsPossibles.getChildren().get(i).setScaleY(1);
        }
        optionsPossibles.setSpacing(20);
        optionsPossibles.setAlignment(Pos.CENTER);
        root.getChildren().add(optionsPossibles);

        Button boutonPlus = new Button("+");
        String stringMatrices = "Matrice";
        String stringOp = "Opération";
        HBox ligneOperations = new HBox();
        VBox[] vBoxes = new VBox[10];
        AtomicInteger positionPlus = new AtomicInteger(3);



        ArrayList<ChoiceBox> choiceBoxesMatrices = new ArrayList<>();
        ArrayList<ChoiceBox> choiceBoxesOperations = new ArrayList<>();


        for (int i=0; i<=positionPlus.get(); i++){
            vBoxes[i]= new VBox();
            if (i%2==0){
                vBoxes[i].getChildren().add(new Label(stringMatrices));
                ArrayList<String> liste = new ArrayList<>();
                for (int j=0; j<optionsPossibles.getChildren().size(); j++)
                    liste.add(((Label)optionsPossibles.getChildren().get(i)).getText());

                ObservableList<String> observableList = FXCollections.observableList(liste);
                ChoiceBox<String> choix = new ChoiceBox<>(observableList);
                choix.setValue(liste.get(0));
                vBoxes[i].getChildren().add(choix);
                choiceBoxesMatrices.add(choix);
            }
            else if (i==positionPlus.get()){
                vBoxes[i].getChildren().add(boutonPlus);
            }

            else {
                vBoxes[i].getChildren().add(new Label(stringOp));
                List<String> liste = Arrays.asList("Addition", "Soustraction", "Produit matriciel", "Produit vectoriel", "Produit d'Hadamard", "Produit tensoriel");
                ObservableList<String> observableList = FXCollections.observableList(liste);
                ChoiceBox<String> choix = new ChoiceBox<>(observableList);
                choix.setValue(liste.get(0));
                vBoxes[i].getChildren().add(choix);
                choiceBoxesOperations.add(choix);
            }
            vBoxes[i].setSpacing(10);
            vBoxes[i].setAlignment(Pos.CENTER);
            ligneOperations.getChildren().add(vBoxes[i]);
        }
        ligneOperations.setSpacing(20);
        ligneOperations.setAlignment(Pos.CENTER);

        root.getChildren().add(ligneOperations);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);

        boutonPlus.setOnAction(event -> {
            vBoxes[positionPlus.get()]=new VBox();
            for (int i=positionPlus.get(); i<=positionPlus.get()+2; i++){

                if (i%2==0){
                    vBoxes[i].getChildren().add(new Label(stringMatrices));
                    ArrayList<String> liste = new ArrayList<>();
                    for (int j=0; j<optionsPossibles.getChildren().size(); j++)
                        liste.add(((Label)optionsPossibles.getChildren().get(i)).getText());

                    ObservableList<String> observableList = FXCollections.observableList(liste);
                    ChoiceBox<String> choix = new ChoiceBox<>(observableList);
                    choix.setValue(liste.get(0));
                    vBoxes[i].getChildren().add(choix);
                    choiceBoxesMatrices.add(choix);
                }
                else if (i==positionPlus.get()+2){
                    vBoxes[i].getChildren().add(boutonPlus);
                }

                else {
                    vBoxes[i].getChildren().add(new Label(stringOp));
                    List<String> liste = Arrays.asList("Addition", "Soustraction", "Produit matriciel", "Produit vectoriel", "Produit d'Hadamard", "Produit tensoriel");
                    ObservableList<String> observableList = FXCollections.observableList(liste);
                    ChoiceBox<String> choix = new ChoiceBox<>(observableList);
                    choix.setValue(liste.get(0));
                    vBoxes[i].getChildren().add(choix);
                    choiceBoxesOperations.add(choix);
                }
                vBoxes[i].setSpacing(10);
                vBoxes[i].setAlignment(Pos.CENTER);
                ligneOperations.getChildren().add(vBoxes[i]);
            }
            positionPlus.set(positionPlus.get()+2);
        });

        Dialog dialog = new Dialog();
        dialog.getDialogPane().setContent(root);
        dialog.getDialogPane().getButtonTypes().add(
                new ButtonType("Terminé", ButtonBar.ButtonData.OK_DONE)
        );
        dialog.setTitle("Opérations mixtes");
        dialog.setHeight(700);
        dialog.setResizable(true);
        dialog.setWidth(1000);
        dialog.showAndWait();

        for (int i=0; i<choiceBoxesMatrices.size(); i++){
            switch (choiceBoxesMatrices.get(i).getValue().toString().toUpperCase()){
                case "MATRICE A":
                    matrices.add(betterTab.getMatrices().get(0).getMatriceVraie());
                    break;
                case "MATRICE B":
                    matrices.add(betterTab.getMatrices().get(1).getMatriceVraie());
                    break;
                case "MATRICE C":
                    matrices.add(betterTab.getMatrices().get(2).getMatriceVraie());
                    break;
                case "MATRICE D":
                    matrices.add(betterTab.getMatrices().get(3).getMatriceVraie());
                    break;
                case "MATRICE E":
                    matrices.add(betterTab.getMatrices().get(4).getMatriceVraie());
                    break;
                default:
                    matrices.add(betterTab.getMatrices().get(betterTab.getNombreDeMatrices()).getMatriceVraie());
            }
        }

        for (int i=0; i<choiceBoxesOperations.size(); i++)
            operations.add(choiceBoxesOperations.get(i).getValue().toString().toUpperCase());

        retour[0]=matrices;
        retour[1]=operations;
        return retour;
    }



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
        int positionTabActive = trouverMatrice();
        ArrayList<Matrice> listeMatricesAOperer = choixMatrice();

        if (listeMatricesAOperer.size()==1) {
            System.out.println(listeMatricesAOperer.get(0).nouveauDeterminant());
        }

        else
            erreurNombreMatrice("Veuillez sélectionner une seule matrice lors du calcul du déterminant");
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
        List<String> allLines = new ArrayList<>();
        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Veuillez sélectionner un fichier");
            fc.getExtensionFilters().addAll(
                    //new FileChooser.ExtensionFilter("Fichier CSV","*.csv")
            );
            File file = fc.showOpenDialog(Main.getStage());

            //lire la matrice
            BufferedReader entree = new BufferedReader(
                    new FileReader(file));

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

            ArrayList<Matrice> matrices = new ArrayList<>();

            for (int i=0; i<allLines.size(); i++){
                String chaine = allLines.get(i);
                String[] lines = chaine.split(",");
                double[] nombres = new double[lines.length];

                for (int j=0; j<lines.length; j++)
                    nombres[j] = (Double.parseDouble(lines[j].trim()));

                    int hauteur = (int)nombres[0];
                    int largeur = (int)nombres[1];
                    matrices.add(new Matrice(largeur, hauteur));
                int tour =2;
                for (int j=0; j<matrices.get(i).getHeight(); j++){
                    for (int k=0; k<matrices.get(i).getWidth(); k++){
                        matrices.get(i).getMatriceTab()[j][k]=nombres[tour];
                        tour++;
                    }
                }
            }

            Main.getTabPane().getTabs().add(new BetterTab(matrices.size(), matrices));
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
    public void imprimerResultat(){
        int positionTabActive = trouverMatrice();
        BetterTab betterTab =((BetterTab)Main.getTabPane().getTabs().get(positionTabActive));
        MatriceView matriceView = betterTab.getResultatView();
        Printer printer = Printer.getDefaultPrinter();
        PrinterJob printerJob = PrinterJob.createPrinterJob(printer);
        PageLayout pageLayout = printerJob.getJobSettings().getPageLayout();
        printerJob.getJobSettings().setPageLayout(pageLayout);
        if (printerJob!=null){
            boolean ok = printerJob.printPage(matriceView);
            if (ok) {
                printerJob.endJob();
            }
        }
    }


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

    public Matrice convertirMatrice(double[][] tableau, int hauteur, int largeur){
        Matrice matrice = new Matrice(hauteur, largeur);
        for (int i=0; i<hauteur; i++){
            for (int j=0; j<largeur; j++)
                matrice.getMatriceTab()[i][j] = tableau[i][j];
        }
        System.out.println("convertir matrice    "+matrice.getMatriceTab()[0][0]);
        return matrice;
    }
}
