package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.datastore.exception.DuplicateKeyException;
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
import java.io.IOException;

@WebServlet(urlPatterns = "/usr_delete")


public class DeleteUsrServlet  extends HttpServlet{

    @EJB
    private UsrDAOLocal usrManager;

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
        req.getRequestDispatcher("/WEB-INF/pages/deleteUser.jsp").forward(req, resp);

    }

    @Override
    protected  void doDelete(HttpServletRequest req,  HttpServletResponse resp){
        Usr user=null;
        String message = " ";
        try {
            user = usrManager.find(req.getParameter("username"));
            if(user!=null){
                usrManager.delete(user.getUsername());
            }else{
                resp.getWriter().println("Erreur l'utilisateur n'existe pas");
            }

        } catch (KeyNotFoundException | IOException e) {
            message = "user doesn't exist " ;
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/pages/admin.jsp") ;
            e.printStackTrace();
            e.printStackTrace();
        }
        ;
    }
}
