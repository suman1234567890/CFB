<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    <script type="text/javascript">
    function abc(){
    theme='classic';
     var url = "../../showSubject.xml";
    var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'SubjectName' },
                    { name: 'SubjectId' },
                    
               ],
                root: "channel",
                record: "item",
                url: url
            };
            
      var dataAdapter = new $.jqx.dataAdapter(source);      
    $("#subjectdropdown").jqxDropDownList({ source: dataAdapter, width: '200', height: '25', theme: theme,displayMember: 'SubjectName' });
    
    $('#jqxTabs').jqxTabs({ width: 580, height: 200, position: 'top', theme: 'classic' ,animationType: 'fade'});
    $('#jqxWidget').jqxWindow({ maxHeight: 400, maxWidth: 700, minHeight: 200, minWidth: 200, height: 300, width: 600, theme: 'classic' });
   
    }
    </script>
</head>
<body>
<input type='button' value='start' onclick="abc()"/>
<div id='jqxWidget'>
   <div id='jqxTabs'>
		<ul>
		    <li style="margin-left: 30px;">Node.js</li>
		    <li>JavaServer Pages</li>
		    <li>Active Server Pages</li>
		    
		</ul>
		<div id='secion1'>
			<div style='margin:10px'>
			Contest Name<input type='text' id='contestname'/>
			Contest Detail <input type='text' id='contestdetail'/>
			Contest Duration <input type='text' id='contestduration'/>
			</div>
			<div>
				<div id='subjectdropdown'>
				
				</div>
			</div>
		</div>
		<div>
		
		section 2
		</div>
		<div>
		section 3
		</div>
	</div>
</div>
</body>
</html>