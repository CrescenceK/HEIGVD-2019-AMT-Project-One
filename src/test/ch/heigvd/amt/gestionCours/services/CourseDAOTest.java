package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Course;
import org.arquillian.container.chameleon.deployment.api.DeploymentParameters;
import org.arquillian.container.chameleon.deployment.maven.MavenBuild;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import javax.ejb.EJB;
import java.sql.SQLException;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class CourseDAOTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(CourseDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    CourseDAOLocal courseDao;

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateACourse() throws DuplicateKeyException, SQLException {
        Course amt = Course.builder().course_name("amt" + System.currentTimeMillis()).credit_etcs(5).build();
        courseDao.create(amt);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAndRetrieveACourseViaTheCourseDAO() throws DuplicateKeyException, KeyNotFoundException {
        Course amt = Course.builder().course_name("amt" + System.currentTimeMillis()).credit_etcs(5).build();
        Course amtCreated = courseDao.create(amt);
        Course amtLoaded = courseDao.find(amtCreated.getCourse_name());
        assertEquals(amt, amtCreated);
        assertEquals(amt, amtLoaded);
        assertSame(amt, amtCreated);
        assertNotSame(amt, amtLoaded);
    }

    @Test
    public void itShouldBePossibleToDeleteACourse() throws DuplicateKeyException, KeyNotFoundException {
        Course amt = Course.builder().course_name("amt" + System.currentTimeMillis()).credit_etcs(5).build();
        Course amtCreated = courseDao.create(amt);
        Course amtLoaded = courseDao.find(amtCreated.getCourse_name());
        assertEquals(amt, amtCreated);
        courseDao.delete(amtCreated.getCourse_name());
        boolean hasThrown = false;
        try {
            amtLoaded  = courseDao.find(amtCreated.getCourse_name());
        } catch (KeyNotFoundException e) {
            hasThrown = true;
        }
        assertTrue(hasThrown);
    }

    @Test
    public void itShouldBePossibleToUpdateAUser() throws DuplicateKeyException, KeyNotFoundException {
        Course amt = Course.builder().course_name("amt" + System.currentTimeMillis()).credit_etcs(5).build();
        Course amtCreated = courseDao.create(amt);
        Course amtModified = amt.toBuilder().course_name("Application multi tiers").credit_etcs(5).build();
        courseDao.update(amtModified);
        Course amtModifiedInDB = courseDao.find(amt.getCourse_name());
        assertEquals(amtModified, amtModifiedInDB);
        assertNotEquals(amtCreated, amtModifiedInDB);
    }

    @Test
    public void coursesFollowedByStudent() {
    }

    @Test
    public void coursesGivenByProf() {
    }
}
