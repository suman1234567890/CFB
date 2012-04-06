var theme = 'classic';
var subid=0;
var totaloption=0;
$(document).ready(function () {

    switch (theme) {
        case 'shinyblack':
            $($.find('.megamenu-ul li a:link')).css('color', '#ccc');
            $($.find('.megamenu-ul li a:hover')).css('color', '#ddd');
            $($.find('.megamenu-ul li a:visited')).css('color', '#eee');
            $($.find('.jqx-menuitem-header')).css('color', '#fff');
            break;
        default:
            $($.find('.megamenu-ul')).css('color', '#ccc');
            $($.find('.megamenu-ul')).css('color', '#ddd');
            $($.find('.megamenu-ul')).css('color', '#eee');
            $($.find('.jqx-menuitem-header')).css('color', '#2d628a');
            break;
    }
    // Create a jqxMenu
    $("#jqxMenu").jqxMenu({ width: '100%', height: '60px', autoOpen: false, autoCloseOnMouseLeave: false, showTopLevelArrows: true, theme: theme });
    $("#jqxMenu").css('visibility', 'visible');
    $(".buyonline").jqxLinkButton({ width: 150, theme: theme });
    $(".jqx-menu-search").jqxButton({ width: 60, theme: theme });
    $("#jqxNavigationBar").jqxNavigationBar({ width: 300, expandMode: 'multiple', expandedIndexes: [2, 3], theme: theme });
    $("#clickonadd").css('visibility', 'hidden');
    $("#save").jqxButton({ width: 60, theme: theme });
    $("#reset").jqxButton({ width: 60, theme: theme });
    $('#containerQuestion').jqxWindow({ maxHeight: 400, maxWidth: 700, minHeight: 30, minWidth: 250, height: 400, width:600,
        theme: theme, resizable: false, isModal: true, modalOpacity: 0.3,
        cancelButton: $('#reset')
    });
    hideQuestionContainer();
    $("#save").bind('click',function(){
    	document.getElementById('questionremarks').innerHTML="Data Uploading...";
        var i =0;
        var option="";
        var check="";
    	var question=document.getElementById('question').value;
    	var cmarks=document.getElementById('correctmarks').value;
    	var nmarks=document.getElementById('negativemarks').value;
    	for(i=0;i<totaloption;i++)
    	{
    		option+=document.getElementById('option'+i).value+",";
    		if(document.getElementById('coroption'+i).checked)
    		{
    			check+=i+",";
    		}
    		
    	}
    	if(option=="" || question==""||cmarks=="" || nmarks=="" || check=="")
    	{
    		alert("Fill the form");
    	}
    	$.post('../../addQuestion',{sub:subid,qtn: question,cm:cmarks,nm:nmarks,opt:option,cor:check},function(){document.getElementById('questionremarks').innerHTML="Successfully Data Saved";});
    	alert('you result'+question+cmarks+nmarks+option);
    });
	
    


    
    createElements(theme);



    $('#jqxMenu').bind('itemclick', function (event) {
        var args = event.args;
        var text = $(args).text().length;

        if (text == 61) {

            $('#elements1').jqxGrid('destroy');
            document.getElementById('elements').innerHTML = "<div id='elements1'></div><div align='center' > <input type='button' value='Add Contest' id='AddContestContainerButton'/></div>";

            $("#AddContestContainerButton").jqxButton({ width: 100, theme: theme });
            $("#AddContestContainerButton").bind('click',function(){
            	showAddContest();
            });
            
            $("#addContestContainer").css('visibility', 'visible');
            addContest();

        }
        if (text == 62) {
            alert("This is subject");
            $('#elements1').jqxGrid('destroy');
            document.getElementById('elements').innerHTML = "<div id='elements1'></div><div align='center' > <input type='button' value='Add Subject' id='showWindowButton'/></div>";

            $("#showWindowButton").jqxButton({ width: 100, theme: theme });
			addEventListener();



            $("#clickonadd").css('visibility', 'visible');
            addSubject();

        }
        if (text == 63) {
            alert("This is View Users");
            document.getElementById('elements').innerHTML = "<div id='elements1'></div>";
            viewUser();
            

        }
        if (text == 66) {
            alert("This is My Candidate");
            document.getElementById('elements').innerHTML = "<div id='elements1'></div><div id='buttonnt'><input type='button' id='buttoncont' value='add Candidate'/>'</div><div id='msgcont'></div>";
            MyCandidate();
            

        }
        alert(text);
    });   //////
});
function MyCandidate()
{
	 var url = "../../mycandidate.xml";
    var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'CandidateName' },
                    
                    { name: 'CandidateId'},
                    
               ],
                root: "channel",
                record: "item",
                url: url
            };

            var linkrenderer = function (row, column, value) {
                if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
                var format = { target: '"_blank"' };
                //var html = $.jqx.dataFormat.formatlink(value, format);
                var html = "<a href='#' onclick='showWin()'>"+value+"</a>";
                return html;
            }

    // Create jqxGrid.
    $("#elements1").jqxGrid(
            {
                width: 830,
                height:405,
                source: source,
                theme: theme,
                sortable: true,
                pageable: true,
                autoheight: true,
                columns: [
                  { text: 'Candidate Name', datafield: 'CandidateName', width: 630},
                  { text: 'Result', datafield: 'CandidateId', width: 100 },
                  { text: 'Delete', datafield: 'CandidateId', width: 100, }
                  
               ]
            });
            $("#buttoncont").jqxButton({ width: 100, theme: theme });
            $("#buttoncont").bind('click',function(){
            		document.getElementById('msgcont').innerHTML="<div id='tablecont'><div>Add Candidate</div><div><table><tr><td>Name:</td><td><input type='text' id='name'/></td></tr><tr><td>Phone Number:</td><td><input type='text' id='pno'/></td></tr><tr><td>Date OF Birth:</td><td><input type='text' id='DOB'/></td></tr></table><div><input type='button' id='sub' value='submi'/></div></div></div>";
            		
            		
            
            $('#tablecont').jqxWindow({ maxHeight: 200, maxWidth: 280, minHeight: 30, minWidth: 250, height: 200, width: 270,
        theme: theme, resizable: false, isModal: true, modalOpacity: 0.3,
        
   			 });
   			 $('#tablecont').jqxWindow('show');
   			 $("#sub").jqxButton({ width: 80, theme: theme });
   			 
   			 });
	
}
function addContest() {

    
    var url = "../../showContest.xml";
    var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'ContestName' },
                    { name: 'Duration' },
                    { name: 'ContestId'},
                    
               ],
                root: "channel",
                record: "item",
                url: url
            };

            var linkrenderer = function (row, column, value) {
                if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
                var format = { target: '"_blank"' };
                //var html = $.jqx.dataFormat.formatlink(value, format);
                var html = "<a href='#' onclick='showWin()'>"+value+"</a>";
                return html;
            }

    // Create jqxGrid.
    $("#elements1").jqxGrid(
            {
                width: 830,
                height:405,
                source: source,
                theme: theme,
                sortable: true,
                pageable: true,
                autoheight: true,
                columns: [
                  { text: 'Contests', datafield: 'ContestName', width: 350},
                  { text: 'Duration', datafield: 'Duration', width: 100 },
                  { text: 'Add', datafield: 'ContestId', width: 100, },
                  { text: 'View', datafield: 'ContestId', width: 150, },
                  { text: 'Download', datafield: 'ContestId', width: 100 }
               ]
            });



}
function viewUser() {

    
    var url = "../../showUser.xml";
    var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'UserName' },
                    { name: 'Category' },
                    { name: 'Uid'},
                    
               ],
                root: "channel",
                record: "item",
                url: url
            };

            var linkrenderer = function (row, column, value) {
                if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
                var format = { target: '"_blank"' };
                //var html = $.jqx.dataFormat.formatlink(value, format);
                
                if(value=="0")
                {
                	return "Admin";
                }
                if(value=="1")
                {
                	return "Faculty";
                }
                if(value=="2")
                {
                	return "Guest";
                }
                if(value=="3")
                {
                	return "Candidate";
                }
                
                var html = "guest";
                return html;
            }

    // Create jqxGrid.
    $("#elements1").jqxGrid(
            {
                width: 830,
                height:405,
                source: source,
                theme: theme,
                sortable: true,
                pageable: true,
                autoheight: true,
                columns: [
                  { text: 'Category', datafield: 'Category', width: 100,cellsrenderer: linkrenderer },
                  { text: 'Delete', datafield: 'Uid', width: 100 }
               ]
            });



}

function addSubject() {

    
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

            var linkrenderer = function (row, column, value) {
                if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
                var format = { target: '"_blank"' };
                //var html = $.jqx.dataFormat.formatlink(value, format);
                //var html = "<a href='#' onclick='showAddContest()'>"+value+"</a>";
                var html = "<a href='#' onclick='showAddContest()'>"+value+"</a>";
                return html;
            }
            var view1 = function (row, column, value) {
                if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
                var format = { target: '"_blank"' };
                //var html = $.jqx.dataFormat.formatlink(value, format);
                //var html = "<a href='#' onclick='showAddContest()'>"+value+"</a>";
                
                var html = "<a href='#' onclick='showQuestionContainer("+value+")'>ADD</a>";
                return html;
            }
            
            var edit=function(row,column,value){
            	if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
            	var html="<a href='#' onclick='ContestView("+value+")'>View</a>"
            	return html;
            }
            var deleteid=function(row,column,value){
            	if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
            	var html="<a href='#' onclick='ContestDeleteRow("+value+")'>delete</a>"
            	return html;
            }
            var download=function(row,column,value){
            	if (value.indexOf('#') != -1) {
                    value = value.substring(0, value.indexOf('#'));
                }
            	var html="<a href='#' onclick='ContestDownload("+value+")'>+Download</a>"
            	return html;
            }

    // Create jqxGrid.
    $("#elements1").jqxGrid(
            {
                width: 830,
                height:405,
                source: source,
                theme: theme,
                sortable: true,
                pageable: true,
                autoheight: true,
                columns: [
                  { text: 'Subject', datafield: 'SubjectName', width: 430, cellsrenderer: linkrenderer },
                  { text: 'View', datafield: 'SubjectId', width: 100 ,cellsrenderer: view1,cellsalign:'center'},
                  { text: 'Add', datafield: 'SubjectId', width: 100,cellsrenderer: edit },
                  { text: 'Delete', datafield: 'SubjectId', width: 100,cellsrenderer:deleteid },
                  { text: 'Download', datafield: 'SubjectId', width: 100,cellsrenderer:download },
                  
               ]
            });
            



}

function createElements(theme) {
    $('#ok').jqxButton({ theme: theme, height: '25px', width: '65px' });
    $('#cancel').jqxButton({ theme: theme, height: '25px', width: '65px' });
    
    $('#eventWindow').jqxWindow({ maxHeight: 150, maxWidth: 280, minHeight: 30, minWidth: 250, height: 145, width: 270,
        theme: theme, resizable: false, isModal: true, modalOpacity: 0.3,
        okButton: $('#ok'), cancelButton: $('#cancel')
    });
    $('#eventWindow').jqxWindow('hide');
    
    $('#ok').bind('click',function(){
    $.post('../../addSubject',{subjectname: document.getElementById('subname').value, subjectdetail:document.getElementById('subdetail').value});
    });
    
    
  
 
    
}
function addEventListener() {
    $('#showWindowButton').mousedown(function () {
        $('#eventWindow').jqxWindow('show');
    });
}
function showWin() {
    $('#eventWindow').jqxWindow('show');
}
function showAddContest(){
    //$('#addContestContainer').jqxWindow('show');
    abcd();
}
function addOptionToForm()
{
	
	document.getElementById('optionContainer').innerHTML+="<div style='margin:10px; width:100%;'><input type='checkbox' id='coroption"+totaloption+"'/><input type='text' value='option' id='option"+totaloption+"' style='width:80%'/></div>"
	totaloption+=1;
}
function showQuestionContainer(id){
	subid=id;
    $('#containerQuestion').jqxWindow('show');
}
function hideQuestionContainer()
{
    $('#containerQuestion').jqxWindow('hide');

}
function ContestView(id)
{
	alert("method called");
	subid=id;
	var sourceurl="../../viewQuestion.xml?subid="+subid;
	document.getElementById('viewquestioncontainer').innerHTML="<div id='viewquestioncontainergrid' style='width:95%;'></div><div><input type='button' value='OK' id='viewok'/></div>";
	$('#viewok').jqxButton({width: '150', height: '25', theme: theme});
	$('#viewquestion').jqxWindow('show');
	 var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'question' },
                    { name: 'cmark' },
                    { name: 'nmark' },
                    
               ],
                root: "channel",
                record: "item",
                url: sourceurl
            };
            $("#viewquestioncontainergrid").jqxGrid(
            {
                width: 700,
                height:405,
                source: source,
                theme: theme,
                sortable: true,
                pageable: true,
                autoheight: true,
                columns: [
                  { text: 'Question', datafield: 'question', width: 450 },
                  { text: 'Correctmark', datafield: 'cmark', width: 100 },
                  { text: 'Negativemark', datafield: 'nmark', width: 150 }
                  
               ]
            });
            $('#viewquestion').jqxWindow({ maxHeight: 550, maxWidth: 880, minHeight: 30, minWidth: 250, height: 445, width: 730,
        		theme: theme, resizable: false, isModal: true, modalOpacity: 0.3,
        
    		});
    		$("#viewok").bind('click', function () {
                    
                    $('#viewquestion').jqxWindow('hide');
                });
                
	
	
}
function ContestDeleteRow(id)
{
	$.post('../../deleteSubject',{subid:id},function()
	{
		alert("refreshing");
		$('#elements1').jqxGrid('refreshdata');
		
	});
}
function  abcd()
    {
    	$("#addContest").css('visibility', 'visible');
    
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
					$('#ContestTabs').jqxTabs({ selectedItem: 2 }); 
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
				$('#ContestTabs').jqxTabs({ selectedItem: 1 }); 
				
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