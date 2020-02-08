package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class OutsideRestrictionFilter
 */
@WebFilter(urlPatterns = {"/","/about","/features","/index","/login"})
public class OutsideRestrictionFilter implements Filter {

	
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
    /**
     * Default constructor. 
     */
    public OutsideRestrictionFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		 /* Cast des objets request et response */
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si l'objet utilisateur existe  dans la session en cours, alors
         * l'utilisateur est connecté.
         */
        if ( session.getAttribute( ATT_SESSION_USER ) != null ) {
            /* Redirection vers la page d'authentification */
            response.sendRedirect(request.getContextPath()+"/home" );
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( request, response );
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


}
