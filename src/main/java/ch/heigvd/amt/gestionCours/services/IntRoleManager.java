package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Role;

import javax.ejb.EJB;
import java.util.List;



public interface IntRoleManager {

    public List<Role> findAllRole();
}
