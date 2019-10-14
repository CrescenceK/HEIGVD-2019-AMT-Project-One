package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class Professor {
    private String firstName;
    private String lastName;
    private String username;
    private List<Course> givingCourses;
}
