package ch.heigvd.amt.gestionCours.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Role {

    private int role_id;
    private String role_name;
}
