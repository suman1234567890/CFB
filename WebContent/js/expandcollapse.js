function toggleMe(a,b){
  var e=document.getElementById(a);
  if(!e)return true;
  if(e.style.display=="none"){
    e.style.display="block"
	document.getElementById(b).src = 'images/up.png';
  } else {
    e.style.display="none"
	document.getElementById(b).src = 'images/down.png';
  }
  return true;
}// JavaScript Document