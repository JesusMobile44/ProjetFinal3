package sample;

import javafx.fxml.FXML;
import view.MatriceView;

public class Controller {

    public void multiplicationParScalaire(){
        /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        ((BetterTab) Main.tabPane.getTabs().get(0)).setResultat(matrice.multiParNombre(2));
        ((BetterTab) Main.tabPane.getTabs().get(0)).setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void genererMatrices(){
        Main.generer();
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
        BetterTab betterTab = ((BetterTab)Main.tabPane.getTabs().get(0));
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(0)).getMatriceView1().getMatriceVraie();
        System.out.println(matrice.getMatriceTab()[0][0]);
        System.out.println(matrice.getMatriceTab()[0][1]);
        System.out.println(matrice.getMatriceTab()[0][2]);
        System.out.println(matrice.getMatriceTab()[1][1]);
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(0)).getMatriceView2().getMatriceVraie();
        System.out.println(matrice2.getMatriceTab()[0][0]);
        System.out.println(matrice2.getMatriceTab()[0][1]);
        System.out.println(matrice2.getMatriceTab()[0][2]);
        System.out.println(matrice2.getMatriceTab()[1][1]);
        ((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().setMatriceVraie(matrice.additionSoustraction(betterTab.getMatriceView2().getMatriceVraie(), true));
        ((BetterTab) Main.tabPane.getTabs().get(0)).setResultatView(new MatriceView(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie()));
        System.out.print(1);
        System.out.println(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie().getMatriceTab()[0][0]);
        System.out.println(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie().getMatriceTab()[0][1]);
        System.out.println(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie().getMatriceTab()[0][2]);
        System.out.println(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie().getMatriceTab()[1][0]);
        System.out.println(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie().getMatriceTab()[1][1]);
        System.out.println(((BetterTab) Main.tabPane.getTabs().get(0)).getResultatView().getMatriceVraie().getMatriceTab()[1][2]);

    }


    public void soustraction(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.additionSoustraction(betterTab.getMatrice2(), false));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void puissance(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.puissance(4));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void transposition(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.transposition());
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void inversion(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.multiParNombre(2));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void produitMatriciel(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.produitMatriciel(betterTab.getMatrice2()));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void produitVectoriel(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.produitVectoriel(betterTab.getMatrice2()));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void produitHadamard(){
        /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.produitHadamard(betterTab.getMatrice2()));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void produitTensoriel(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.multiParNombre(2));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }

    public void calculDeterminant(){
    /*
        BetterTab betterTab = (BetterTab)Main.tabPane.getTabs().get(0);
        Matrice matrice = betterTab.getMatrice1();
        betterTab.setResultat(matrice.multiParNombre(2));
        betterTab.setResultatView(new MatriceView(betterTab.getResultat()));
        */
    }
}
