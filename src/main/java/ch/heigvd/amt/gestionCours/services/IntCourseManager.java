package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;

public interface IntCourseManager {

    public Course createCourse(String course_name, int creditETCS);
    public Course updateCourse(String course_name);
    public Course findCourse(String course_name);
    public boolean deleteCourse(String course_name);
}
