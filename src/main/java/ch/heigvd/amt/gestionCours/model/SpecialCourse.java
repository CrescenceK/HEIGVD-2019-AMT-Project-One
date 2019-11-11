package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class SpecialCourse {
    private Course course;
    private Usr prof;
    private int nb_std;
}
