package ch.heigvd.amt.gestionCours.business;

import javax.ejb.Stateless;
import org.mindrot.jbcrypt.BCrypt;

@Stateless
public class AuthenticationDAO implements AuthenticationDAOLocal {

    @Override
    public String hashPassword(String pswrd) {
        return BCrypt.hashpw(pswrd, BCrypt.gensalt());
    }

    @Override
    public Boolean checkPassword(String pswrd, String hashedPswrd) {
        try {
            boolean correct = BCrypt.checkpw(pswrd, hashedPswrd);
            return correct;
        } catch (Exception e) {
            return false;
        }
    }
}
