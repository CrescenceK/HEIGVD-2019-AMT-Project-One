package ch.heigvd.amt.gestionCours.services;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class CourseDAOTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(CourseDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void createCourse() {
    }

    @Test
    public void updateCourse() {
    }

    @Test
    public void findCourse() {
    }

    @Test
    public void deleteCourse() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void coursesFollowedByStudent() {
    }

    @Test
    public void coursesGivenByProf() {
    }
}
