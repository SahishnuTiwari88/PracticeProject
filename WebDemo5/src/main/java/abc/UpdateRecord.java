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

public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateRecord() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	int uid =Integer.parseInt( request.getParameter("uid"));
	int usalary= Integer.parseInt( request.getParameter("usalary"));
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Sarvesh143");	
		PreparedStatement stmt= con.prepareStatement("update  emp set salary =Salary+  ? where id = ?");
		stmt.setInt(1, usalary);
		stmt.setInt(2, uid);
		
		stmt.execute();
		PrintWriter out= response.getWriter();
		out.print("<body bgColor='yellow'>");
		out.print("<h1>");
		out.print("Updated  Successfully  ...!");
	} catch (Exception e) {
			System.out.println(e);
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
