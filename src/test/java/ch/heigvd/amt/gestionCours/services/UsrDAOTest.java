package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Usr;
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
import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;

import javax.ejb.EJB;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
@MavenBuild
@DeploymentParameters(testable = true)
public class UsrDAOTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(UsrDAO.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    UsrDAOLocal usrDao;

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAUsr() throws DuplicateKeyException, SQLException {
        Usr mum = Usr.builder().username("mum" + System.currentTimeMillis()).first_name("nicole").last_name("kamdem")
                .password("123").usr_role(2).build();
        usrDao.create(mum);
    }

    @Test
    @Transactional(TransactionMode.COMMIT)
    public void itShouldBePossibleToCreateAndRetrieveAUsrViaTheUsrDAO() throws DuplicateKeyException, KeyNotFoundException{
        Usr mum = Usr.builder().username("mum" + System.currentTimeMillis()).first_name("nicole").last_name("kamdem").build();
        Usr mumCreated = usrDao.create(mum);
        Usr mumLoaded = usrDao.find(mumCreated.getUsername());
        assertEquals(mum, mumCreated);
        assertEquals(mum, mumLoaded);
        assertSame(mum, mumCreated);
        assertNotSame(mum, mumLoaded);
    }

    @Test
    public void itShouldBePossibleToDeleteAUsr() throws DuplicateKeyException, KeyNotFoundException{
        Usr mum = Usr.builder().username("mum" + System.currentTimeMillis()).first_name("nicole").last_name("kamdem").build();
        Usr mumCreated = usrDao.create(mum);
        Usr mumLoaded = usrDao.find(mumCreated.getUsername());
        assertEquals(mum, mumCreated);
        usrDao.delete(mumCreated.getUsername());
        boolean hasThrown = false;
        try {
            mumLoaded  = usrDao.find(mumCreated.getUsername());
        } catch (KeyNotFoundException e) {
            hasThrown = true;
        }
        assertTrue(hasThrown);
    }
}
