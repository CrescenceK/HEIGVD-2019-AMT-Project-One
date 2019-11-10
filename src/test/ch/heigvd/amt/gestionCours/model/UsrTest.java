package ch.heigvd.amt.gestionCours.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsrTest {

    @BeforeEach
    void setUp() {
        System.out.println("UsrTest.BeforeEach.setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("UsrTest.BeforeEach.tearDown");
    }

    @Test
    public void itShouldBePossibleToBuildAUsr() {

        Usr crescy = Usr.builder()
                .username("crescyk")
                .first_name("kamdem")
                .last_name("crescence")
                .password("pswrd")
                .usr_role(2)
                .build();
        assertEquals("crescyk", crescy.getUsername());
        assertEquals("kamdem", crescy.getFirst_name());
        assertEquals("crescence", crescy.getLast_name());
        assertEquals("pswrd", crescy.getPassword());
        assertEquals(2, crescy.getUsr_role());
    }


}