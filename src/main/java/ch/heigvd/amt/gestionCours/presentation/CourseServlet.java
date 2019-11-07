package ch.heigvd.amt.gestionCours.presentation;

/**
 * @author Francine Youndzo (francine.youndzokengne@heig-vd.ch)
 */

import ch.heigvd.amt.gestionCours.services.IntCourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/course")
public class CourseServlet extends HttpServlet {

    @EJB
    private IntCourseManager courseManager;

    /**
     * Handles the HTTP <code>GET</code> <code>POST</code> method
     * @param req servlet requestco
     * @param resp servlet response
     * @throws ServletException if a servlet-specific errors occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("taille de la liste" +courseManager.findAll().size());
        req.setAttribute("course",courseManager.findAll());

        req.getRequestDispatcher("/WEB-INF/pages/course.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
