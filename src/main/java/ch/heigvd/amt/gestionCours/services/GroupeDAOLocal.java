package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Groupe;
import javax.ejb.Local;


@Local
public interface GroupeDAOLocal extends IDAO<String, Groupe> {

}
