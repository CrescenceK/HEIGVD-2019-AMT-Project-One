package ch.heigvd.amt.gestionCours.services;


import ch.heigvd.amt.gestionCours.model.Role;

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
public class RoleManager implements IntRoleManager {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;

    @Override
    public List<Role> findAllRole() {

        String REQ_FINDALL = "SELECT * FROM Role";
        List<Role> allRole = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FINDALL);
            pstmt.execute();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                allRole.add(Util.convertResultsetToRole(rs));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allRole;
    }
}
