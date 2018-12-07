package sample;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatriceTest {
    ArrayList<Matrice> matrices = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        matrices = Controller.importerMatrice(true);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void additionSoustraction() {
        //Addition
        double[][] results = {
            {2, 12.9},
            {4,0}};

        Matrice test = matrices.get(0).additionSoustraction(matrices.get(1), true);

        for (int i =0; i<test.getHeight(); i++)
            for (int j=0; j<test.getWidth(); j++)
                assertEquals(results[i][j], test.getMatriceTab()[i][j]);

        //Soustraction
        double[][] results2 = {{0, 0.5},
                {-4, 0}};

        Matrice test2 = matrices.get(0).additionSoustraction(matrices.get(1), false);

        for (int i =0; i<test.getHeight(); i++)
            for (int j=0; j<test.getWidth(); j++)
                assertEquals(results2[i][j], test2.getMatriceTab()[i][j]);
    }

    @org.junit.jupiter.api.Test
    void inversion() {
    }

    @org.junit.jupiter.api.Test
    void multiParNombre() {
        double[][] results= {{2,0},
            {31, -2}};

        Matrice test = matrices.get(2).multiParNombre(2);

        for (int i =0; i<test.getHeight(); i++)
            for (int j=0; j<test.getWidth(); j++)
                assertEquals(results[i][j], test.getMatriceTab()[i][j]);
    }

    @org.junit.jupiter.api.Test
    void transposition() {
        double[][] results= {
                {5,-6,-2},
                {5,8,1},
                {0,9,3}};

        Matrice test = matrices.get(3).transposition();

        for (int i =0; i<test.getHeight(); i++)
            for (int j=0; j<test.getWidth(); j++)
                assertEquals(results[i][j], test.getMatriceTab()[i][j]);
    }

    @org.junit.jupiter.api.Test
    void produitMatriciel() {

    }

    @org.junit.jupiter.api.Test
    void puissance() {
    }

    @org.junit.jupiter.api.Test
    void produitVectoriel() {
    }

    @org.junit.jupiter.api.Test
    void produitHadamard() {
    }

    @org.junit.jupiter.api.Test
    void produitTensoriel() {
    }

    @org.junit.jupiter.api.Test
    void nouveauDeterminant() {
    }
}