package ch.heigvd.amt.gestionCours.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupeTest {

    @BeforeEach
    void setUp() {
        System.out.println("GroupeTest.BeforeEach.setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("GroupeTest.BeforeEach.tearDown");
    }

    @Test
    public void itShouldBePossibleToBuildAGroupe() {

        Groupe group = Groupe.builder().groupe_name("AMT_Projet1_Group1").student_per_group(2).build();
        assertEquals("AMT_Projet1_Group1", group.getGroupe_name());
        assertEquals(2, group.getStudent_per_group());
    }
}