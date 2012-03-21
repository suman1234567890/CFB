<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function Sound() {
   var myfield= document.getElementById("Text")
   var a="<object id='flashPlayer' type='application/x-shockwave-flash' data='player_mp3_maxi.swf' width='350' height='25'><param name='wmode' value='transparent' /> <param name='movie' value='player_mp3_maxi.swf' /><param name='FlashVars' value='mp3=http://"+j+"/TGMC-version1/Servlet.mp3?Text=who are you?&amp;autoplay=1&amp;showvolume=1&amp;sliderwidth=25&amp;volumewidth=40&amp;volumeheight=12&amp;bgcolor=E8E8E8&amp;bgcolor1=E8E8E8&amp;bgcolor2=E8E8E8&amp;buttoncolor=828282' /></object>" ;
   alert(a);
   
   document.getElementById("Snakes").innerHTML="<embed src='../../Servlet.mp3?Text="+myfield.value+"'hidden=true autostart=true loop=false>";
}
</script>
</head>
<body>
<form action='../../login' method='post'>
	<input type='text' id='username' name='username'/>
	<input type='password' id='password' name='password'/>
	<input type='submit' value='Submit'/>
</form>


</body>
</html>