<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	HttpSession sessao = request.getSession(true);
	
	if(sessao.getAttribute("user_id") == null){
	%>
	<form method="post" action="Handler">
		<input type="hidden" name="logica" value="SUser">
		<input type="hidden" name="acao" value="login">
		<input type="email" name="user_mail" placeholder="E-mail">
		<input type="password" name="user_pass" placeholder="Password">
		<input type="submit" value=Login>
	</form>
	<%}else{out.append("SESSÃO INICIADA");%>
	<button id="logout" onClick="">Logout</button>
	<%} %>
</body>
</html>