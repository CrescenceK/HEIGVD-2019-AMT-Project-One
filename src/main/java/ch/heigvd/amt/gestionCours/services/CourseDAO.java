package ch.heigvd.amt.gestionCours.services;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.SpecialCourse;
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
import java.util.stream.Collector;

@Stateless
public class CourseDAO implements CourseDAOLocal {

    @Resource(lookup = "jdbc/GestionDesCours")
    private DataSource dataSource;

    @Override
    public Course create(Course entity) throws DuplicateKeyException {
        String REQ_ADD = "INSERT INTO Course (course_name, creditETCS)" + "VALUES(?, ?);";
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_ADD);
            pstmt.setString(1, entity.getCourse_name());
            pstmt.setInt(2, entity.getCredit_etcs());
            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Course find(String course_name) throws KeyNotFoundException {
        String REQ_FIND = "SELECT * FROM Usr WHERE course_name=" + "'" + course_name + "'"+ ";";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FIND);
            ResultSet result = pstmt.executeQuery();
            boolean hasRecord = result.next();
            if (!hasRecord) {
                throw new KeyNotFoundException("Could not find course with course_name = " + course_name);
            }
            conn.close();
            Course course = Util.convertResultsetToCourse(result);
            return course;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Error(e);
        }
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
    public void update(Course entity) throws KeyNotFoundException {

    String REQ_UPDATE = "UPDATE Course SET course_name=?, credit_etcs=?";
    Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_UPDATE);
            pstmt.setString(1, entity.getCourse_name());
            pstmt.setInt(2, entity.getCredit_etcs());
            int numberOfUpdatedUsers = pstmt.executeUpdate();
            conn.close();
            if (numberOfUpdatedUsers != 1) {
                throw new KeyNotFoundException("Could not find Course with course_name = " + entity.getCourse_name());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


     /*   Course courseToUpdate = find(entity.getCourse_name());
        if(courseToUpdate.getCredit_etcs()!=entity.getCredit_etcs()) {
             courseToUpdate.setCredit_etcs(entity.getCredit_etcs());
        }

        if(!courseToUpdate.getCourse_name().equals(entity.getCourse_name())) {
            courseToUpdate.setCourse_name(entity.getCourse_name());
        }
        try {
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public boolean delete(String course_name) throws KeyNotFoundException {
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
    public List<SpecialCourse> coursesFollowedByStudent(String username) {

        //String REQ_FOLLOWED_COURSES = "SELECT * from havingcourses WHERE student_username='" + username + "';";
        String REQ_FOLLOWED_COURSES = "SELECT course.* FROM Course INNER JOIN HavingCourses ON " +
                "Course.course_name = HavingCourses.having_course_name WHERE student_username ='" + username + "' ORDER BY 1;";

        List<SpecialCourse> studentCourses = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_FOLLOWED_COURSES);
            pstmt.execute();
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                String course_name = result.getString("course_name");
                Usr prof = getProfByCourse(course_name);
                SpecialCourse spc = SpecialCourse.builder()
                        .course(Util.convertResultsetToCourse(result))
                        .prof(prof)
                        .nb_std(usersTakingCourse(course_name).size())
                        .build();
                studentCourses.add(spc);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCourses;
    }

    @Override
    public List<Usr> usersTakingCourse(String course_name){

        final String REQ_STUDENT = "SELECT * FROM Usr INNER JOIN HavingCourses ON " +
                "Usr.username = HavingCourses.student_username WHERE having_course_name = " +
                "'" + course_name + "';";

        List<Usr> students = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_STUDENT);
            pstmt.execute();
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                students.add(Util.convertResultsetToUser(result));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;

    }

    @Override
    public List<Course> coursesGivenByProf(String username) {
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

    @Override
    public Usr getProfByCourse(String course_name) {
        String REQ_GIVEN_COURSES = "SELECT usr.* FROM GivingCourses INNER JOIN usr ON  prof_username = username " +
                "WHERE giving_course_name = '" + course_name + "';";
        Connection conn;
        Usr ret = null;
        ResultSet result = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(REQ_GIVEN_COURSES);
            pstmt.execute();
            result = pstmt.executeQuery();
            conn.close();
            while(result.next())
                ret = Util.convertResultsetToUser(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
        System.out.println(ret);
        return ret;
    }
}
