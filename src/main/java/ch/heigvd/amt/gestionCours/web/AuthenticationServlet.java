package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Usr;
import ch.heigvd.amt.gestionCours.services.CourseDAOLocal;
import ch.heigvd.amt.gestionCours.services.UsrDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/usr")
public class AuthenticationServlet extends HttpServlet {

    @EJB
    private UsrDAOLocal usrManager;
    @EJB
    private CourseDAOLocal course;

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
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
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

        Usr user = null;
        String message = " ";
        String name = (req.getParameter("username") != null) ? req.getParameter("username") : " ";

        String pwd = (req.getParameter("password") != null) ? req.getParameter("password") : " ";

        if (name.compareTo(" ") != 0 && pwd.compareTo(" ") != 0) {
            try {

                //recherche d'un user dans la la base de données
                user = usrManager.find(name);
                req.setAttribute("coursesFollowed", course.coursesFollowedByStudent(user.getUsername()));

                req.setAttribute("users", usrManager.find(user.getUsername()));
                req.setAttribute("coursebyprof", course.coursesGivenByProf(user.getUsername()));
                //verification du role du user afin de le rediriger vers sa page correspondante
                if ((user != null) && user.getPassword().compareTo(pwd) == 0) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    if (user.getUsr_role() == 1) {
                        req.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(req, resp);
                    } else if (user.getUsr_role() == 2) {
                        req.getRequestDispatcher("/WEB-INF/pages/teacher.jsp").forward(req, resp);
                    } else if (user.getUsr_role() == 3) {
                        req.getRequestDispatcher("/WEB-INF/pages/student.jsp").forward(req, resp);
                    }
                }
            } catch (KeyNotFoundException e) {
                message = "bad combinaison";
                req.setAttribute("message", message);
                req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
                e.printStackTrace();
            }
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
