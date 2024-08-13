package fr.diginamic.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    // Test des cas nominaux (cas standards)
    @Test
    public void levenshteinDistanceTestNominaux() {

        // 1. Arrange
        String chat = "chat";
        String chats = "chats";
        String machins = "machins";
        String machine = "machine";
        String aviron = "aviron";
        String avion = "avion";
        String distance = "distance";
        String instance = "instance";
        String filip = "filip";
        String fiji = "fiji";

        // 2. Act
        int result1 = StringUtils.levenshteinDistance(chat, chats);
        int result2 = StringUtils.levenshteinDistance(machins, machine);
        int result3 = StringUtils.levenshteinDistance(aviron, avion);
        int result4 = StringUtils.levenshteinDistance(instance, distance);
        int result5 = StringUtils.levenshteinDistance(filip, fiji);

        // 3. Assert
        assertEquals(1, result1);
        assertEquals(1, result2);
        assertEquals(1, result3);
        assertEquals(2, result4);
        assertEquals(2, result5);

    }

    //  Test avec une chaîne vide
    @Test
    public void levenshteinDistanceTestVide() {

        // 1. Arrange
        String strVide = "";
        String strChats = "Chats";

        // 2. Act
        int result = StringUtils.levenshteinDistance(strVide, strChats); // empty and normal

        // 3. Assert
        assertEquals(5, result);
    }

    // Test avec des valeurs nulles
    @Test (expected = IllegalArgumentException.class)
    public void levenshteinDistanceTestNull() {

        // 1. Arrange
        String strNull = null;
        String strVide = "";
        String mot = "chat";

        // 2. Act
        int result1 = StringUtils.levenshteinDistance(strNull, mot);
        int result2 = StringUtils.levenshteinDistance(strNull, strVide);

        // 3. Assert
        assertThrows(IllegalArgumentException.class, () -> StringUtils.levenshteinDistance(strNull, mot));
        assertThrows(IllegalArgumentException.class, () -> StringUtils.levenshteinDistance(strNull, strVide));

    }
}
