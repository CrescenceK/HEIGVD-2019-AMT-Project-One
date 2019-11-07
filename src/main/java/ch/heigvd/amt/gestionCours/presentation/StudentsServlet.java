package ch.heigvd.amt.gestionCours.presentation;

import ch.heigvd.amt.gestionCours.services.IntCourseManager;
import ch.heigvd.amt.gestionCours.services.UsrManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/student")
public class StudentsServlet extends HttpServlet {

    @EJB
    private UsrManager usrManager;
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usrManager", usrManager.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/course.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
