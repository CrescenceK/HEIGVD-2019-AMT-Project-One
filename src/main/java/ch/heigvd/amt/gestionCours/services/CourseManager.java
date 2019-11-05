package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Usr;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CourseManager implements IntCourseManager {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;


    @Override
    public Course createCourse(Course course) {

        String REQ_ADD = "INSERT INTO Course (course_name, creditETCS)" + "VALUES(?, ?)";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_ADD);
            pstmt.setString(1, course.getCourse_name());
            pstmt.setInt(2, course.getCredit_etcs());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public Course updateCourse(Course course) {

        Course courseToUpdate = findCourse(course);

        if(courseToUpdate.getCredit_etcs() != course.getCredit_etcs()){
            courseToUpdate.setCredit_etcs(course.getCredit_etcs());
        }

        courseToUpdate.setCourse_name(course.getCourse_name()); // servlet spécial pour changer le nom d'un cour car clé primaire
        createCourse(courseToUpdate);

        return courseToUpdate;
    }

    @Override
    public Course findCourse(Course course) {
        String REQ_FIND = "SELECT * FROM Usr WHERE course_name = ?";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FIND);

            pstmt.setString(1, course.getCourse_name());
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                course = Util.convertResultsetToCourse(result);
            }
            conn.close();

        }  catch (SQLException e){
            e.printStackTrace();
        }
        return course;
    }


    @Override
    public boolean deleteCourse(String course_name) {
        String REQ_DEL = "DELETE FROM Course WHERE course_name = ?";
        boolean deleteCourseSucceed = false;

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_DEL);

            pstmt.setString(1, course_name);
            int result = pstmt.executeUpdate();
            deleteCourseSucceed = result==1;
            conn.close();

        }  catch (SQLException e){
            e.printStackTrace();
        }

        return deleteCourseSucceed;
    }

    @Override
    public List<Course> findAll() {
        String REQ_FINDALL = "SELECT * FROM Course";
        List<Course> allCourses = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FINDALL);
            pstmt.execute();
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                allCourses.add(Util.convertResultsetToCourse(result));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCourses;
    }

    @Override
    public List<Course> coursesFollowedByStudent(Usr usr) {

        String REQ_FOLLOWED_COURSES = "SELECT * FROM Course INNER JOIN HavingCourses ON " +
                "Course.course_name = HavingCourses.having_course_name WHERE student_username = ?";

        List<Course> studentCourses = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FOLLOWED_COURSES);
            pstmt.execute();
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                studentCourses.add(Util.convertResultsetToCourse(result));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCourses;

    }

    @Override
    public List<Course> coursesGivenByProf(Usr usr) {

        String REQ_GIVEN_COURSES = "SELECT * FROM Course INNER JOIN GivingCourses ON " +
                "Course.course_name = GivingCourses.giving_course_name WHERE prof_username = ?";

        List<Course> profCourses = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_GIVEN_COURSES);
            pstmt.execute();
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                profCourses.add(Util.convertResultsetToCourse(result));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profCourses;
    }
}
