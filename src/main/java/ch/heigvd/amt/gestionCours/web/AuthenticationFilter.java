package ch.heigvd.amt.gestionCours.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.io.IOException;

@WebFilter(urlPatterns = {"/", "/course", "/index", "/login", "/usr_add","/usr_delete","/course_add","/course_delete" } )
public class AuthenticationFilter implements Filter {
    private static final boolean debug = false;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured.
    private FilterConfig filterConfig = null;

    /**
     *
     */
    public AuthenticationFilter() {

    }

    private void doBeforeProcessing(RequestWrapper request, ResponseWrapper response)
            throws ServletException {
        if (debug) {
            log("AuthenticationFilter:DoBeforeProcessing");
        }

    }

    private void log(String s) {
    }

    private void doAfterProcessing(RequestWrapper request, ResponseWrapper response)
            throws IOException, ServletException {
        if (debug) {
            log("AuthenticationFilter:DoAfterProcessing");
        }

    }
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") == null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index");;
        } else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}