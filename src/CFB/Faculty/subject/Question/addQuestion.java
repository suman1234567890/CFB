package CFB.Faculty.subject.Question;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CFB.database.dbConnect;

/**
 * Servlet implementation class for Servlet: addQuestion
 *
 */
 public class addQuestion extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public addQuestion() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		add(request,response);
	}   
	void add(HttpServletRequest request, HttpServletResponse reponse)
	{
		ResultSet rs=null;
		String id=null;
		String question=null;
		String subid=null;
		String cm=null;
		String nm=null;
		String[] opt=null;
		String optiontemp=null;
		String[] correct=null;
		String cortemp=null;
		subid=request.getParameter("sub");
		question=request.getParameter("qtn");
		cm=request.getParameter("cm");
		nm=request.getParameter("nm");
		optiontemp=request.getParameter("opt");
		opt=optiontemp.split(",");
		cortemp=request.getParameter("cor");
		correct=cortemp.split(",");
		dbConnect db= new dbConnect();
		db.insertQueryString("insert into question(subjectid,question,correctmarks,negativemarks) values("+subid+",'"+question+"',"+cm+","+nm+")");
		rs=db.executeQueryString("select questionid from question where question='"+question+"'");
		try{
			while(rs.next())
			{
				id=rs.getString("questionid");
				
			
			}
			for(int i=0;i<opt.length;i++)
			{
				db.insertQueryString("insert into option(questionid,option)values("+id+",'"+opt[i]+"')");
			}
			for(int i=0;i<correct.length;i++)
			{
				db.insertQueryString("insert into correct(questionid,correctopt)values("+id+","+correct[i]+")");
			}
		}
		catch(Exception e)
		{
			System.out.print("Error"+e);
		}
		
	}
}