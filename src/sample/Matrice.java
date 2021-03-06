package sample;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Matrice {
    private int width;
    private int height;
    private double[][] matriceTab;
    private ArrayList<String> description;
    private String nom;

    public Matrice(int width, int height) {
        this.width = width;
        this.height = height;
        this.matriceTab = new double[height][width];
        this.description = new ArrayList<>();
        this.nom = nom;
    }

    public Matrice(int width, int height,String nom) {
        this.width = width;
        this.height = height;
        this.matriceTab = new double[height][width];
        this.description = new ArrayList<>();
        this.nom = nom;
    }

    public Matrice(int width, int height, double[][] matriceTab,String nom) {
        this.width = width;
        this.height = height;
        this.matriceTab = matriceTab;
        this.description = new ArrayList<>();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
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

    public double[][] getMatriceTab() {
        return matriceTab;
    }

    public void setMatriceTab(double[][] matriceTab) {
        this.matriceTab = matriceTab;
    }

    public boolean verifierAddition(Matrice matrice1){
        boolean ok = this.height == matrice1.height && this.width == matrice1.width;
        return ok;
    }
    public boolean verifierMultiplication(Matrice matrice1){
        boolean ok =this.height == matrice1.width;
        return ok;
    }
    public boolean verifierCarre(){
        boolean ok = this.getHeight()==this.getWidth();
        return ok;
    }

public void erreurFormat(){
    Alert alerte = new Alert(Alert.AlertType.INFORMATION);
    alerte.setTitle("Information importante");
    alerte.setHeaderText("Erreur lors de l'opération");
    alerte.setContentText("Le format des matrices n'est pas compatible");
    alerte.showAndWait();
}


    public Matrice additionSoustraction(Matrice matrice1, boolean add){
        Matrice resultat = new Matrice(this.getWidth(),this.getHeight(),"resultat");


        if (verifierAddition(matrice1)){
            for (int j=0;j<resultat.getWidth();j++){
                for (int i=0;i<resultat.getHeight();i++){
                    if (add){
                        resultat.getMatriceTab()[i][j] = this.getMatriceTab()[i][j] + matrice1.getMatriceTab()[i][j];
                        resultat.getDescription().add(" Addition : "+this.getMatriceTab()[i][j]+ "+"+matrice1.getMatriceTab()[i][j]+" = "+resultat.getMatriceTab()[i][j]);
                    }
                    else if (!add){
                        resultat.getMatriceTab()[i][j] = this.getMatriceTab()[i][j] - matrice1.getMatriceTab()[i][j];
                        resultat.getDescription().add(" Addition : "+this.getMatriceTab()[i][j]+ "-"+matrice1.getMatriceTab()[i][j]+" = "+resultat.getMatriceTab()[i][j]);
                    }
                }
            }
            return resultat;
        }

        erreurFormat();
        return null;
    }



    public Matrice inversion() {
        Matrice temp = new Matrice(this.getWidth(), this.getHeight(), this.getMatriceTab(), "resultat");
        if (verifierCarre()) {


            double detDepart = temp.nouveauDeterminant();
            for (int i = 0; i < this.getDescription().size(); i++) {
                temp.getDescription().add(this.getDescription().get(i));
            }
            this.getDescription().clear();

            if (detDepart != 0) {

                temp = temp.transposition();
                double[][][][] tabMatrices = new double[temp.getHeight()][temp.getWidth()][temp.getWidth() - 1][temp.getWidth() - 1];

                for (int l = 0; l < temp.getHeight(); l++) {
                    for (int i = 0; i < temp.getWidth(); i++) {
                        for (int j = 0; j < temp.getWidth() - 1; j++) {
                            for (int k = 0; k < temp.getWidth() - 1; k++) {
                                if (i <= k && l <= j)
                                    tabMatrices[i][l][k][j] = temp.getMatriceTab()[j + 1][k + 1];
                                else if (i <= k)
                                    tabMatrices[i][l][k][j] = temp.getMatriceTab()[j][k + 1];
                                else if (l <= j)
                                    tabMatrices[i][l][k][j] = temp.getMatriceTab()[j + 1][k];
                                else
                                    tabMatrices[i][l][k][j] = temp.getMatriceTab()[j][k];
                            }
                        }
                    }
                }

                for (int i = 0; i < temp.getWidth(); i++) {
                    for (int j = 0; j < temp.getWidth(); j++) {
                        Matrice calculs = new Matrice(temp.getWidth() - 1, temp.getHeight() - 1, tabMatrices[j][i], "resultat");
                        if ((i + j) % 2 == 1) {
                            temp.getMatriceTab()[j][i] = (calculs.nouveauDeterminant() * -1);
                            for (int y = 0; y < calculs.getDescription().size(); y++) {
                                temp.getDescription().add(calculs.getDescription().get(y));
                            }
                            calculs.getDescription().clear();
                        } else {
                            temp.getMatriceTab()[j][i] = (calculs.nouveauDeterminant());
                            for (int y = 0; y < calculs.getDescription().size(); y++) {
                                temp.getDescription().add(calculs.getDescription().get(y));
                            }
                            calculs.getDescription().clear();
                        }

                    }
                }

                return temp.multiParNombre(1 / detDepart).transposition();
            }
            System.out.println("Inversion : det = 0");
            Alert alerte = new Alert(Alert.AlertType.INFORMATION);
            alerte.setTitle("Information importante");
            alerte.setHeaderText("Erreur lors de l'opération");
            alerte.setContentText("Le déterminant de la matrice doit être différent de 0");
            alerte.showAndWait();
            return null;
        }
        erreurFormat();
        return null;
    }




    public Matrice multiParNombre(double multi){
        Matrice resultat = new Matrice(this.getWidth(),this.getHeight(),"resultat");
        for (int j=0;j<this.getWidth();j++){
            for (int i=0;i<this.getHeight();i++){
                resultat.getMatriceTab()[i][j]= (this.getMatriceTab()[i][j])*multi;
                resultat.getDescription().add(" Multiplication par un scalaire : "+ this.getMatriceTab()[i][j]+" * "+ multi);
            }
        }
        return resultat;
    }


    public Matrice transposition(){
        Matrice resultat = new Matrice(this.getWidth(),this.getHeight(),"resultat");
        if (this.verifierCarre()){
            for (int j=0;j<this.getWidth();j++){
                for (int i=0;i<this.getHeight();i++){
                    resultat.getMatriceTab()[i][j]= (this.getMatriceTab()[j][i]);
                    resultat.getDescription().add(" Transposition : "+(j+1)+","+(i+1)+" ==> "+(i+1)+","+(j+1));
                }
            }
            return resultat;
        }
        erreurFormat();
        return null;
    }


    public Matrice produitMatriciel(Matrice matrice1){
        Matrice resultat = new Matrice(matrice1.getWidth(),this.getHeight(),"resultat");
        if (this.verifierMultiplication(matrice1)){
            for (int i=0;i<resultat.getHeight();i++){
                for (int j=0;j<resultat.getWidth();j++){
                    for (int k=0;k<this.getWidth();k++){
                        resultat.getMatriceTab()[i][j] = resultat.getMatriceTab()[i][j]+(this.getMatriceTab()[i][k] * matrice1.getMatriceTab()[k][j]);
                        resultat.getDescription().add(" Produit Matriciel : "+this.getMatriceTab()[i][k] +"*"+ matrice1.getMatriceTab()[k][i]+" = "+resultat.getMatriceTab()[i][j]);
                    }
                }
            }
            return resultat;
        }
        erreurFormat();
        return null;
    }


    public Matrice puissance(int puissance){
        Matrice resultat = this;
        if (this.verifierCarre()){
            for (int i=0;i<puissance-1;i++){
                resultat = resultat.produitMatriciel(this);
            }
            return resultat;
        }
        erreurFormat();
        return null;
    }


    public Matrice produitVectoriel(Matrice matrice1){
        Matrice resultat = new Matrice(3,1,"resultat");
        if (this.getWidth()==3 && matrice1.getWidth()==3){
            resultat.getMatriceTab()[0][0] =
                    (this.getMatriceTab()[0][1]*matrice1.getMatriceTab()[0][2])
                            -(this.getMatriceTab()[0][2]*matrice1.getMatriceTab()[0][1]);
            resultat.getDescription().add((" Produit Vectoriel : "+
                    this.getMatriceTab()[0][1]+"*"+matrice1.getMatriceTab()[0][2])+
                    "-"+(this.getMatriceTab()[0][2]+"*"+matrice1.getMatriceTab()[0][1]));
            resultat.getMatriceTab()[0][1] =
                    (this.getMatriceTab()[0][2]*matrice1.getMatriceTab()[0][0])
                            -(this.getMatriceTab()[0][0]*matrice1.getMatriceTab()[0][2]);
            resultat.getDescription().add((" Produit Vectoriel : "+
                    this.getMatriceTab()[0][2]+"*"+matrice1.getMatriceTab()[0][0])+
                    "-"+(this.getMatriceTab()[0][0]+"*"+matrice1.getMatriceTab()[0][2]));
            resultat.getMatriceTab()[0][2] =
                    (this.getMatriceTab()[0][0]*matrice1.getMatriceTab()[0][1])
                            -(this.getMatriceTab()[0][1]*matrice1.getMatriceTab()[0][0]);
            resultat.getDescription().add((" Produit Vectoriel : "+
                    this.getMatriceTab()[0][0]+"*"+matrice1.getMatriceTab()[0][1])+
                    "-"+(this.getMatriceTab()[0][1]+"*"+matrice1.getMatriceTab()[0][0]));
            return resultat;
        }
        erreurFormat();
        return null;
    }


    public Matrice produitHadamard(Matrice matrice1){
        Matrice resultat = new Matrice(matrice1.getWidth(),this.getHeight(),"resultat");
        if (this.verifierAddition(matrice1)){
            for (int j=0;j<this.getWidth();j++){
                for (int i=0;i<this.getHeight();i++){
                    resultat.getMatriceTab()[i][j]= this.getMatriceTab()[i][j] * matrice1.getMatriceTab()[i][j];
                    resultat.getDescription().add(" Profuit d'Hadamard : "+
                            this.getMatriceTab()[i][j]+"*"+matrice1.getMatriceTab()[i][j]);
                    resultat.getDescription().add(" Produit d'Hadamard : "+
                            this.getMatriceTab()[i][j] +"*"+ matrice1.getMatriceTab()[i][j]);
                }
            }
            return resultat;
        }
        erreurFormat();
        return null;
    }


    public Matrice produitTensoriel(Matrice matrice){
        Matrice resultat = new Matrice(this.getWidth()*2,this.getHeight()*2,"resultat");
        try{
            for (int i1=0;i1<this.getHeight();i1++){
                for (int j1=0;j1<this.getWidth();j1++){
                    for (int i2=0;i2<matrice.getHeight();i2++){
                        for (int j2=0;j2<matrice.getWidth();j2++){
                            resultat.getMatriceTab()[i1*matrice.getHeight()+i2][j1*matrice.getWidth()+j2] = this.getMatriceTab()[i1][j1]*matrice.getMatriceTab()[i2][j2];
                            resultat.getDescription().add(" Produit Tensoriel : ("+(i1*matrice.getHeight()+i2+1)+","+(j1*matrice.getWidth()+j2+1)+") ==> "+
                                    this.getMatriceTab()[i1][j1]+"*"+matrice.getMatriceTab()[i2][j2]+" = "+resultat.getMatriceTab()[i1*matrice.getHeight()+i2][j1*matrice.getWidth()+j2]);
                        }
                    }
                }
            }
            return resultat;
        }catch (Exception e){
            erreurFormat();
         return null;
        }
    }


    public Matrice determinant(){
        Matrice resultat = new Matrice(1,1);
        if (this.verifierCarre()){
            resultat.getMatriceTab()[0][0] =this.nouveauDeterminant();
            for (int y=0;y<this.getDescription().size();y++){
                resultat.getDescription().add(this.getDescription().get(y));
            }
            this.getDescription().clear();
            return resultat;
        }
        erreurFormat();
        return null;
    }


    public double nouveauDeterminant() {
        Matrice temp = new Matrice(this.getWidth(), this.height, this.matriceTab, "resultat");
        if (verifierCarre()) {

            double det = 0;
            double[][][] tabMatrices = new double[temp.getWidth()][temp.getWidth() - 1][temp.getWidth() - 1];
            if (verifierCarre()) {
                if (temp.getWidth() == 1) {
                    det = temp.getMatriceTab()[0][0];
                    this.getDescription().add(" Déterminant : " + temp.getMatriceTab()[0][0]);
                    return det;
                } else if (temp.getWidth() == 2) {
                    det = temp.getMatriceTab()[0][0] * temp.getMatriceTab()[1][1] - (temp.getMatriceTab()[1][0] * temp.getMatriceTab()[0][1]);
                    this.getDescription().add(" Déterminant : " + temp.getMatriceTab()[0][0] + " * " + temp.getMatriceTab()[1][1] + " - (" +
                            (temp.getMatriceTab()[1][0] + " * " + temp.getMatriceTab()[0][1]) + ")");
                    return det;
                } else {


                    for (int i = 0; i < temp.getWidth(); i++) {
                        for (int j = 1; j < temp.getWidth(); j++) {
                            for (int k = 0; k < temp.getWidth() - 1; k++) {
                                if (i <= k) {
                                    tabMatrices[i][j - 1][k] = temp.getMatriceTab()[j][k + 1];
                                } else {
                                    tabMatrices[i][j - 1][k] = temp.getMatriceTab()[j][k];
                                }
                            }
                        }
                    }
                    for (int i = 0; i < temp.getWidth(); i++) {
                        Matrice intermediaire = new Matrice(temp.getWidth() - 1, temp.getHeight() - 1, tabMatrices[i], "intermediaire");
                        if (i % 2 == 1) {
                            double newDet = intermediaire.nouveauDeterminant();
                            det += temp.getMatriceTab()[0][i] * newDet * -1;
                            this.getDescription().add(" Determinant : (" + det + " + " + newDet + ") * -1");
                        } else {
                            double newDet = intermediaire.nouveauDeterminant();
                            det += temp.getMatriceTab()[0][i] * newDet;
                            this.getDescription().add(" Determinant : (" + det + " + " + newDet + ")");
                        }
                    }
                    return det;
                }
            }
            return det;
        }
            return 0;
        }
}
