package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Groupe;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class GroupeDAO implements GroupeDAOLocal {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;


    @Override
    public Groupe create(Groupe entity) throws DuplicateKeyException {

        String REQ_ADD = "INSERT INTO Course (groupe_name, student_per_roup)" + "VALUES(?, ?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_ADD);
            pstmt.setString(1, entity.getGroupe_name());
            pstmt.setInt(2, entity.getStudent_per_group());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Groupe find(String groupe_name) throws KeyNotFoundException {

        String REQ_FIND = "SELECT * FROM Usr WHERE groupe_name =" + "'" + groupe_name + "'"+ ";";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FIND);

            ResultSet result = pstmt.executeQuery();
            boolean hasRecord = result.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find group with groupe_name = " + groupe_name);
            }
            conn.close();
            Groupe groupe = Util.convertResultsetToGroupe(result);
            return groupe;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }

    @Override
    public List<Groupe> findAll() {

        String REQ_FINDALL = "SELECT * FROM Groupe";
        List<Groupe> allGroups = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FINDALL);
            pstmt.execute();
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                allGroups.add(Util.convertResultsetToGroupe(result));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGroups;
    }

    @Override
    public void update(Groupe entity) throws KeyNotFoundException {

        String REQ_UPDATE = "UPDATE Course SET groupe_name=?, student_per_group=?";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_UPDATE);
            pstmt.setString(1, entity.getGroupe_name());
            pstmt.setInt(2, entity.getStudent_per_group());
            int numberOfUpdatedGroups = pstmt.executeUpdate();
            conn.close();
            if (numberOfUpdatedGroups != 1) {
                throw new KeyNotFoundException("Could not find Course with groupe_name = " + entity.getGroupe_name());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public boolean delete(String group_name) throws KeyNotFoundException {
        String REQ_DEL = "DELETE FROM Course WHERE group_name = ?";
        boolean deleteGroupSucceed = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_DEL);
            pstmt.setString(1, group_name);
            int result = pstmt.executeUpdate();
            deleteGroupSucceed = result==1;
            conn.close();
        }  catch (SQLException e){
            e.printStackTrace();
        }
        return deleteGroupSucceed;
    }
}
