

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
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
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String retype_password = request.getParameter("retype_password");
		
		if(retype_password.equals(password)) {
			
			try {
					
				
				  Class.forName("com.mysql.jdbc.Driver");
			      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","SvcpiloT54321");
			      PreparedStatement stmt = null;
			    
			      stmt = con.prepareStatement("insert into users.users (email, username, password) values (?,?,?)");
			      
			      
			      stmt.setString(1, email);
			      stmt.setString(2, username);
			      stmt.setString(3, password);
			      stmt.executeUpdate();
			      
			     //stmt.executeUpdate(insert);
			   
			          
		          HttpSession session = request.getSession();
		          session.setAttribute("username", username);
		          session.setAttribute("email", email);
		          
		          response.sendRedirect("home.jsp");
			          
			       
				
			} catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
			
			
		}else {
			
		}
		
	}

}
