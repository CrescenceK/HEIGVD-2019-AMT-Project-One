package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class GivingCourses {

    private String prof_username;
    private String giving_course_name;

}
