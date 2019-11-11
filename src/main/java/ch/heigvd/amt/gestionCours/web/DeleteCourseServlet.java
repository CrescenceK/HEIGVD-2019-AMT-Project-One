package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Usr;
import ch.heigvd.amt.gestionCours.services.CourseDAOLocal;
import ch.heigvd.amt.gestionCours.services.UsrDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/course_delete")


public class DeleteCourseServlet  extends HttpServlet{

    @EJB
    private CourseDAOLocal courseManager;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/deleteCourse.jsp").forward(req, resp);

    }

    @Override
    protected  void doDelete(HttpServletRequest req,  HttpServletResponse resp){
        Course course=null;
        String message=" ";
        try {
            course = courseManager.find(req.getParameter("course_name"));
                courseManager.delete(course.getCourse_name());


        } catch (KeyNotFoundException e) {
            message = "Course doesn't exist " ;
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp") ;
            e.printStackTrace();
        }
        ;
    }
}
