package CFB.Faculty.contest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CFB.database.dbConnect;

/**
 * Servlet implementation class for Servlet: showContest
 *
 */
 public class showContest extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public showContest() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  
	void show(HttpServletRequest request,HttpServletResponse response)
	{
		int n=1;
		PrintWriter pw=null;
		ResultSet rs=null;
		
		response.setContentType("text/xml");
		try
		{
			pw= response.getWriter();
			HttpSession hs= request.getSession();
			String userid=hs.getAttribute("userid").toString();
			pw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?><channel>");
			
				
			dbConnect db= new dbConnect();
			String query="select contestid,contestname,contestdetail,duration from contest where userid="+userid;
			System.out.print(query);
			rs=db.executeQueryString(query);
			while(rs.next())
			{
				pw.print("<item>");
				pw.print("<ContestName>");
				pw.println(rs.getString(2));
				
				pw.print("</ContestName>");
				pw.print("<ContestDetail>"+rs.getString(3));
				
				pw.print("</ContestDetail>");
				pw.print("<ContestId>"+rs.getString(1));
				
				pw.print("</ContestId>");
				pw.print("<Duration>"+rs.getString(4));
				
				pw.print("</Duration>");
				pw.print("</item>");
			}
			
			pw.write("</channel>");	
		}
			
	
		catch(Exception e)
		{
			System.out.print(e);
			
		}
		
		
	
		
	}
}