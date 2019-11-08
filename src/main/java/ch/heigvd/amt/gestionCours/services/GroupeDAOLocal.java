package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Groupe;

import javax.ejb.Local;
import java.util.List;

@Local
public interface GroupeDAOLocal {

    public Groupe createGroup(Groupe group);
    public Groupe updateGroup(Groupe group);
    public Groupe findGroup(Groupe group);
    public boolean deleteGroup(String group_name);
    public List<Groupe> findAll();


}
