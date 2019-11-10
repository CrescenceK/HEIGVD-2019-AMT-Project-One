package ch.heigvd.amt.gestionCours.services;


import ch.heigvd.amt.gestionCours.model.Usr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsrDAOLocal extends IDAO<String, Usr>{

}
