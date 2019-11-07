package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Groupe;
import ch.heigvd.amt.gestionCours.model.Role;
import ch.heigvd.amt.gestionCours.model.Usr;
import lombok.Builder;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Util {

    public static  Usr convertResultsetToUser(ResultSet rs) throws SQLException {

        String username = rs.getString("username");
        String firstname = rs.getString("firstrname");
        String lastname = rs.getString("lastname");
        String password = rs.getString("password");
        int usr_role = rs.getInt("usr_role");

        return new Usr(username, firstname, lastname, password, usr_role);
    }

    public static Role convertResultsetToRole(ResultSet rs) throws SQLException{

        int role_id = rs.getInt("role_id");
         String role_name = rs.getString("role_name");

         return new Role(role_id, role_name);
    }

    public static Groupe convertResultsetToGroupe(ResultSet rs) throws SQLException {

        String group_name = rs.getString("group_name");
        int nbrStudentPerGroup = rs.getInt("nbrStudentPerGroup");

        return new Groupe(group_name, nbrStudentPerGroup);
    }


    public static Course convertResultsetToCourse(ResultSet rs) throws SQLException {

        String course_name = rs.getString("course_name").toString();
        int credit_etcs = rs.getInt("credit_etcs");

        return new Course(course_name, credit_etcs);
    }

}
