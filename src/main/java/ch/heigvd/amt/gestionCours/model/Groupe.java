package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

//@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Groupe {
    private String group_name;
    private int nbrStudentPerGroup;

    public Groupe(String group_name, int nbrStudentPerGroup) {
        this.group_name = group_name;
        this.nbrStudentPerGroup = nbrStudentPerGroup;
    }
}
