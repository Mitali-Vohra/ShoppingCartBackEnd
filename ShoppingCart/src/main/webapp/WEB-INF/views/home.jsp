<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./Resources/bootstrap/css/bootstrap.min.css">
  <script src="./Resources/bootstrap/js/jquery.min.js"></script>
  <script src="./Resources/bootstrap/js/bootstrap.min.js"></script>
</head>
</head>
<body>
<h1><center>Shopping Cart Application</center></h1>
<h3><center>${msg}</center></h3>
<h3><center>${successMessage}</center></h3>
<h3><center>${errorMessage}</center></h3>
<h3>${loginMessage}</h3>
<hr>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${empty loginMessage}">
    <li><a href="login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li></c:if>
    <c:if test="${empty loginMessage}">
    <li><a href="register"><span class="glyphicon glyphicon-user"></span>Register</a></li></c:if>
    <c:if test="${not empty loginMessage}">
    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li></c:if>
    <c:if test="${not empty loginMessage}">
    <li><a href="mycart"><span class="glyphicon glyphicon-shopping-cart"></span>My-Cart</a></li></c:if>
  </div>
</nav>

<!-- <c:if test="${empty loginMessage}">
<a href="login">Login</a><br>
</c:if>

<c:if test="${empty loginMessage}">
<a href="register">Register</a><br>
</c:if>  -->

<c:if test="${not empty loginMessage}">
<a href="logout">Logout</a><br>
</c:if>

<c:if test="${not empty loginMessage}">
<a href="mycart">MyCart</a>
</c:if>

<c:if test="${UserClickedLogin==true}">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>

<c:if test="${not empty errorMessage}">
<jsp:include page="Login.jsp"></jsp:include>
</c:if>

<c:if test="${UserClickedRegister==true}">
<jsp:include page="Registeration.jsp"></jsp:include>
</c:if>
</body>
</html>