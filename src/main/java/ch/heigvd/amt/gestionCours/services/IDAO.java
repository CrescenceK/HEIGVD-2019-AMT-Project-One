package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import java.util.List;

/**
 * @interface générique pour l'implementation des CRUDs de nos entités
 * @param <PK> clé primaire de l'entité
 * @param <E>  entité(model)
 */
public interface IDAO<PK, E> {

    /**
     *
     * @param entity : représente un model.
     * @return : retourne le model crée.
     * @throws DuplicateKeyException
     */
    E create(E entity) throws DuplicateKeyException;

    /**
     *
     * @param id clé primaire d'un tuple du model
     * @return : retourne l'entité ayant pour identifiant unique id.
     * @throws KeyNotFoundException
     */
    E find(PK id) throws KeyNotFoundException;

    /**
     *
     * @return tout les tuples d'une table
     */
    List<E> findAll();

    /**
     *
     * @param entity : représente un model.
     * @throws KeyNotFoundException
     */
    void update(E entity) throws KeyNotFoundException;

    /**
     *
     * @param id : clé primaire d'un tuple du model
     * @return un booléen renseignant si la suppresion a été faite ou pas.
     * @throws KeyNotFoundException
     */
    boolean delete(PK id) throws KeyNotFoundException;

}