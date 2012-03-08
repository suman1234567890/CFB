package CFB.Faculty.subject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CFB.database.dbConnect;

/**
 * Servlet implementation class for Servlet: addSubject
 *
 */
 public class addSubject extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public addSubject() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddSubject(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddSubject(request, response);
	}
	void AddSubject(HttpServletRequest request, HttpServletResponse response)
	{
		String name=request.getParameter("subjectname");
		String detail=request.getParameter("subjectdetail");
		HttpSession hs=request.getSession();
		String userid=hs.getAttribute("userid").toString();
		dbConnect db= new dbConnect();
		String query="insert into subject(subjectname,subjectdetail,userid) values('"+name+"','"+detail+"',"+userid+")";
		System.out.print(query);
		db.insertQueryString(query);
		
	}
}