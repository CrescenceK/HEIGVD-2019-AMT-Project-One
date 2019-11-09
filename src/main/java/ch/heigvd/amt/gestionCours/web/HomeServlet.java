package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.services.CourseDAO;
import ch.heigvd.amt.gestionCours.services.CourseDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @EJB
    private CourseDAOLocal course;
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("TAILLE DE LA LISTE" + course.findAll().size());
        req.setAttribute("usrs", course.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
