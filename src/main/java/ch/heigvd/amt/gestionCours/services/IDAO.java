package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import java.util.List;

public interface IDAO<PK, E> {

    E create(E entity) throws DuplicateKeyException;
    E find(PK id) throws KeyNotFoundException;
    List<E> findAll();
    void update(E entity) throws KeyNotFoundException;
    boolean delete(PK id) throws KeyNotFoundException;

}
