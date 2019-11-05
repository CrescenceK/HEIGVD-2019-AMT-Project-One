package ch.heigvd.amt.gestionCours.services;

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
public class GroupeManager implements IntGroupeManager {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;

    @Override
    public Groupe createGroup(Groupe group) {

        String REQ_ADD = "INSERT INTO Course (group_name, nbrStudentPerGroup)" + "VALUES(?, ?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_ADD);
            pstmt.setString(1, group.getGroup_name());
            pstmt.setInt(2, group.getNbrStudentPerGroup());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public Groupe updateGroup(Groupe group) {

        Groupe groupToUpdate = findGroup(group);

        if(groupToUpdate.getNbrStudentPerGroup() != group.getNbrStudentPerGroup()){
            groupToUpdate.setNbrStudentPerGroup(group.getNbrStudentPerGroup());
        }

        groupToUpdate.setGroup_name(group.getGroup_name()); // servlet spécial pour changer le nom d'un groupe car clé primaire
        createGroup(groupToUpdate);

        return groupToUpdate;
    }

    @Override
    public Groupe findGroup(Groupe group) {

        String REQ_FIND = "SELECT * FROM Usr WHERE group_name = ?";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FIND);

            pstmt.setString(1, group.getGroup_name());
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                group = Util.convertResultsetToGroupe(result);
            }
            conn.close();

        }  catch (SQLException e){
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public boolean deleteGroup(String group_name) {

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
}
