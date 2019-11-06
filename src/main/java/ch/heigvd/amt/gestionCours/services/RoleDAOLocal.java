package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Role;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RoleDAOLocal {

    public List<Role> findAllRole();
}
