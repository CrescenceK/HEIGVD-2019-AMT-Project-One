package ch.heigvd.amt.gestionCours.business;

import javax.ejb.Local;

@Local
public interface AuthenticationDAOLocal {

    public String hashPassword(String pswrd);
    public Boolean checkPassword(String pswrd, String hashedPswrd);

}
