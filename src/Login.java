

import java.io.IOException;

import javax.imageio.metadata.IIOInvalidTreeException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		
		
	
			
			try {
				
				  Class.forName("com.mysql.jdbc.Driver");
			      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","SvcpiloT54321");
			      Statement stmt = con.createStatement();
			      ResultSet rs = stmt.executeQuery("select username, email from users.users where username='"+username+"' and password='"+password+"'");
			      
			      if(rs.next()) {
			          
			          HttpSession session = request.getSession();
			          session.setAttribute("username", username);
			          
			          session.setAttribute("email", rs.getString("email"));
			          
			          response.sendRedirect("home.jsp");
			          
			        }else {
			        	HttpSession session = request.getSession();
				          session.setAttribute("error", "invalid details");
			        	response.sendRedirect("sign-in.jsp");
			        }
				
			} catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }

			
	
			
			
	
		
		
	}

}
