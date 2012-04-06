package CFB.general;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CFB.database.dbConnect;

/**
 * Servlet implementation class for Servlet: register
 *
 */
 public class register extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public register() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		registeruser(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		registeruser(request, response);
	}  
	void registeruser(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			PrintWriter pw=response.getWriter();
			String fname=request.getParameter("Field1");
			String lname=request.getParameter("Field2");
			String uname=request.getParameter("Field3");
			String password=request.getParameter("Field4");
			String password1=request.getParameter("Field6");
			String email=request.getParameter("Field5");
			String add1=request.getParameter("Field14");
			String add2=request.getParameter("Field15");
			String add3=request.getParameter("Field16");
			String add4=request.getParameter("Field17");
			String pin=request.getParameter("Field18");
			String state=request.getParameter("Field19");
			String stat=request.getParameter("Field22");
			pw.print("hi"+fname+lname+uname+password+password1+email+add1+add2+add3+add4+pin+state);
			dbConnect db= new dbConnect();
			db.insertQueryString("insert into registercfb(fname,lname,uname,pass,email,add,pin,state,cat) values('"+fname+"','"+lname+"','"+uname+"','"+password+"','"+email+"','"+add1+add2+add3+add4+"','"+pin+"','"+state+"','"+stat+"')");
			response.sendRedirect("index.jsp");
		}
		catch(Exception e)
		{
			
		}
		
		
	}
}