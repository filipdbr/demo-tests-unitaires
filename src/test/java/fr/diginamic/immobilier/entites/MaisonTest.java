package fr.diginamic.immobilier.entites;

import org.junit.Test;

import static org.junit.Assert.*;

/* todo 1. check superficie type piece.
   I can add 2 pieces on two levels and see if the sum is correct 
 */

public class MaisonTest {

    @Test
    public void ajouterPiece() {

        // 1. arrange
        Maison maison = new Maison();
        Piece salon = new Salon(1, 35.0);
        Piece sdb = new SalleDeBain(1,10.0);

        // 2. act
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(salon);

        // 3. assert
        assertEquals(2, maison.nbPieces());
        assertEquals(45, maison.calculerSurface(), 0.01);

    }

    @Test
    public void nbPieces() {

        // 1. arrange
        Maison maison = new Maison();
        Piece salon = new Salon(1, 35.0);
        Piece sdb = new SalleDeBain(1,10.0);
        Piece wc = new WC(0,5.5);
        Piece chambre = new Chambre(0,25);
        Piece cuisine = new Cuisine(0,10);

        // 2. act
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        maison.ajouterPiece(chambre);
        maison.ajouterPiece(cuisine);

        // 3. assert
        assertEquals(5, maison.nbPieces());
        assertEquals(40.5, maison.superficieEtage(0), 0.01);
        assertEquals(45.0, maison.superficieEtage(1), 0.01);

    }

    @Test
    public void superficieEtage() {
    }

    @Test
    public void superficieTypePiece() {
    }

    @Test
    public void calculerSurface() {
    }
}