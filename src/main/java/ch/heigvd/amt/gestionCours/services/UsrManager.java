package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Usr;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;

@Stateless
public class UsrManager implements IntUsrManager {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;

    @Override
    public Usr createUsr(Usr usr) {
         String REQ_ADD = "INSERT INTO Usr (username, first_name, last_name, pswrd, usr_role)" + "VALUES(?, ?, ?, ?, ?)";

         try {
             Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(REQ_ADD);

             pstmt.setString(1, usr.getUsername());
             pstmt.setString(2, usr.getFirstName());
             pstmt.setString(3, usr.getLastName());
             pstmt.setString(4, usr.getPassword());
             pstmt.setInt(5,usr.getUsr_role());

             pstmt.executeUpdate();
             conn.close();

         } catch (SQLException e){
             e.printStackTrace();
         }
         return usr;
    }

    @Override
    public Usr updateUsr(Usr usr) {

        Usr usrToUpdate = findUsr(usr);
        if(!usrToUpdate.getUsername().equals(usr.getUsername())){
            usrToUpdate.setUsername(usr.getUsername());
        }

        if(!usrToUpdate.getFirstName().equals(usr.getFirstName())){
            usrToUpdate.setFirstName(usr.getFirstName());
        }

        if(!usrToUpdate.getLastName().equals(usr.getLastName())){
            usrToUpdate.setLastName(usr.getLastName());
        }

        if(!usrToUpdate.getPassword().equals(usr.getPassword())){
            usrToUpdate.setLastName(usr.getLastName());
        }

        usrToUpdate.setPassword(usr.getPassword()); // servlet special pour changer son mdp
        usrToUpdate.setUsr_role(usr.getUsr_role()); // un usr ne peut pas chabger son role

        createUsr(usrToUpdate);

        return usrToUpdate;
    }

    @Override
    public Usr findUsr(Usr usr) {

        String REQ_FIND = "SELECT * FROM Usr WHERE username = ?";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FIND);

            pstmt.setString(1, usr.getUsername());
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                usr = Util.convertResultsetToUser(result);
            }
        }  catch (SQLException e){
        e.printStackTrace();
    }
        return usr;
    }

    @Override
    public boolean deleteUsr(String username) {

        String REQ_DEL = "DELETE FROM Usr WHERE username= ?";
        boolean deleteSucceed = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_DEL);

            pstmt.setString(1, username);
            int result = pstmt.executeUpdate();
            deleteSucceed = result==1;

        }  catch (SQLException e){
            e.printStackTrace();
        }
        return deleteSucceed;

    }
}
