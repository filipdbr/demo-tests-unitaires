package fr.diginamic.immobilier.entites;

import org.junit.Test;

import static org.junit.Assert.*;

/* todo 1. check superficie type piece.
   I can add 2 pieces on two levels and see if the sum is correct
 */

public class MaisonTest {


    /**
     * Test de la méthode ajouterPiece.
     * Vérifie que les pièces sont ajoutées correctement à la maison,
     * et que les pièces avec une superficie de 0 ou un objet null ne sont pas ajoutées.
     */
    @Test
    public void ajouterPiece() {

        // 1. arrange
        Maison maison = new Maison();
        Piece salon = new Salon(1, 35.0);
        Piece sdb = new SalleDeBain(1,10.0);
        Piece wc = new WC(0, 0); // Pièce avec une superficie de 0, ne devrait pas être ajoutée

        // 2. act
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(salon);
        maison.ajouterPiece(null); //  Tentative d'ajouter une pièce null, ne devrait rien faire
        maison.ajouterPiece(wc); // Tentative d'ajouter une pièce avec superficie 0, ne devrait rien faire

        // 3. assert
        assertEquals(2, maison.nbPieces()); // // Seulement sdb et salon doivent être ajoutées
        assertEquals(45, maison.calculerSurface(), 0.01); // // La superficie totale doit être 45 m² (35 + 10)

    }

    /**
     * Test de la méthode nbPieces.
     * Vérifie que le nombre de pièces dans la maison est correct après plusieurs ajouts,
     * y compris des tentatives d'ajouts de pièces avec une superficie non valide.
     */
    @Test
    public void nbPieces() {

        // 1. arrange (null est impossible, ca cause l'erreur d'execution)
        Maison maison = new Maison();
        Piece salon = new Salon(1, 35.0);
        Piece sdb = new SalleDeBain(1,10.0);
        Piece wc = new WC(0,5.5);
        Piece chambre = new Chambre(0,25);
        Piece cuisine = new Cuisine(0,10);
        Piece cuisine2 = new Cuisine(1,15);
        Piece wc2 = new WC(1, 0); // Pièce avec superficie de 0, ne devrait pas être ajoutée
        Piece wc3 = new WC(1, -1); // Pièce avec superficie négative, ne devrait pas être ajoutée

        // 2. act
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        maison.ajouterPiece(chambre);
        maison.ajouterPiece(cuisine);
        maison.ajouterPiece(cuisine2);
        maison.ajouterPiece(wc2); // Devrait être ignorée
        maison.ajouterPiece(wc3); // Devrait être ignorée

        // 3. assert
        assertEquals(6, maison.nbPieces()); // Six pièces valides doivent avoir été ajoutées

    }

    /**
     * Test de la méthode superficieTypePiece.
     * Vérifie que la superficie totale est correctement calculée pour un type de pièce donné,
     * avec une gestion correcte de la casse (majuscule/minuscule).
     */
    @Test
    public void superficieTypePiece() {

        // 1. arrange
        Maison maison = new Maison();
        Piece wc = new WC(0,5.5);
        Piece wc2 = new WC(0,0); // Pièce avec superficie de 0, ne doit pas être ajoutée
        Piece salon = new Salon(1,20);
        Piece salon2 = new Salon(2, 30);

        // 2. act
        maison.ajouterPiece(wc);
        maison.ajouterPiece(wc2); // Ne devrait pas être ajoutée
        maison.ajouterPiece(salon);
        maison.ajouterPiece(salon2);

        // 3. assert
        assertEquals(5.5, maison.superficieTypePiece("WC"), 0.01);
        assertEquals(5.5, maison.superficieTypePiece("wc"), 0.01); // Test de la casse
        assertEquals(50, maison.superficieTypePiece("salon"), 0.01); // La superficie totale des salons doit être 50 m²
        assertEquals(50, maison.superficieTypePiece("Salon"), 0.01); // Test de la casse
        assertEquals(50, maison.superficieTypePiece("SALON"), 0.01); // Test de la casse

    }

    /**
     * Test de la méthode calculerSurface.
     * Vérifie que la superficie totale de la maison est correctement calculée
     * en excluant les pièces avec une superficie non valide.
     */
    @Test
    public void calculerSurface() {

        // 1. arrange (null est impossible, ca cause l'erreur d'execution)
        Maison maison = new Maison();
        Piece salon = new Salon(1, 10.0);
        Piece sdb = new SalleDeBain(1,10.0);
        Piece wc = new WC(0,20);
        Piece chambre = new Chambre(0,20);
        Piece cuisine = new Cuisine(0,10);
        Piece cuisine2 = new Cuisine(1,10);
        Piece wc2 = new WC(1, 0); // Pièce avec superficie de 0, ne devrait pas être ajoutée
        Piece wc3 = new WC(1, -1); // Pièce avec superficie négative, ne devrait pas être ajoutée

        // 2. act
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        maison.ajouterPiece(chambre);
        maison.ajouterPiece(cuisine);
        maison.ajouterPiece(cuisine2);
        maison.ajouterPiece(wc2); // Ne devrait pas être ajoutée
        maison.ajouterPiece(wc3); // Ne devrait pas être ajoutée

        // 3. assert
        assertEquals(80, maison.calculerSurface(), 0.01);  // La superficie totale doit être 80 m²

    }

    /**
     * Test de la méthode superficieEtage.
     * Vérifie que la superficie totale est correctement calculée pour un étage donné.
     */
    @Test
    public void superficieEtage() {

        // 1. arrange
        Maison maison = new Maison();
        Piece salon = new Salon(1, 35.0);
        Piece sdb = new SalleDeBain(1,10.0);
        Piece wc = new WC(0,5.5);
        Piece chambre = new Chambre(0,25);
        Piece cuisine = new Cuisine(0,10);
        Piece cuisine2 = new Cuisine(1,15); // Pièce avec superficie de 0, ne devrait pas être ajoutée

        // 2. act
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(salon);
        maison.ajouterPiece(wc);
        maison.ajouterPiece(chambre);
        maison.ajouterPiece(cuisine);
        maison.ajouterPiece(cuisine2);

        // 3. assert
        assertEquals(40.5, maison.superficieEtage(0), 0.01); // Superficie totale du rez-de-chaussée doit être 40.5 m²
        assertEquals(60.0, maison.superficieEtage(1), 0.01); // Superficie totale du premier étage doit être 60 m²
    }
}