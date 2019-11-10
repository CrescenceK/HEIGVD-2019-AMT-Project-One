package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Groupe;
import ch.heigvd.amt.gestionCours.model.Role;
import ch.heigvd.amt.gestionCours.model.Usr;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Util {

    public static  Usr convertResultsetToUser(ResultSet rs) throws SQLException {

        String username = rs.getString("username");
        String firstname = rs.getString("firstrname");
        String lastname = rs.getString("lastname");
        String password = rs.getString("password");
        int usr_role = rs.getInt("usr_role");

       Usr usr = Usr.builder().username(username).first_name(firstname).last_name(lastname)
                              .password(password).usr_role(usr_role).build();

       return usr;

    }

    public static Role convertResultsetToRole(ResultSet rs) throws SQLException{

        int role_id = rs.getInt("role_id");
         String role_name = rs.getString("role_name");

         Role role = Role.builder().role_name(role_name).role_id(role_id).build();
         return role;
    }

    public static Groupe convertResultsetToGroupe(ResultSet rs) throws SQLException {

        String group_name = rs.getString("group_name");
        int nbrStudentPerGroup = rs.getInt("nbrStudentPerGroup");

        Groupe groupe = Groupe.builder().groupe_name(group_name)
                        .student_per_group(nbrStudentPerGroup).build();
        return groupe;
    }


    public static Course convertResultsetToCourse(ResultSet rs) throws SQLException {

        String course_name = rs.getString("course_name");
        int credit_etcs = rs.getInt("credit_etcs");

        Course course = Course.builder().course_name(course_name).credit_etcs(credit_etcs).build();
        return course;
    }

}
