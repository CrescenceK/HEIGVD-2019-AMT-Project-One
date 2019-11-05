package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
@EqualsAndHashCode
public class Usr {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int usr_role;

    public Usr(String firstName, String lastName, String username, String password, int usr_role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.usr_role = usr_role;
    }
}

