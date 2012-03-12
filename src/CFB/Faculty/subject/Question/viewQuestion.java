
package CFB.Faculty.subject.Question;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CFB.database.dbConnect;

/**
 * Servlet implementation class for Servlet: viewQuestion
 *
 */
 public class viewQuestion extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public viewQuestion() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		view(request,response);
	}  	
	void view(HttpServletRequest request, HttpServletResponse response)
	{
		dbConnect db= new dbConnect();
		String id=request.getParameter("subid");
		ResultSet rs=null;
		PrintWriter pw=null;
		response.setContentType("text/xml");
		
		try
		{
			pw=response.getWriter();
			pw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?><channel>");
			System.out.print("select question,correctmarks,negativemarks from question where subjectid="+id);
			rs=db.executeQueryString("select question,correctmarks,negativemarks from question where subjectid="+id);
			while(rs.next())
			{
				pw.print("<item>");
				pw.print("<question>");
				pw.println(rs.getString(1));
				
				pw.print("</question>");
				pw.print("<cmark>"+rs.getString(2));
				
				pw.print("</cmark>");
				pw.print("<nmark>"+rs.getString(3));
				
				pw.print("</nmark>");
				pw.print("</item>");
			}
			pw.write("</channel>");	
			
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		view(request,response);
	}   	  	    
}