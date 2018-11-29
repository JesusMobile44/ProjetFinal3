package sample;

import view.MatriceView;

public class Controller {

    public void multiplicationParScalaire(){
        //Dialogue qui permet de changer le scalaire
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.multiParNombre(2)));
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
        //Dialogue qui permet de changer le scalaire
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        ((BetterTab) Main.tabPane.getTabs().get(positionTabActive)).setResultatView(
                new MatriceView(matrice.puissance(2)));
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
        int positionTabActive = trouverMatrice();
        Matrice matrice = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView1().getMatriceVraie();
        Matrice matrice2 = ((BetterTab)Main.tabPane.getTabs().get(positionTabActive)).getMatriceView2().getMatriceVraie();
        System.out.println(matrice.determinant());
    }

    public int trouverMatrice(){
        for (int i = 0; i<Main.tabPane.getTabs().size(); i++){
            if (Main.tabPane.getTabs().get(i).isSelected())
                return i;
        }
        return 0;
    }
}
