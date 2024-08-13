package fr.diginamic.enumerations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaisonTest {

    // 1ere option : libelle nominal
    @Test
    public void valueOfLibelleNominalTest() {

        assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("Printemps"));
        assertEquals(Saison.ETE, Saison.valueOfLibelle("Été"));
        assertEquals(Saison.AUTOMNE, Saison.valueOfLibelle("Automne"));
        assertEquals(Saison.HIVER, Saison.valueOfLibelle("Hiver"));
    }
}