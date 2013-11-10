package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ListWS
 */
@WebServlet("/list")
public class ListWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /* a *  
     * @see HttpServlet#HttpServlet()
     */
	@PersistenceUnit
	EntityManagerFactory emf;
	
	
    public ListWS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String name = (String) request.getParameter("username");
		String passwd = (String) request.getParameter("password");
		
		PrintWriter w = response.getWriter();
		if (name.equals("test") && passwd.equals("test"))
		{
			w.print("<html><body>");
			w.print("<h1>Restful based EHR querys show as follows:</h1>");
			w.print("<ul>");
			w.print("<li><a href = \"rws/queryone\">Frist Query<a></li>");
			w.print("<li><a href = \"rws/querytwo\">Second Query<a></li>");
			w.print("<li><a href = \"rws/querythree\">Third Query<a></li>");
			w.print("<li><a href = \"rws/queryfour\">Fourth Query<a></li>");
			w.print("</ul>");
			w.print("</body></html>");
		}
		else
		{
			w.print("<a href=\"\">back to log again</a>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
