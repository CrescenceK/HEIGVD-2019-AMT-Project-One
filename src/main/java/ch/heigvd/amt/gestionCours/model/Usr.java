package ch.heigvd.amt.gestionCours.model;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
//@EqualsAndHashCode
//@NoArgsConstructor
public class Usr {

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private int usr_role;

}

