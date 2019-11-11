package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Course;
import ch.heigvd.amt.gestionCours.model.Usr;
import ch.heigvd.amt.gestionCours.services.CourseDAO;
import ch.heigvd.amt.gestionCours.services.CourseDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/course_add")


public class AddCourseServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/addCourse.jsp").forward(req, resp);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = null;
      String message = " ";
        try {
            int credits= Integer.parseInt(req.getParameter("Credits"));


            //enregistrer les valeurs entrees dans le champs et construit un nouveau cours
            Course cours = Course.builder().course_name(req.getParameter("Coursename"))
                    .credit_etcs(credits)
                    .build();

            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(req, resp);

            //cree un nouveau cours avec les infos enregistrés
            course = courseManager.create(cours);

        } catch (DuplicateKeyException e) {
            message = "course already exist " ;
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp") ;

            e.printStackTrace();
        }
    }
}
