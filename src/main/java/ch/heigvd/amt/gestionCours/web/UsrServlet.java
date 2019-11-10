package ch.heigvd.amt.gestionCours.web;

import ch.heigvd.amt.gestionCours.datastore.exception.KeyNotFoundException;
import ch.heigvd.amt.gestionCours.model.Usr;
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
    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        Usr user = null;
        try {
            user = usrManager.find(req.getParameter("username"));
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }
        String message = "";
       if(user != null && user.getPassword()== req.getParameter("password"))   {

           if(user.getUsr_role() == 1){

                     req.getRequestDispatcher("/WEB-INF/pages/admin.jsp").forward(req, resp);
           }
           else if(user.getUsr_role()==2)    {
                      req.getRequestDispatcher("/WEB-INF/pages/teacher.jsp");
           }
               else if(user.getUsr_role()==3){
                        req.getRequestDispatcher("/WEB-INF/pages/student.jsp");
           }
       }
       else{
           message = "bad combinaison" ;
           req.setAttribute("message", message);
           req.getRequestDispatcher("/WEB-INF/pages/register.jsp") ;
       }
      resp.sendRedirect(req.getContextPath() + "/");
     }//verifie si le user existe
}
