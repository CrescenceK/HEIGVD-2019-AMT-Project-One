package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Usr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CourseDAOLocal extends IDAO<String, Course> {

    public List<Course> coursesFollowedByStudent(String username);
    public List<Course> coursesGivenByProf(String username);
    public List<Usr> usersTakingCourse(String course_name);
}
