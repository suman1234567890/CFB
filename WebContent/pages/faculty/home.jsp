<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome</title>
    <link rel='Stylesheet' href="../../jqwidgets/styles/jqx.base.css" type="text/css" />
    <link rel='Stylesheet' href="../../jqwidgets/styles/jqx.darkblue.css" type="text/css" />
    <script type="text/javascript" src="../../scripts/jquery-1.7.1.min.js" ></script>
    <script type="text/javascript" src="../../scripts/gettheme.js" ></script>
    <script type="text/javascript" src="../../jqwidgets/jqxcore.js" ></script>
    <script type="text/javascript" src="../../jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxmenu.js" ></script>
    <script type="text/javascript" src="../../jqwidgets/jqxbuttons.js" ></script>
    <script type="text/javascript" src="../../jqwidgets/jqxexpander.js" ></script>
    <script type="text/javascript" src="../../jqwidgets/jqxnavigationbar.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxdropdownlist.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxgrid.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxgrid.pager.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxgrid.selection.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxwindow.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxpanel.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxtabs.js"></script>
    <script type="text/javascript" src="../../jqwidgets/jqxcheckbox.js"></script>
    <script src="../../scripts/MyScript.js" type="text/javascript"></script>
    <script type="text/javascript">
    <% HttpSession session1= request.getSession(); 
    	String userid=session1.getAttribute("userid").toString();%>
    	
        var userid=<%=userid%>;
    </script>
    </head>
<body background="../../images/stripe4.png">
    <div id="header" style='width: 100%; height: 100px; margin: 0px; background: url(../../images/templatemo_title_bar_bg.jpg) repeat-x;'>
        <div id="site_title">
            <img alt="The Great Mind Challenge" height="90px" width="300px" align="left" src="../../images/tgmc.png" />
            <label style='font-size: xx-large; color: #A7CF3A'>
                Certification For Blind</label>
            <br />
            <span>
                <label style='font-size: medium; color: #5C5C5C'>
                    &nbsp;&nbsp;&nbsp; A project of The Great Mind Challenge : Devleoped by SNAKES
                </label>
            </span>
        </div>
    </div>
    <div id='divider' style='height: 10px; background-color: Red;'>
    </div>
    <div id='content' style='margin: -20px;'>
        <div id='jqxWidget' style='height: 300px;'>
            <div id='jqxMenu' style='visibility: hidden; margin-left: 60px; margin-right: 60px;'>
                <ul>
                    <li style='width: 80px'><a href="#Home">
                        <label>
                            Home</label></a></li>
                    <li style='width: 80px'>
                        <label>
                            Contest</label></li>
                    <li style='width: 80px'>
                        <label>
                            Subjects</label></li>
                    <li style='width: 80px'>
                        <label>
                            Report</label></li>
                    <li style='width: 80px'>
                        <label>
                            Subjects</label>
                    </li>
                    <li style='list-style: none;'>
                        <div style='float: left; height: 35px; margin-top: 5px; margin-left: 20px;'>
                            <input style='float: left; height: 17px; width: 130px;' /></div>
                        <span class='jqx-menu-search' style='margin-top: 5px; margin-left: 3px; padding: 2px;
                            float: left;'>Search</span> </li>
                </ul>
            </div>
            <div id='container' style='width: 90%; height: 450px; margin-left: 60px; margin-top: 20px;
                border: 5px double #808080; background-image: url(&#039;../../images/stripe3.png&#039;);'>
                <div style='visibility: hidden; width: 300px; float: right'>
                    <div id="jqxNavigationBar">
                        <div>
                            <div style='margin-top: 2px;'>
                                <div style='float: left;'>
                                    <img alt='Mail' src='../../images/mailIcon.png' /></div>
                                <div style='margin-left: 4px; float: left;'>
                                    Mail</div>
                            </div>
                        </div>
                        <div>
                            <ul>
                                <li><a href='#'>Contacts</a></li>
                                <li><a href='#'>Mails</a></li>
                                <li><a href='#'>Notes</a></li>
                            </ul>
                        </div>
                        <div>
                            <div style='margin-top: 2px;'>
                                <div style='float: left;'>
                                    <img alt='Mail' src='../../images/contactsIcon.png' /></div>
                                <div style='margin-left: 4px; float: left;'>
                                    Contacts</div>
                            </div>
                        </div>
                        <div>
                            <ul>
                                <li><a href='#'>Business Cards</a></li>
                                <li><a href='#'>Address Cards</a></li>
                                <li><a href='#'>Detailed Address Cards</a></li>
                                <li><a href='#'>Phone List</a></li>
                            </ul>
                        </div>
                        <div>
                            <div style='margin-top: 2px;'>
                                <div style='float: left;'>
                                    <img alt='Mail' src='../../images/tasksIcon.png' /></div>
                                <div style='margin-left: 4px; float: left;'>
                                    Tasks</div>
                            </div>
                        </div>
                        <div>
                            <ul>
                                <li><a href='#'>Simple List</a></li>
                                <li><a href='#'>Detailed List</a></li>
                                <li><a href='#'>Active Tasks</a></li>
                                <li><a href='#'>Phone List</a></li>
                            </ul>
                        </div>
                        <div>
                            <div style='margin-top: 2px;'>
                                <div style='float: left;'>
                                    <img alt='Mail' src='../../images/notesIcon.png' /></div>
                                <div style='margin-left: 4px; float: left;'>
                                    Notes</div>
                            </div>
                        </div>
                        <div>
                            <ul>
                                <li><a href='#'>Icons</a></li>
                                <li><a href='#'>Notes List</a></li>
                                <li><a href='#'>Last Seven Days</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <br />
        </div>
        <div id='elements' style="width: 830px; margin-left: 80px; margin-top: -200px; height: 405px;
            float: left; border: 5px double #808080;">
        </div>
        <div id="clickonadd" style='visibility:hidden'>
            <div style="width: 100%; height: 650px; border: 0px solid #ccc; margin-top: 10px;"
                id="mainDemoContainer">
                <div id="eventWindow">
                    <div>
                        Add Subject</div>
                    <div>
                        <div>
                        	<label style='width:20px;font-family: fantasy;color: black'> Name </label>
                            <input type='text' id='subname'/>
                            <br/>
                            <label style='width:20px;font-family: fantasy;color: black'> Detail </label>
                            <input type='text' id='subdetail'/>
                        </div>
                        <div>
                            <div style="float: right; margin-top: 15px;">
                            	
                                <input type="button" id="ok" value="OK" style="margin-right: 10px" />
                                
                                <input type="button" id="cancel" value="Cancel" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</body>
</html>

    
 <!--   Add Question -->
 <div id ='containerQuestion' >
 <div>
 Add Question
 </div>
<div id='AddQuestionContainer' style='width:95%;height:500px;color:gray'>
<div style='width:95%;'>
	<div style='width:100%;height:50px; margin-left:30px'>
		<label>Enter The Question : </label>
		
		<input id='question' type='text' style='width:70%;'/>
		<input type='button' id='addOption' onClick='addOptionToForm()' value='+'/>

	</div>
	<div id='containertot'>
		<div id='optionContainer' style='float:left;width:50%;'>
		</div>
		<div id='buttonContainer' style='float:right;width:50%'>
			<label>Correct  Marks :</label><input type='text' value='1' id='correctmarks' style='width:20px'/></br>
			<label>Negative Marks :</label><input type='text' value='0' id='negativemarks'  style='width:20px'/></br>
			<input type='button' value='Save' id='save'/>
			<input type='button' value='Reset' id='reset'/>
			<div id='questionremarks'>
				
			</div>
		</div>
	</div>
</div>

</div>
</div>
<!-- End question-->
<div id='viewquestion'>
	<div>
	ViewQuestion
	</div>
	<div id='viewquestioncontainer'>
		<div id='viewquestioncontainergrid' style='width:95%;'>
		</div>
	</div>
</div>

<!--- ADD CONTEST --->

<div id='addContest' style='visibility:hidden'>
   <div id='ContestTabs'>
		<ul>
		    <li style="margin-left: 30px;">Basic Details</li>
		    <li>Select Question</li>
		    <li>Save Question</li>
		    
		</ul>
		<div id='secion1'>
			<div style='margin:10px'>
			Contest Name<input type='text' id='contestname'/>
			Contest Detail <input type='text' id='contestdetail'/>
			Contest Duration <input type='text' id='contestduration'/>
			<input type='button' id='sec1next' value='next'/>
			</div>
			
		</div>
		<div id='section2'>
		
			<div>
				<div id='subjectdropdown'>
				
				</div>
				<div id='qtncontainer'><div id='questiondropdown'></div></div>
			</div>
		</div>
		<div id='section3'>
		section 3
		</div>
	</div>
</div>

<!--- END OF ADD CONTEST --->
