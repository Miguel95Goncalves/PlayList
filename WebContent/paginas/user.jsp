<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList, model.User, services.Logica"%>
<h1 class="page-header">
    User
</h1>
<div class="table-responsive">
<h3><a href="Handler?pag=addUser"><i class="fa fa-plus-circle"></i>Inserir</a></h3>
    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Nick Name</th>
                <th>Email</th>
                <th>Eliminar</th>
            </tr>
        </thead>
        <tbody>
            <%
	            ArrayList listaUser = (ArrayList) request.getAttribute("listaUsers");	
	          		
	            	for(int i = 0; i < listaUser.size(); i++){
	            		
	            		User user = (User) listaUser.get(i);
							out.append("<tr><td>" + user.getUser_nome() + "</td>"
										+ "<td>" + user.getUser_mick() + "</td>"
										+ "<td>" + user.getUser_email() + "</td>"
						
										+ "<td><form action='Handler?pag=user' method='POST'>"
										+ "<input type='hidden' name='logica' value='SUser'>"
										+ "<input type='hidden' name='acao' value='elimUser'>"
										+ "<input type='hidden' name='user_id' value='"+ user.getUser_id() +"'>"
										+ "<input class='btn btn-danger' type='submit' value='Eliminar' name='Eliminar'>"
										+ "</form></td></tr>");
	
			}
		
            %>
        </tbody>
    </table>
</div>