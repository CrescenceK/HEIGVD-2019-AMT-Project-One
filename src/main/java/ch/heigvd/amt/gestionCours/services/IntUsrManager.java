package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Role;
import ch.heigvd.amt.gestionCours.model.Usr;

import java.sql.SQLException;

public interface IntUsrManager {

    public Usr createUsr(Usr usr);
    public Usr updateUsr(Usr usr);
    public Usr findUsr(Usr usr);
    public boolean deleteUsr(String username);
}
