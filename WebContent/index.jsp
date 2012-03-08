<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Certificate for Blinds</title>
    <meta name="keywords" content="Snakes" />
    <meta name="description" content="A project of TGMC" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/colorbox.css" rel="stylesheet" />
    <link href="css/templatemo_style1.css" rel="stylesheet" type="text/css" />
    <link href="images/icon.ico" rel="icon" type="image/x-icon" />
    <link href="css/pascal/pascal.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="css/nivo-slider.css" rel="stylesheet" type="text/css" media="screen" />
    <link href="css/slide.css" rel="stylesheet" type="text/css" media="screen" />
    <script src="js/jquery.js" type="text/javascript"></script>
    <script src="scripts/jquery-1.7.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.colorbox.js" type="text/javascript"></script>
    <script src="js/slide.js" type="text/javascript"></script>
    <script type="text/javascript">

        function clearText(field) {

            if (field.defaultValue == field.value) field.value = '';

            else if (field.value == '') field.value = field.defaultValue;

        }
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            //Examples of how to assign the ColorBox event to elements
            $(".group1").colorbox({ rel: 'group1' });
            $(".group2").colorbox({ rel: 'group2', transition: "fade" });
            $(".group3").colorbox({ rel: 'group3', transition: "none", width: "75%", height: "75%" });
            $(".group4").colorbox({ rel: 'group4', slideshow: true });
            $(".ajax").colorbox();
            $(".youtube").colorbox({ iframe: true, innerWidth: 425, innerHeight: 344 });
            $(".iframe").colorbox({ iframe: true, width: "80%", height: "80%" });
            $(".inline").colorbox({ inline: true, width: "50%" });
            $(".callbacks").colorbox({
                onOpen: function () { alert('onOpen: colorbox is about to open'); },
                onLoad: function () { alert('onLoad: colorbox has started to load the targeted content'); },
                onComplete: function () { alert('onComplete: colorbox has displayed the loaded content'); },
                onCleanup: function () { alert('onCleanup: colorbox has begun the close process'); },
                onClosed: function () { alert('onClosed: colorbox has completely closed'); }
            });

            //Example of preserving a JavaScript event for inline calls.
            $("#click").click(function () {
                $('#click').css({ "background-color": "#f00", "color": "#fff", "cursor": "inherit" }).text("Open this window again and this message will still be here.");
                return false;
            });
        });
    </script>
    <script type="text/javascript" src="js/jquery.bgpos.js"></script>
    <script type="text/javascript">

        $(function () {
            $('#a a')
		.css({ backgroundPosition: "-20px 35px" })
		.mouseover(function () {
		    $(this).stop().animate({ backgroundPosition: "(-20px 94px)" }, { duration: 500 })
		})
		.mouseout(function () {
		    $(this).stop().animate({ backgroundPosition: "(40px 35px)" }, { duration: 200, complete: function () {
		        $(this).css({ backgroundPosition: "-20px 35px" })
		    }
		    })
		})
            $('#b a')
		.css({ backgroundPosition: "0 0" })
		.mouseover(function () {
		    $(this).stop().animate({ backgroundPosition: "(-150px 0)" }, { duration: 500 })
		})
		.mouseout(function () {
		    $(this).stop().animate({ backgroundPosition: "(-300px 0)" }, { duration: 200, complete: function () {
		        $(this).css({ backgroundPosition: "0 0" })
		    }
		    })
		})
            $('#c a')
		.css({ backgroundPosition: "0 0" })
		.mouseover(function () {
		    $(this).stop().animate({ backgroundPosition: "(0 -250px)" }, { duration: 500 })
		})
		.mouseout(function () {
		    $(this).stop().animate({ backgroundPosition: "(0 0)" }, { duration: 500 })
		})
            $('#d a')
		.css({ backgroundPosition: "0 0" })
		.mouseover(function () {
		    $(this).stop().animate({ backgroundPosition: "(0 -250px)" }, { duration: 500 })
		})
		.mouseout(function () {
		    $(this).stop().animate({ backgroundPosition: "(0 0)" }, { duration: 500 })
		})
        });
    </script>
    <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript">
    jQuery(window).load(function(){
        jQuery("#nivoslider-373").nivoSlider({
            effect:"sliceUpDown",
            slices:8,
            boxCols:8,
            boxRows:4,
            animSpeed:1000,
            pauseTime:3000,
            startSlide:0,
            directionNav:true,
            directionNavHide:true,
            controlNav:true,
            controlNavThumbs:false,
            controlNavThumbsFromRel:true,
        
        });
    });

    </script>
</head>
<body>
    <!-- Login -->
    <div id="toppanel">
        <div id="panel">
            <div class="content clearfix">
                <div class="left">
                    <h1>
                        Welcome to Certificate for Blind</h1>
                    <h2>
                        Feel Free to register yourself</h2>
                    <p class="grey">
                        Certificate for Blind is a wonderful platform providing knowledge, help and support to blind and partially sighted people of all ages.
                        They can get certified from here.  We listen, we understand, we act.
                        </p>
                    
                </div>
                <div class="left">
                    <form class="clearfix" action="LoginAuth" method="post">
                    <h1 class="padlock">
                        Member Login</h1>
                    <label class="grey" for="log">
                        Username:</label>
                    <input class="field" type="text" name="log" id="log" value="" size="23" />
                    <label class="grey" for="pwd">
                        Password:</label>
                    <input class="field" type="password" name="pwd" id="pwd" size="23" />
                    <label>
                        <input name="rememberme" id="rememberme" type="checkbox" checked="checked" value="forever" />
                        &nbsp;Remember me</label>
                    <div class="clear">
                    </div>
                    <input type="submit" name="submit" value="Login" class="bt_login" />
                    <a class="lost-pwd" href="#">Lost your password?</a>
                    </form>
                </div>
                <div class="left right">
                    <form action="SendMail" method="post">
                    <h1>
                        Not a member yet? Sign Up!</h1>
                    <label class="grey" for="signup">
                        Username:</label>
                    <input class="field" type="text" name="signup" id="signup" value="" size="23" />
                    <label class="grey" for="email">
                        Email:</label>
                    <input class="field" type="text" name="email" id="email" size="23" />
                    <label>
                        A password will be e-mailed to you.</label>
                    <input type="submit" name="submit" value="Register" class="bt_register" />
                    </form>
                </div>
            </div>
        </div>
        <!-- /login -->
        <!-- The tab on top -->
        <div class="tab">
            <ul class="login">
                <li class="left">&nbsp</li>
                <li>Hello Guest!</li>
                <li id="toggle"><a id="open" class="open" href="#">Log In | Register</a> <a id="close"
                    style="display: none;" class="close" href="#">Close Panel</a> </li>
                <li class="right">&nbsp;</li>
            </ul>
        </div>
        <!-- / top -->
    </div>
    <!--panel -->
    <div id="templatemo_site_title_bar_wrapper">
        <div id="site_title">
       
        
            <img alt="The Great Mind Challenge" height="90px" width="300px" align="left" 
                src="images/tgmc%20logo.png"/>
            <h1>
                <br />
                <br />
                <a href="#" target="_parent">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Certificate for blinds
                    <span>&nbsp;&nbsp;&nbsp;&nbsp;A project of The Great Mind Challenge : Devleoped by SNAKES</span></a>
            </h1>
        </div>
    </div>
    <!-- end of site title bar wrapper -->
    <div id="templatemo_banner_wrapper">
        <div id="templatemo_banner">
            <div id="wrapper">
                <a>&nbsp </a>
                <div class="slider-wrapper theme-pascal">
                    <div class="ribbon">
                    </div>
                    <div id="nivoslider-373" class="nivoSlider">
                        <img src="images/s1.jpg" alt="" />
                        <img src="images/s2.jpg" alt="" />
                        <img src="images/s3.jpg" alt="" title="#htmlcaption" />
                        <img src="images/s4.jpg" alt="" title="#htmlcaption" />
                        <img src="images/s5.jpg" alt="" title="#htmlcaption" />
                    </div>
                    <div id="nivoslider-373-caption-0" class="nivo-html-caption">
                        <strong>Alone we can do so little; together we can do so much.</strong>
                    </div>
                </div>
            </div>
            <script src="js/jquery.chili-2.2.js" type="text/javascript"></script>
            <script src="js/recipes.js" type="text/javascript"></script>
            <div class="cleaner">
            </div>
        </div>
    </div>
    <!-- end of templatemo_banner_wrapper -->
    <div id="templatemo_menu_wrapper">
        <div id="templatemo_menu">
            <ul id="a">
                <li><a href="Features.htm" class="iframe">Home</a></li>
                <li><a href="Features.htm" class="iframe">Exam</a></li>
                <li><a href="Features.htm" class="iframe">Advise</a></li>
                <li><a href="Features.htm" class="iframe">Forum</a></li>
                <li><a href="Features.htm" class="iframe">FAQ</a></li>
                <li><a href="Features.htm" class="iframe">Contact US</a></li>
            </ul>
        </div>
        <!-- end of menu -->
    </div>
    <!-- end of menu wrapper -->
    <div id="templatemo_content">
        <div id="main_column">
            <br />
            <br />
            <div class="cleaner">
            </div>
        </div>
        <!-- end of main column -->
        <div id="side_column">
            <br />
            <br />
        </div>
        <!-- end of side column -->
        <div class="cleaner">
        </div>
    </div>
    <!-- end of content -->
    <div id="templatemo_footer_wrapper">
        <div id="templatemo_footer">
            <ul class="footer_menu">
                <li><a href="#">Home</a></li>
                <li><a href="#">Snakes</a></li>
                <li><a href="#">Snakes</a></li>
                <li><a href="#">Snakes</a></li>
                <li><a href="#">Snakes</a></li>
            </ul>
        </div>
    </div>
    <!-- end of footer wrapper -->
</body>
</html>