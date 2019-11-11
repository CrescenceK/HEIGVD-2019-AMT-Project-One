package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.SpecialCourse;
import ch.heigvd.amt.gestionCours.model.Usr;

import javax.ejb.Local;
import java.sql.ResultSet;
import java.util.List;

@Local
public interface CourseDAOLocal extends IDAO<String, Course> {

    /**
     * @param username
     * @return liste des cours suivis par un etudiant
     */
    public List<SpecialCourse> coursesFollowedByStudent(String username);

    /**
     * @param username
     * @return liste des cours donnés par un professeur
     */
    public List<Course> coursesGivenByProf(String username);

    /**
     * @param course_name
     * @return liste des etudiants inscrit à un cours
     */
    public List<Usr> usersTakingCourse(String course_name);

    /**
     * @param course_name
     * @return un professeur qui enseigne la matiere course name
     */
    public Usr getProfByCourse(String course_name);
}
