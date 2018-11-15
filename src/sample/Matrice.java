package sample;

public class Matrice {
    int width;
    int height;
    int[][] matriceTab;

    public Matrice(int width, int height) {
        this.width = width;
        this.height = height;
        this.matriceTab = new int[height][width];
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

    public int[][] getMatriceTab() {
        return matriceTab;
    }

    public void setMatriceTab(int[][] matriceTab) {
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
            return resultat;
        }
        return null;
    }
    public Matrice multiParNombre(int multi){
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
    /*
    public int determinant(){ /////////////pas fini
        int resultat = 0;
        if (this.verifierCarre()){
            for (int i=0;i<this.getWidth();i++){
                for (int j=0;j<this.getHeight();j++){
                    Matrice temp = new Matrice(i-1,j-1);

                }
            }
        }
    }*/
}
