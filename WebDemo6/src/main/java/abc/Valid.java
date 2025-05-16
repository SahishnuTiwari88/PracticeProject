package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Valid
 */
public class Valid extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Valid() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String name=request.getParameter("uname");
	String pass= request.getParameter("upass");
	response.setContentType("text/html");
	
	
	PrintWriter out = response.getWriter();
	try {
		response.setContentType("text/html");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");	
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from userdetalis");
		while(rs.next()) {
			if(name.equalsIgnoreCase(rs.getString(1))&& pass.equalsIgnoreCase(rs.getString(2))) {
				out.print("<h1>");
				out.print("Yes boss succssfullty Logged in ");
				RequestDispatcher rd= request.getRequestDispatcher("Index.html");
				rd.forward(request, response);
			}
			else {
				out.print("<h1>");
				out.print("<span style='color:red'>please try once again</span> ");
				
				RequestDispatcher rd= request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				
			}
		}
		out.print("</h1>");
		stmt.close();
		
		
	} catch (Exception e) {
		System.out.println(e);
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
