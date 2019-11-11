package ch.heigvd.amt.gestionCours.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @BeforeEach
    void setUp() {
        System.out.println("CourseTest.BeforeEach.setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("CourseTest.BeforeEach.tearDown");
    }

    @Test
    public void itShouldBePossibleToBuildACourse() {

        Course course = Course.builder()
                .course_name("appli multi tiers")
                .credit_etcs(4)
                .build();
        assertEquals("appli multi tiers", course.getCourse_name());
        assertEquals(4, course.getCredit_etcs());
    }

}