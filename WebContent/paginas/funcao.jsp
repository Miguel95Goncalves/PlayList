<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList, model.Funcao, services.Logica"%>
<h1 class="page-header">
	Funcao
</h1>
<h3><a href="Handler?pag=addFuncao"><i class="fa fa-plus-circle"></i> Inserir </a></h3>
<div class="table-responsive">
    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>Funcao</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
        </thead>
        <tbody>
        	<% 
	            ArrayList listaFuncao = (ArrayList) request.getAttribute("ListaFuncao");	
	          		
	            	for(int i = 0; i < listaFuncao.size(); i++){
	            		
	            		Funcao funcao = (Funcao) listaFuncao.get(i);
							out.append("<tr><td>" + funcao.getFuncao_descricao() + "</td>"
									
									+ "<td><form action='Handler?pag=editarFuncao' method='POST'>"
									+ "<input type='hidden' name='logica' value='SFuncao'>"
									+ "<input type='hidden' name='acao' value='procurarFuncao'>"
									+ "<input type='hidden' name='editFuncao_id' value='"+ funcao. getFuncao_id() +"'>"
									+ "<input class='btn btn-danger' type='submit' value='Editar' name='Editar'>"
									+ "</form></td>"
									
									+ "<td><form action='Handler?pag=funcao' method='POST'>"
									+ "<input type='hidden' name='logica' value='SFuncao'>"
									+ "<input type='hidden' name='acao' value='elimFuncao'>"
									+ "<input type='hidden' name='elimFuncao_id' value='"+ funcao.getFuncao_id() +"'>"
									+ "<input class='btn btn-danger' type='submit' value='Eliminar' name='eliminar'>"
									+ "</form></td>");
		
				}
            %>
        </tbody>
    </table>
</div>