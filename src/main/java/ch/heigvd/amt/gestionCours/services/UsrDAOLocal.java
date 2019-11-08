package ch.heigvd.amt.gestionCours.services;


import ch.heigvd.amt.gestionCours.model.Usr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsrDAOLocal {

    public Usr createUsr(Usr usr);
    public Usr updateUsr(Usr usr);
    public Usr findUsr(Usr usr);
    public boolean deleteUsr(String username);
    public List<Usr> findAll();
}
