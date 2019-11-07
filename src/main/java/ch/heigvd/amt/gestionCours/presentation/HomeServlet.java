package ch.heigvd.amt.gestionCours.presentation;

import ch.heigvd.amt.gestionCours.services.IntCourseManager;

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
    private IntCourseManager courseManager;

    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("txt/html;charset-UTF8");
        System.out.println("taille de la liste" +courseManager.findAll().size());
        req.setAttribute("course",courseManager.findAll());
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
