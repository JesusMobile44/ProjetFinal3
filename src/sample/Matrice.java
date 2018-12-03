package sample;

public class Matrice {
    private int width;
    private int height;
    private double[][] matriceTab;

    public Matrice(int width, int height) {
        this.width = width;
        this.height = height;
        this.matriceTab = new double[height][width];
    }

    public Matrice(int width, int height, double[][] matriceTab) {
        this.width = width;
        this.height = height;
        this.matriceTab = matriceTab;
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
    public Matrice additionSoustraction(Matrice matrice1, boolean add){
        Matrice resultat = new Matrice(this.getWidth(),this.getHeight());
        if (verifierAddition(matrice1)){
            for (int j=0;j<resultat.getWidth();j++){
                for (int i=0;i<resultat.getHeight();i++){
                    if (add){
                        resultat.getMatriceTab()[i][j] = this.getMatriceTab()[i][j] + matrice1.getMatriceTab()[i][j];
                    }
                    else if (!add){
                        resultat.getMatriceTab()[i][j] = this.getMatriceTab()[i][j] - matrice1.getMatriceTab()[i][j];
                    }
                }
            }
            System.out.print(3);
            return resultat;
        }
        System.out.print(2);
        return null;
    }

    public Matrice inversion() {
        Matrice temp = new Matrice(this.getWidth(), this.getHeight(), this.getMatriceTab());
        double detDepart = temp.nouveauDeterminant();

        if (detDepart != 0) {

            temp = temp.transposition();
            double[][][][] tabMatrices = new double[temp.getHeight()][temp.getWidth()][temp.getWidth() - 1][temp.getWidth() - 1];

            for (int l = 0; l < temp.getHeight(); l++) {
                for (int i = 0; i < temp.getWidth(); i++) {
                    for (int j = 1; j < temp.getWidth(); j++) {
                        for (int k = 0; k < temp.getWidth() - 1; k++) {
                            if (i <= k) {
                                tabMatrices[l][i][j - 1][k] = temp.getMatriceTab()[j][k + 1];
                            } else {
                                tabMatrices[l][i][j - 1][k] = temp.getMatriceTab()[j][k];
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < temp.getWidth(); i++) {
                for (int j = 1; j < temp.getWidth(); j++) {
                    Matrice calculs = new Matrice(temp.getWidth() - 1, temp.getHeight() - 1, tabMatrices[i][j]);
                    if ((i + j) % 2 == 1)
                        temp.getMatriceTab()[i][j] = (calculs.nouveauDeterminant() * -1);
                    else
                        temp.getMatriceTab()[i][j] = (calculs.nouveauDeterminant());
                }
            }

            return temp.multiParNombre(1 / detDepart);
        }
        System.out.println("Inversion : det = 0");
        return null;
    }

    public Matrice multiParNombre(double multi){
        Matrice resultat = new Matrice(this.getWidth(),this.getHeight());
        for (int j=0;j<this.getWidth();j++){
            for (int i=0;i<this.getHeight();i++){
                resultat.getMatriceTab()[i][j]= (this.getMatriceTab()[i][j])*multi;
            }
        }
        return resultat;
    }
    public Matrice transposition(){
        Matrice resultat = new Matrice(this.getWidth(),this.getHeight());
        if (this.verifierCarre()){
            for (int j=0;j<this.getWidth();j++){
                for (int i=0;i<this.getHeight();i++){
                    resultat.getMatriceTab()[i][j]= (this.getMatriceTab()[j][i]);
                }
            }
            return resultat;
        }
        return null;
    }
    public Matrice produitMatriciel(Matrice matrice1){
        Matrice resultat = new Matrice(matrice1.getWidth(),this.getHeight());
        if (this.verifierMultiplication(matrice1)){
            for (int j=0;j<this.getWidth();j++){
                for (int i=0;i<this.getHeight();i++){
                    resultat.getMatriceTab()[i][j]= this.getMatriceTab()[i][j] * matrice1.getMatriceTab()[j][i];
                }
            }
            return resultat;
        }
        return null;
    }
    public Matrice puissance(int puissance){
        Matrice resultat = this;
        if (this.verifierCarre()){
            for (int i=0;i<puissance;i++){
                resultat.produitMatriciel(this);
            }
            return resultat;
        }
        return null;
    }
    public Matrice produitVectoriel(Matrice matrice1){
        Matrice resultat = new Matrice(3,1);
        if (this.getWidth()==3 && matrice1.getWidth()==3){
            resultat.getMatriceTab()[0][0] =
                    (this.getMatriceTab()[1][0]*matrice1.getMatriceTab()[2][0])
                            -(this.getMatriceTab()[2][0]*matrice1.getMatriceTab()[1][0]);
            resultat.getMatriceTab()[1][0] =
                    (this.getMatriceTab()[2][0]*matrice1.getMatriceTab()[0][0])
                            -(this.getMatriceTab()[0][0]*matrice1.getMatriceTab()[2][0]);
            resultat.getMatriceTab()[2][0] =
                    (this.getMatriceTab()[0][0]*matrice1.getMatriceTab()[1][0])
                            -(this.getMatriceTab()[1][0]*matrice1.getMatriceTab()[0][0]);
            return resultat;
        }
        return null;
    }
    public Matrice produitHadamard(Matrice matrice1){
        Matrice resultat = new Matrice(matrice1.getWidth(),this.getHeight());
        if (this.verifierAddition(matrice1)){
            for (int j=0;j<this.getWidth();j++){
                for (int i=0;i<this.getHeight();i++){
                    resultat.getMatriceTab()[i][j]= this.getMatriceTab()[i][j] * matrice1.getMatriceTab()[i][j];
                }
            }
            return resultat;
        }
        return null;
    }

    public Matrice produitTensoriel(Matrice matrice){
        return null;
    }

    /*
    public double determinant(){
        double det = 1;
        Matrice temp = new Matrice(this.getWidth(),this.height);
        for (int i=0;i< this.getWidth();i++){
            for (int j=0;j<this.getHeight();j++){
                temp.getMatriceTab()[i][j] = this.getMatriceTab()[i][j];
            }
        }
        if (verifierCarre()){
            if (temp.getWidth()==1){
                det = temp.getMatriceTab()[0][0];
                return det;
            }
            else if (temp.getWidth()==2){
                det = temp.getMatriceTab()[0][0] * temp.getMatriceTab()[1][1] - (temp.getMatriceTab()[1][0] * temp.getMatriceTab()[0][1]);
                return det;
            }
            else {
                double constante = 1;

                for (int i=1; i<temp.getHeight(); i++) {
                    int[] inconnues = new int[temp.getWidth()-i];

                    for (int j = 0; j < i; j++) {
                        try {
                            for (int k=0; k<temp.getWidth(); k++){
                                inconnues[k] = (temp.getMatriceTab()[i+k][j] / temp.getMatriceTab()[i - 1 +k][j]);
                            }

                        }
                        catch (Exception e){
                            inconnues[j]=0;
                        }

                        for (int k=0; k<temp.getWidth(); k++){
                            for (int l=temp.getWidth()+i; l<temp.getWidth(); l++)
                            temp.getMatriceTab()[i][k]=temp.getMatriceTab()[i][k]-(inconnues[k]*temp.getMatriceTab()[i-1][k]);
                        }
                    }
                }
                for (int i=0; i<temp.getWidth();i++)
                    constante=temp.getMatriceTab()[i][i]*constante;
                for (int i=0; i<temp.getWidth();i++){
                    System.out.println("---");
                    for (int j=0; j<temp.getWidth();j++)
                        System.out.println(temp.getMatriceTab()[i][j]);
                }


                return constante;
                }
            }
            return 2;
        }
        */


        public double nouveauDeterminant() {
            Matrice temp = new Matrice(this.getWidth(), this.height, this.matriceTab);
            double det = 0;
            double[][][] tabMatrices = new double[temp.getWidth()][temp.getWidth() - 1][temp.getWidth() - 1];
            if (verifierCarre()) {
                if (temp.getWidth() == 1) {
                    det = temp.getMatriceTab()[0][0];
                    return det;
                } else if (temp.getWidth() == 2) {
                    det = temp.getMatriceTab()[0][0] * temp.getMatriceTab()[1][1] - (temp.getMatriceTab()[1][0] * temp.getMatriceTab()[0][1]);
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
                        Matrice intermediaire = new Matrice(temp.getWidth() - 1, temp.getHeight() - 1, tabMatrices[i]);
                        if (i % 2 == 1)
                            det += temp.getMatriceTab()[0][i] * intermediaire.nouveauDeterminant() * -1;
                        else
                            det += temp.getMatriceTab()[0][i] * intermediaire.nouveauDeterminant();
                    }
                    System.out.println(det + "determinant");
                    return det;
                }
            }
            return det;
        }
}
