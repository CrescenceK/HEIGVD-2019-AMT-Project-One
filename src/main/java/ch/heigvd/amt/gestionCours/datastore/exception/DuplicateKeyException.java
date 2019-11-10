package ch.heigvd.amt.gestionCours.datastore.exception;

public class DuplicateKeyException extends Exception {

    public DuplicateKeyException(String message) {
        super(message);
    }
}
