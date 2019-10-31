package ch.heigvd.amt.gestionCours.services;

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

        return new Usr(username, firstname, lastname, password, usr_role);

    }
}
