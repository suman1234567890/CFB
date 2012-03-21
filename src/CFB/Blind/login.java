package CFB.Blind;
import CFB.database.dbConnect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class for Servlet: login
 *
 */
 public class login extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public login() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		blindlogin(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		blindlogin(request, response);
	}   
	void blindlogin(HttpServletRequest request,HttpServletResponse response)
	{
		try 
		{
		String userid=request.getParameter("username");
		String password=request.getParameter("password");
		dbConnect db= new dbConnect();
		ResultSet rs=db.executeQueryString("select contestid from contestmember where userid=(select userid from userdetail where username='"+userid+"' and password='"+password+"')");
		HttpSession hs= request.getSession();
		
			if(rs.next())
			{
				rs=db.executeQueryString("select * from questionset where contestid= "+rs.getString(1));
				hs.setAttribute("ResultSet", rs);					
				response.sendRedirect("pages/blind/home.jsp");
				//response.sendRedirect("Question");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}