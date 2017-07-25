
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Daily UI - Day 1 Sign In</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
    <form action ="Search_Serv" name="myform">
	<div class="container">
		<div class="top">
<!--			<h1 id="title" class="hidden" align = center>New Borrower Details:</h1>
                        <h2 id="title" class="hidden" align = center><span id="logo"><i><b>Fill all the details to successfully add the new borrower!</b></i></span></h2>-->
		</div>
		<div class="login-box animated fadeInDownBig">
			<div class="box-header">
				<h2>Search Results</h2>
			</div>
<!--                    <a href="./webpages/index.html" align = center><u>Back</u></a> 
                    <br/>-->
                    
                        <br/>
                                    <input type="text" name="search_key" class="form-control" placeholder="Enter Keywords here..." required>
                                    </br>
                    <button type="submit" class="btn btn-default btn-xl sr-button" >Search</button>
                    <br/>
			<br/>
                        <a href="./webpages/index.html" align = center><u>Back</u></a>
                        <hr>
                        
        <c:out value="${requestScope.number_of_result}"/> book/s found...
        <br>
        <hr>
        <c:forEach items="${requestScope.search_result}" var="result_search" varStatus="loop"> 
        Serial : <c:out value= "${loop.index + 1}" />
        <br/>
<!--        <img src="http://www.openisbn.com/cover/1558211853_72.jpg" alt="Mountain View" style="width:304px;height:228px;">-->
            <object data="http://covers.openlibrary.org/b/isbn/${result_search.isbn}-M.jpg" width=100 height=150>
            <img src="C:\Users\Vimal\Documents\NetBeansProjects\Library_cd\web\notfound.jpg" type="text/html" style="width:100px;height:150px;" />  
            </object>
    
        <br/>
        <b>Title : </b><c:out value="${result_search.title}" />
        <br/>
        <b>Author/s : </b><c:out value="${result_search.author}" />
        <br/>
        <b>ISBN : </b><c:out value="${result_search.isbn}" />
        <br/>
        <b><c:out value="${result_search.availability}" /></b> Copy Available
        <br/>
        <!--<button id="button" type="submit">Check Out</button>-->
        <hr>
</c:forEach>    
<!--			<a href="#"><p class="small">Forgot your password?</p></a>-->
		</div>
	</div>
</form>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#username').focus(function() {
		$('label[for="username"]').addClass('selected');
	});
	$('#username').blur(function() {
		$('label[for="username"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>
</body>
</html>