package ch.heigvd.amt.gestionCours.model;

import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class CourseTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Course.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

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

