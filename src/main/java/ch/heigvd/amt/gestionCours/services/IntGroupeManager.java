package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Groupe;

import java.util.List;

public interface IntGroupeManager {

    public Groupe createGroup(Groupe group);
    public Groupe updateGroup(Groupe group);
    public Groupe findGroup(Groupe group);
    public boolean deleteGroup(String group_name);
    public List<Groupe> findAll();


}
