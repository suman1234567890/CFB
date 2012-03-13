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
 * Servlet implementation class for Servlet: showQuestion
 *
 */
 public class showQuestion extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public showQuestion() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		show(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		show(request,response);
	}   
	void show(HttpServletRequest request,HttpServletResponse response)
	{
		int n=1;
		PrintWriter pw=null;
		ResultSet rs=null;
		
		response.setContentType("text/plain");
		try
		{
			pw= response.getWriter();
			//HttpSession hs= request.getSession();
			//String userid=hs.getAttribute("userid").toString();
			
			String subid=request.getParameter("subid");
			pw.write("[");
			
				
			dbConnect db= new dbConnect();
			String query="select question,questionid from question where subjectid="+subid;
			
			System.out.print(query);
			rs=db.executeQueryString(query);
			
			
			while(rs.next())
			{
				pw.print("{");
				pw.print("\"question\":");
				pw.print("\""+rs.getString(1)+"\",");
				
				//pw.print("\"SubjectName\":");
				pw.print("\"questionid\":\""+rs.getString(2)+"\"");
				
				//pw.print("</SubjectDetail>");
				//pw.print("\"SubjectId\":\""+rs.getString(1)+"\"");
				
				//pw.print("</SubjectId>");
				if(rs.isLast())
					{
					pw.print("}");
					}
				else
				{
					pw.print("},");
				}
					
			}
			
			pw.write("]");	
		}
			
	
		catch(Exception e)
		{
			System.out.print(e);
			
		}
		
		
	
		
	}

}