package abc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertRecord() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid=Integer.parseInt( request.getParameter("uid"));
		String uname= request.getParameter("uname");
		int uage=Integer.parseInt( request.getParameter("uage"));
		int usalary=Integer.parseInt( request.getParameter("usalary"));
		String udesig= request.getParameter("udesig");
		String upass = request.getParameter("upass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sarvesh143");	
			PreparedStatement stmt= con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
			stmt.setInt(1, uid);
			stmt.setString(2, uname);
			stmt.setInt(3, uage);
			stmt.setInt(4, usalary);
			stmt.setString(5, udesig);
			stmt.setString(6, upass);
			stmt.execute();
			PrintWriter out= response.getWriter();
			out.print("<body bgColor='yellow'>");
			out.print("<h1>");
			out.print("HI :"+uname+"You Successfully Registerd ...!");
		} catch (Exception e) {
				System.out.println(e);;
		}
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
