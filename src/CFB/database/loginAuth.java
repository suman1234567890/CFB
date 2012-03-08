package CFB.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: loginAuth
 *
 */
 public class loginAuth extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public loginAuth() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		login(request,response);
	}   	
	void login(HttpServletRequest request,HttpServletResponse response)
	{
			
		String username=request.getParameter("log");
		String password=request.getParameter("pwd");
		String userid=null;
		PrintWriter pw=null;
		boolean flag=false;
		dbConnect db= new dbConnect();
		ResultSet rs=db.executeQueryString("select * from userdetail where username='"+username+"' and password='"+password+"'");
		try
		{
			pw=response.getWriter();	
			while(rs.next())
			{
				userid=rs.getString("userid");
				flag=true;
			}
			if(flag==true)
			{
				HttpSession session= request.getSession();
				session.setAttribute("userid", userid);
				
				response.sendRedirect("pages/faculty/home.jsp");
				
			}
		}
		catch(Exception e)
		{
			pw.write(e.toString());
		}
		
	}
	
}