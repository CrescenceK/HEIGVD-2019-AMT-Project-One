package ch.heigvd.amt.gestionCours.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class HavingCourses {

    private String student_username;
    private String having_course_name;
}
