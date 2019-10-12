package ch.heigvd.amt.gestionCours.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class Group {
    private String name;
    private List<Course> courses;
}
