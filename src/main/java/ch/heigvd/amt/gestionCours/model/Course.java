package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
@EqualsAndHashCode
public class Course {
    private  String course_name;
    private int credit_etcs;

    public Course(String course_name, int credit_etcs) {
        this.course_name = course_name;
        this.credit_etcs = credit_etcs;
    }
}
