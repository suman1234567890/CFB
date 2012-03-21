<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="java.sql.ResultSet" %>
<%@page import="CFB.database.*" %>
</head>
<body style="height:650px;width:100%;" >
<%

try {
	
	HttpSession hs=request.getSession();
	ResultSet rs=(ResultSet)hs.getAttribute("ResultSet");		
	if(rs.next())
	{
			
			
			
			
			dbConnect db = new dbConnect();
			ResultSet rs1=db.executeQueryString("select question from question where questionid="+rs.getString(2));
			ResultSet rs2=db.executeQueryString("select option from option where questionid="+rs.getString(2));
			
			rs1.next();
			
			%>
<div style="height:90%;width:90%;border-color: black;border-style:groove;margin:3%">
  	<div style='margin: 50px;' align="center">
  		<label style='font: 900;font-size: xx-large'><%=rs1.getString(1) %></label>
  	</div>
  	<div style='margin:50px;'>
  	<%
  	while(rs2.next())
  		{%>
  		<label  style='margin:50px; font: 900;font-size:large'><%=rs2.getString(1) %></label><br/>
  		<%} %>
  	</div>
  	<div align="middle">
  		<input  type='submit' value='submit' style="width:100px;height:30px;"/>
  	</div>
  	
</div>
<%
			hs.setAttribute("ResultSet",rs);
	}
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>


</body>
</html>