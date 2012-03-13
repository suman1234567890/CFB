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
    function  abcd()
    {
    
                    var theme = 'classic';
                    var url = "../../showSubjects.txt"; 
                   // var url = "showSubjects.txt";
				//var url='customers.txt';
				var source =

                {

                    datatype: "json",

                    datafields: [

                        { name: 'SubjectName' },

                        { name: 'SubjectId' }

                    ],

                    id: 'id',

                    url: url

                };

                var dataAdapter = new $.jqx.dataAdapter(source);



                // Create a jqxListBox
                var source1=null;
                document.getElementById('section2').innerHTML="<div style='width:95%'><div id='subjectdropdown' style='width:30%;float:left'></div><div id='qtncontainer' style='width:30%;float:left'></div><div id='finallist' style='float:right;width:30%'></div><div style='float:right;width:10%;margin-top:10%'><input type='button' id='addQues' value='Add'/></div></div><div style='float:right'><input type='text' id='sec2next' value='Next'/></div>";
				$("#addQues").jqxButton({width:50,height:25,theme:theme});
				$("#sec2next").jqxButton({width:50,height:25,theme:theme});
				$("#addQues").bind('click',function(){
					var selectedItems=$('#questiondropdown').jqxListBox('selectedIndexes');
					alert(selectedItems.length);
					count=selectedItems.length;
                	while (count) {
                   count--;
                 	if (typeof selectedItems[count] !== 'undefined' &&
                             selectedItems[count] !== -1) {
                   //$("#finallist").jqxListBox('addItem', source1[selectedItems[count]]);
                   var temp=$("#questiondropdown").jqxListBox('getItem', selectedItems[count] );
                   $("#finallist").jqxListBox('addItem',temp.label);
                   alert(temp.label);
                   }
                }
					
				});
				$('#sec2next').bind('click',function(){
					$('#jqxTabs').jqxTabs({ selectedItem: 2 }); 
					document.getElementById('section3').innerHTML="<div id='final'></div>";
					var sec3={};
					$("#final").jqxListBox({ source: sec3, width: 250, height: 250, theme: theme });
					var selectedItems=$('#finallist').jqxListBox('getItems');
					alert(selectedItems.length);
					count=selectedItems.length;
                	while (count) {
                   		count--;
                 		if (typeof selectedItems[count] !== 'undefined' &&
                        selectedItems[count] !== -1) {
                   			//$("#finallist").jqxListBox('addItem', source1[selectedItems[count]]);
                   		var temp=$("#finallist").jqxListBox('getItem', count );
                   		$("#final").jqxListBox('addItem',temp);
                   		alert(temp.value);
                   		}
                   	}
				
				});
				
				$('#sec1next').jqxButton({width:50,height:25,theme:theme});
				
				$('#sec1next').bind('click',function(){
				$('#jqxTabs').jqxTabs({ selectedItem: 1 }); 
				
				});
				
				var sou={};
				$("#finallist").jqxListBox({ source: sou, displayMember: "SubjectName", valueMember: "SubjectId", width: 250, height: 250, theme: theme });
                $("#subjectdropdown").jqxListBox({ source: dataAdapter, displayMember: "SubjectName", valueMember: "SubjectId", width: 200, height: 250, theme: theme });
                
                $("#subjectdropdown").bind('select', function (event) {
					
                    if (event.args) {
                    	
						document.getElementById('qtncontainer').innerHTML="<div style='float:left' id='questiondropdown'></div>";
                        var item = event.args.item;

                        if (item) {
                        	
							var questnurl='../../showQuestion.txt?subid='+item.value;
							// alert("mthodcalled"+questnurl);
							
							
							
							source1 =

				                {
				
				                    datatype: "json",
				
				                    datafields: [
				
				                        { name: 'question' },
				
				                        { name: 'questionid' }
				
				                    ],
				
				                    id: 'id',
				
				                    url: questnurl
				
				                };
				
				                var dataAdapter = new $.jqx.dataAdapter(source1);
							
                            	
                            	$("#questiondropdown").jqxListBox({ source: dataAdapter, displayMember: "question", valueMember: "questionid", width: 250, height: 250, theme: theme,multiple: true });
                
                				

                            

                            
                        }

                    }

                });
                
                                
    		$('#ContestTabs').jqxTabs({ width: 850, height: 500, position: 'top', theme: 'classic' ,animationType: 'fade'});
   			$('#addContest').jqxWindow({ maxHeight: 400, maxWidth: 900, minHeight: 200, minWidth: 200, height: 510, width: 910, theme: 'classic' });
                    
    
    }
    </script>
</head>
<body>
<input type='button' value='start' onclick="abcd()"/>
<div id='addContest'>
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
</body>
</html>