package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Groupe;

public interface IntGroupeManager {

    public Groupe createGroup(String group_name, int nbrStudentPerGroup);
    public Groupe updateGroup(String group_name);
    public Groupe findGroup(String group_name);
    public boolean deleteGroup(String group_name);

}
