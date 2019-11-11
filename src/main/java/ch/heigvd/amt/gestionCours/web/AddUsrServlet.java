package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Usr;
import ch.heigvd.amt.gestionCours.services.CourseDAO;
import ch.heigvd.amt.gestionCours.services.CourseDAOLocal;
import ch.heigvd.amt.gestionCours.services.UsrDAO;
import ch.heigvd.amt.gestionCours.services.UsrDAOLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/usr_add")


public class AddUsrServlet extends HttpServlet {

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
        //super.doGet(req, resp);
        req.getRequestDispatcher("/WEB-INF/pages/addUser.jsp").forward(req, resp);

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
        String message=" ";

        try {

            String Role = req.getParameter("Role");
            int roleId = 1;


            //on verifie le role entrer dans le champs Role
            if (Role == "admin") {
                roleId = 1;
            } else if (Role == "teacher") {
                roleId = 2;
            } else {
                roleId = 3;
            }
            //enregistrer les valeurs entrees dans le champs et construit un nouvel user
            Usr usr = Usr.builder().username(req.getParameter("Username"))
                    .first_name(req.getParameter("Firstname"))
                    .last_name(req.getParameter("Lastname"))
                    .password(req.getParameter("Password"))
                    .usr_role(roleId)
                    .build();

            resp.getWriter().println(usr.getUsername() + usr.getFirst_name() + usr.getLast_name() + usr.getUsr_role());
            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(req, resp);

            //cree un nouvel utilisateur avec les infos enregistrées
            user = usrManager.create(usr);

        } catch (DuplicateKeyException e) {
            message = "Usr already exist " ;
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp") ;
            e.printStackTrace();
        }
    }
}
