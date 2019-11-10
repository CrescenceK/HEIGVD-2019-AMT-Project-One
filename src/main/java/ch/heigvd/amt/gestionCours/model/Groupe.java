package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder(toBuilder = true)
@Getter
@Setter
@EqualsAndHashCode
public class Groupe {

    private String groupe_name;
    private int student_per_group;


}
