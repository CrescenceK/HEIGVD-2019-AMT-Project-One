package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Usr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CourseDAOLocal {

    public Course createCourse(Course course);
    public Course updateCourse(Course course);
    public Course findCourse(Course course);
    public boolean deleteCourse(String course_name);
    public List<Course> findAll();
    public List<Course> coursesFollowedByStudent(Usr usr);
    public List<Course> coursesGivenByProf(Usr usr);
}
