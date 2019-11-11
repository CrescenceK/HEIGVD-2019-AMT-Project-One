package ch.heigvd.amt.gestionCours.web;

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

@WebServlet(urlPatterns = "/usr")
public class UsrServlet extends HttpServlet {

    @EJB
    private UsrDAOLocal usrManager;
    @EJB
    private CourseDAOLocal course;
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        Usr user= null;
        String message = null;

        try {
            user = usrManager.find(req.getParameter("username"));
            req.setAttribute("coursesFollowed",course.coursesFollowedByStudent(user.getUsername()));
            req.setAttribute("users", usrManager.find(user.getUsername()));
            //System.out.println();
            if((user != null) && user.getPassword().compareTo(req.getParameter("password")) == 0)   {
                if(user.getUsr_role() == 1){
                    req.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(req, resp);
                } else if(user.getUsr_role()==2)    {
                    req.getRequestDispatcher("/WEB-INF/pages/teacher.jsp").forward(req, resp);
                } else if(user.getUsr_role()==3){
                    req.getRequestDispatcher("/WEB-INF/pages/student.jsp").forward(req, resp);
                }
            } else {
                message = "bad combinaison" ;
                req.setAttribute("message", message);
                req.getRequestDispatcher("/WEB-INF/pages/register.jsp") ;
            }
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }

     }//verifie si le user existe
}
