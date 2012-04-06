<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="java.sql.ResultSet" %>
<%@page import="CFB.database.*" %>
<script type="text/javascript" src="../../scripts/jquery-1.7.1.min.js" ></script>
<script type='text/javascript'>
function Sound(text) {
   
   
   document.getElementById("Snakes").innerHTML="<embed src='../../Servlet.mp3?Text="+text+"'hidden=true autostart=true loop=false>";
}
	$(document).ready(function () {
		var s='i love india';
		Sound(s);


	});
</script>

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
	<div style="height:50%;width:50%;border-color: black;border-style:groove;left:30%;top:30%;background-image: url('../../images/stripe4.png');position:absolute;">
  	<div style='margin: 50px;' align="center">
  		<label style='font: 900;font-size: xx-large'><%=rs1.getString(1) %></label>
  	</div>
  	<div style='margin:50px;'>
  	<%
  	while(rs2.next())
  		{
  		%>
  		<div style='height:20px;'>
  		<label  style='font: 900;font-size:large'>Option :<%=rs2.getString(1) %></label><br/>
  		</div>
  		<%
  		} 
  		%>
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
<div id='Snakes'></div>

</body>
</html>