package fr.diginamic.enumerations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaisonTest {

    // Le premier test, la vérification si la méthode fonctionne quand le paramètre est identique à celui de la classe
    @Test
    public void valueOfLibelleNominalTest() {

        // On utilise la technique 3A
        // 1. Arrange
        String printemps = "Printemps";
        String ete = "Été";
        String automne = "Automne";
        String hiver = "Hiver";

        // 2. Act
        Saison resultPrintemps = Saison.valueOfLibelle(printemps);
        Saison resultEte = Saison.valueOfLibelle(ete);
        Saison resultAutomne = Saison.valueOfLibelle(automne);
        Saison resultHiver = Saison.valueOfLibelle(hiver);

        // 3. Assert
        assertEquals(Saison.PRINTEMPS, resultPrintemps);
        assertEquals(Saison.ETE, resultEte);
        assertEquals(Saison.AUTOMNE, resultAutomne);
        assertEquals(Saison.HIVER, resultHiver);
    }

    // Le deuxième test, la vérification si la méthode donnera le résultat correct quelle que soit la casse des lettres
    @Test
    public void valueOfLibelleAccentsTest() {

        // Arrange
        String accentedEte = "ÉTÉ";
        String lowerCaseAccentedEte = "Été"; // With different case

        // Act
        Saison resultAccentedEte = Saison.valueOfLibelle(accentedEte);
        Saison resultLowerCaseAccentedEte = Saison.valueOfLibelle(lowerCaseAccentedEte);

        // Assert
        assertEquals(Saison.ETE, resultAccentedEte);
        assertEquals(Saison.ETE, resultLowerCaseAccentedEte);
    }

}