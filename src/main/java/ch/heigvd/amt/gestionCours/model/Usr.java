package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Usr {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Role usr_role;

}
