package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Usr {

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private int usr_role;

}

