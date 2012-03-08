$(document).ready(function () {
            $("span.alone").css({
                'padding': '5px 20px',
                'font-size': '16px'
            });

            $("span.alone").styledButton({
                'orientation': 'alone',
                'action': function () {
                	
                    
                },
                'display': 'block'
            });
            $("span.add").styledButton({
                'orientation': 'alone',
                'action': function () {
                	tb_remove();
                	$.post('../subject',{'subject': document.getElementById('subjectname').value , 'subjectdetail' : document.getElementById('subjectdetail').value},function(){
                    $("#table").addRow({
                        newRow: "<tr style='height:70px'><td>"+document.getElementById('subjectname').value+"</td><td>30.3</td><td>40.5</td><td>63.5</td><td>42.3</td></tr>"
                    });
                    $('#table tr td:not(:last-child)').addClass("rounded");
                    });
                },
                'display': 'block'
            });
        });
        var i=0;
        function generateRow() {
            
            var d = document.getElementById("snakes-addquestion");
            d.innerHTML += "&nbsp;<input type='checkbox' id='sumon"+i+"' />Option : <input type='text' style='width: 230px;' id='option" + i + "'>";
            addOption();
            

        }
        
        function addOption() {
            i = i + 1;
            //alert(i);
        }
        function checkAll()
        {
        	var p=0;
        	var q=0;
        	var flag1=0;
        	var flag2=1;
        	if(document.getElementById("Text1").value=="" && document.getElementById("Text2").value=="" && document.getElementById("Text3").value=="")
        	{
        	   flag2=0;
        	}
        	for( var s=0;s<i;s++)
        	{
        	    if (document.getElementById("sumon"+s).checked==true)
        	    {
        	       flag1=1;
        	    }
        	    if(document.getElementById("option"+s).value=="")
        	    {
        	       flag2=0;
        	    }
        	 }
        	    if(flag1==1 && flag2==1)
        	       return 1;
        	    else 
        	       return 0;
        	
        }
        function saveData() {
            var data = "";
            var poolid="1";
            var chck=""
            
                for (var j = 0; j < i; j++) {
                var temp = "option" + j
                data += document.getElementById(temp).value+ "," ;
                
                if(document.getElementById("sumon"+j).checked==true)
                {
                chck+=j+",";
                }
            }
            //data += " CorrectMarks: " + document.getElementById("Text2").value+" NegativeMarks: "+document.getElementById("Text2").value;
            alert(chck);


            var url = "../addQuestion"
            if(checkAll()==1)
            {
            $.post(url,{poolid: poolid,Question : document.getElementById("Text1").value,noofoption: i,option : data, correctmarks : document.getElementById("Text2").value,negetivemarks: document.getElementById("Text2").value,coroptn: chck});
            }
            else
            {
               alert("fill all");
            }
        }
      
		 
        $(document).ready(function () {

            $("#addRowDemo1").click(function () {
                $("#table").addRow({
                    newRow: "<tr style='height:70px'><td>"+document.getElementById('subjectname').value+"</td><td>Add</td><td>View</td><td>Result</td><td>42.3</td></tr>"
                });
                $('#table tr td:not(:last-child)').addClass("rounded");
            });
            $("#removeRowDemo1").click(function () {
                $("#table").removeRow({});
            });
                       

            $('#table tr td:not(:last-child)').addClass("rounded");
            
        });
        