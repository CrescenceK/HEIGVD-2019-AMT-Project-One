package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.business.AuthenticationDAOLocal;
import ch.heigvd.amt.gestionCours.model.Usr;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UsrDAO implements UsrDAOLocal  {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;

    @EJB
    AuthenticationDAOLocal authenticationDao;

    @Override
    public Usr create(Usr entity) throws DuplicateKeyException {

        String REQ_ADD = "INSERT INTO Usr (username, first_name, last_name, pswrd, usr_role)" + "VALUES(?, ?, ?, ?, ?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_ADD);
            pstmt.setString(1, entity.getUsername());
            pstmt.setString(2, entity.getFirst_name());
            pstmt.setString(3, entity.getLast_name());
            pstmt.setString(4, authenticationDao.hashPassword(entity.getPassword()));
            pstmt.setInt(5, entity.getUsr_role());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Usr find(String username) throws KeyNotFoundException {
        String REQ_FIND = "SELECT * FROM Usr WHERE username=" + "'" + username + "'"+ ";";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FIND);
            ResultSet result = pstmt.executeQuery();
            boolean hasRecord = result.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find user with username = " + username);
            }
            conn.close();
            Usr usr = Util.convertResultsetToUser(result);
            return usr;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    @Override
    public List<Usr> findAll() {
        String REQ_FINDALL = "SELECT * FROM Usr";
        List<Usr> allUsers = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FINDALL);
            pstmt.execute();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                allUsers.add(Util.convertResultsetToUser(rs));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public void update(Usr entity) throws KeyNotFoundException {

        String REQ_UPDATE = "UPDATE Usr SET first_name =?, last_name=? WHERE username =?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_UPDATE);
            pstmt.setString(1, entity.getUsername());
            pstmt.setString(2, entity.getFirst_name());
            pstmt.setString(3, entity.getLast_name());
            conn.close();
            int numberOfUpdatedUsers = pstmt.executeUpdate();
            if (numberOfUpdatedUsers != 1) {
                throw new KeyNotFoundException("Could not find user with username = " + entity.getUsername());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    @Override
    public boolean delete(String username) throws KeyNotFoundException {
        String REQ_DEL = "DELETE FROM Usr WHERE username= ?";
        boolean deleteSucceed = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_DEL);

            pstmt.setString(1, username);
            int result = pstmt.executeUpdate();
            deleteSucceed = result == 1;
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deleteSucceed;
    }
}
