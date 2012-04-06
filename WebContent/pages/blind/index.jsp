<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
function Sound() {
   var myfield= document.getElementById("Text");
   var a="<object id='flashPlayer' type='application/x-shockwave-flash' data='player_mp3_maxi.swf' width='350' height='25'><param name='wmode' value='transparent' /> <param name='movie' value='player_mp3_maxi.swf' /><param name='FlashVars' value='mp3=http://"+j+"/TGMC-version1/Servlet.mp3?Text=who are you?&amp;autoplay=1&amp;showvolume=1&amp;sliderwidth=25&amp;volumewidth=40&amp;volumeheight=12&amp;bgcolor=E8E8E8&amp;bgcolor1=E8E8E8&amp;bgcolor2=E8E8E8&amp;buttoncolor=828282' /></object>" ;
   alert(a);
   
   document.getElementById("Snakes").innerHTML="<embed src='../../Servlet.mp3?Text="+myfield.value+"'hidden=true autostart=true loop=false>";
}
</script>
</head>
<body>

<applet code="CFB.Blind.Recorder.Player.class"  ARCHIVE="Audio2.jar"
width="450" height="350">
Java applet that draws animated bubbles.
</applet>
<form action='../../login' method='post'>
	<div style='width:300px;height:200px;background-image: url("../../images/stripe4.png");position: absolute;top:40%;left:35%;'>
		<table style='margin:10px'>
		<tr style="height:40px;">
			<td><label style='font: large'>UserName : </label></td>
			<td><input type='text' id='username' name='username'/></td>
		</tr>
		<tr style="height:100px;">
			<td><label style='font: large'>Password : </label></td>
			<td><input type='password' id='password' name='password'/></td>
		</tr>
		<tr style="height:40px;margin-left:10px">
			<td><input type='submit' value='Submit'/></td>
		</tr>
		</table>
	</div>
</form>


</body>
</html>