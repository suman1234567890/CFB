package CFB.Blind;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CFB.database.dbConnect;

/**
 * Servlet implementation class for Servlet: Question
 *
 */
 public class Question extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Question() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getQuestion(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getQuestion(request, response);
	}   
	void getQuestion(HttpServletRequest request,HttpServletResponse response)
	{
		
		try {
			PrintWriter pw= response.getWriter();
			HttpSession hs=request.getSession();
			
			ResultSet rs=(ResultSet)hs.getAttribute("ResultSet");		
			if(rs.next())
			{
					
					
					
					
					dbConnect db = new dbConnect();
					ResultSet rs1=db.executeQueryString("select question from question where questionid="+rs.getString(2));
					ResultSet rs2=db.executeQueryString("select option from option where questionid="+rs.getString(2));
					
					rs1.next();
					pw.write(rs1.getString(1));
					while(rs2.next())
			  		{
						pw.write(rs2.getString(1));
						
			  		}
					hs.setAttribute("ResultSet",rs);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}