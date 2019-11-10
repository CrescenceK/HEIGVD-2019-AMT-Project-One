package ch.heigvd.amt.gestionCours.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @BeforeEach
    void setUp() {
        System.out.println("RoleTest.BeforeEach.setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("RoleTest.BeforeEach.tearDown");
    }

    @Test
    public void itShouldBePossibleToBuildARole() {

        Role role = Role.builder().role_name("Testeur").role_id(4).build();
        assertEquals("Testeur", role.getRole_name());
        assertEquals(4, role.getRole_id());
    }


}