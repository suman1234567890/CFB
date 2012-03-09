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
	
    


    var wizard = (function () {

        //Adding event listeners
        var _addHandlers = function () {
            $('#usernameInput').keyup(function () {
                wizard.validate(true);
            });
            $('#usernameInput').change(function () {
                wizard.validate(true);
            });
            $('#usernameInput').change(function () {
                wizard.validate(true);
            });
            $('#passwordInput').keyup(function () {
                wizard.validate(true);
            });
            $('.nextButton').click(function () {
                wizard.validate(true);
                var selectedItems = $('#allquestion').jqxListBox('getItems');
                count = selectedItems.length;

                alert(count);

                $('#orderContainer').html('');
                while (count) {
                    count--;
                    /*if (typeof selectedItems[count] !== 'undefined' &&
                    selectedItems[count] !== -1) {
                    $('#orderContainer').prepend('<div style="width: 150px; height: 20px;">' + $('#allquestion').jqxListBox('getItems',count) +'</div>');
                    }*/
                    $('#orderContainer').prepend('<div style="width: 150px; height: 20px;">' + $('#allquestion').jqxListBox('getItem', count) + '</div>');
                }
                $('#jqxTabs').jqxTabs('next');
            });
            $('.backButton').click(function () {
                wizard.validate(true);
                $('#jqxTabs').jqxTabs('previous');
            });
            $('.addButton').click(function () {
                wizard.validate(true);
                var selectedItems = $('#products').jqxListBox('selectedIndexes'),
                        count = selectedItems.length;
                while (count) {
                    count--;
                    if (typeof selectedItems[count] !== 'undefined' &&
                                selectedItems[count] !== -1) {
                        $("#allquestion").jqxListBox('addItem', wizard.config.source[selectedItems[count]].html);
                    }
                }
            });
            $('.removeButton').click(function () {
                wizard.validate(true);
                var selectedItems = $('#allquestion').jqxListBox('selectedIndexes'),
                        count = selectedItems.length;
                while (count) {
                    count--;
                    if (typeof selectedItems[count] !== 'undefined' &&
                                selectedItems[count] !== -1) {

                        $("#allquestion").jqxListBox('removeAt', count);
                    }
                }
            });
            $('#acceptCheckBox').bind('change', function (event) {
                wizard.validate(true);
            });
            $('#allquestion').bind('change', function (event) {
                wizard.validate(true);
                var selectedItems = $('#allquestion').jqxListBox('getItems');
                count = selectedItems.length;

                alert(count);

                $('#orderContainer').html('');
                while (count) {
                    count--;
                    /*if (typeof selectedItems[count] !== 'undefined' &&
                    selectedItems[count] !== -1) {
                    $('#orderContainer').prepend('<div style="width: 150px; height: 20px;">' + $('#allquestion').jqxListBox('getItems',count) +'</div>');
                    }*/
                    $('#orderContainer').prepend('<div style="width: 150px; height: 20px;">' + $('#allquestion').jqxListBox('getItem', count) + '</div>');
                }
            });
            $('#products').bind('unselect', function (event) {
                wizard.validate(true);
            });
        };

        //Checking if any product have been selected
        var _isItemSelected = function (array) {
            var count = array.length;
            //alert(array.length);
            if (count === 0) {
                return false;
            }
            while (count) {
                count -= 1;
                if (array[count] !== -1 &&
                            typeof array[count] !== 'undefined') {
                    return true;
                }
            }
            return false;
        };

        return {

            //Listbox's source
            config: {
                source: [
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/numberinput.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxNumberInput</span></div>", title: 'jqxNumberInput' },
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/progressbar.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxProgressBar</span></div>", title: 'jqxProgressBar' },
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/calendar.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxCalendar</span></div>", title: 'jqxCalendar' },
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/button.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxButton</span></div>", title: 'jqxButton' },
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/dropdownlist.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxDropDownList</span></div>", title: 'jqxDropDownList' },
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/listbox.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxListBox</span></div>", title: 'jqxListBox' },
                            { html: "<div style='height: 20px; float: left;'><img style='float: left; margin-top: 2px; margin-right: 5px;' src='../../images/tooltip.png'/><span style='float: left; font-size: 13px; font-family: Verdana Arial;'>jqxTooltip</span></div>", title: 'jqxTooltip' }
                        ]

            },
            config1: {
                source: [
                            {}
                        ]

            },

            //Initializing the wizzard - creating all elements, adding event handlers and starting the validation
            init: function () {
                $('#jqxTabs').jqxTabs({ height: 400, width: 700, theme: theme, keyboardNavigation: false });
                $('#acceptCheckBox').jqxCheckBox({ width: 250, theme: theme });
                $('#nextButtonInfo').jqxButton({ width: 50, theme: theme });
                $('#nextButtonBasket').jqxButton({ width: 50, theme: theme });
                $('#addButton').jqxButton({ width: 50, theme: theme });
                $('#removeButton').jqxButton({ width: 50, theme: theme });
                $('#backButtonBasket').jqxButton({ width: 50, theme: theme });
                $('#backButtonReview').jqxButton({ width: 50, theme: theme });
                $("#products").jqxListBox({ source: this.config.source, width: '670px', height: '130px', theme: theme, multiple: true });
                $("#allquestion").jqxListBox({ source: this.config1.source, width: '670px', height: '130px', theme: theme, multiple: true });
                _addHandlers();
                this.validate();
                this.showHint('Validation hints.');
            },

            //Validating all wizard tabs
            validate: function (notify) {
                if (!this.firstTab(notify)) {
                    $('#jqxTabs').jqxTabs('disableAt', 1);
                    $('#jqxTabs').jqxTabs('disableAt', 2);
                    return;
                } else {
                    $('#jqxTabs').jqxTabs('enableAt', 1);
                }
                if (!this.secondTab(notify)) {
                    $('#jqxTabs').jqxTabs('disableAt', 2);
                    return;
                } else {
                    $('#jqxTabs').jqxTabs('enableAt', 2);
                }
            },

            //Displaying message to the user
            showHint: function (message, selector) {
                if (typeof selector === 'undefined') {
                    selector = '.hint';
                }
                if (message === '') {
                    message = 'You can continue.';
                }
                $(selector).html('<strong>' + message + '</strong>');
            },

            //Validating the first tab
            firstTab: function (notify) {
                var username = $('#usernameInput').val(),
                            password = $('#passwordInput').val(),
                            message = '';
                if (username.length < 3) {
                    message += 'You have to enter valid Contest Name. <br />';
                }
                if (password.length < 3) {
                    message += 'You have to enter valid Contest Detail. <br />';
                }
                if (!$('#acceptCheckBox').jqxCheckBox('checked')) {
                    message += 'You have to accept the terms. <br />';
                }
                if (message !== '') {
                    if (notify) {
                        this.showHint(message, '#hintSection');
                    }
                    return false;
                }
                this.showHint('You can continue.', '#hintSection');
                return true;
            },

            //Validating the second tab
            secondTab: function () {
                var products = $('#products').jqxListBox('selectedIndex');
                if (!_isItemSelected($('#products').jqxListBox('selectedIndexes'))) {
                    this.showHint('You have to add at least one item.', '#hintBasket');
                    return false;
                } else {
                    this.showHint('You can continue.', '#hintBasket');
                }
                return true;
            }
        }
    } ());

    //Initializing the wizard
    wizard.init();



    createElements(theme);



    $('#jqxMenu').bind('itemclick', function (event) {
        var args = event.args;
        var text = $(args).text().length;

        if (text == 61) {

            $('#elements1').jqxGrid('destroy');
            document.getElementById('elements').innerHTML = "<div id='elements1'></div><div align='center' > <input type='button' value='Add Contest' id='AddContestContainerButton'/></div>";

            $("#AddContestContainerButton").jqxButton({ width: 100, theme: theme });
            
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
        alert(text);
    });   //////
});

function addContest() {

    
    var url = "../../pages/faculty/feed.xml";
    var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'title' },
                    { name: 'link' },
                    { name: 'pubDate', type: 'date' },
                    { name: 'creator', map: 'dc\\:creator' },
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
                  { text: 'Subjects', datafield: 'link', width: 450, cellsrenderer: linkrenderer },
                  { text: 'View', datafield: 'title', width: 100 },
                  { text: 'Edit', datafield: 'pubDate', width: 150, cellsformat: "D" },
                  { text: 'Download', datafield: 'creator', width: 100 }
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
    $('#addContestContainer').jqxWindow({ maxHeight: 550, maxWidth: 900, minHeight: 30, minWidth: 250, height: 500, width: 900,
        theme: theme, resizable: false, isModal: true, modalOpacity: 0.3,
        okButton: $('#ok'), cancelButton: $('#cancel')
    });
    $('#eventWindow').jqxWindow({ maxHeight: 150, maxWidth: 280, minHeight: 30, minWidth: 250, height: 145, width: 270,
        theme: theme, resizable: false, isModal: true, modalOpacity: 0.3,
        okButton: $('#ok'), cancelButton: $('#cancel')
    });
    $('#eventWindow').jqxWindow('hide');
    $('#addContestContainer').jqxWindow('hide');
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
    $('#addContestContainer').jqxWindow('show');
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
	subid=id;
	var sourceurl="../../viewQuestion?"+subid;
	 var source =
            {
                datatype: "xml",
                datafields: [
                    { name: 'SubjectName' },
                    { name: 'SubjectId' },
                    
               ],
                root: "channel",
                record: "item",
                url: sourceurl
            };
	
	
}
