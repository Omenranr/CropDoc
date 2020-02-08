package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class index
 */
@WebServlet( name="index", urlPatterns = {"/", "/index", "/about", "/features"} )
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(path.equals("/index") || path.equals("/")) {
			request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,  response);
		}
		else if(path.equals("/about")) {
			request.getRequestDispatcher("WEB-INF/about.jsp").forward(request,  response);
		}
		else if(path.equals("/features")) {
			request.getRequestDispatcher("WEB-INF/features.jsp").forward(request,  response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
