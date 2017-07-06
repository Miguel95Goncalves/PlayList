<%@page import="java.util.ArrayList" %>
<%@page import="model.User" %>

<div>
<form method="POST" action="Handler?pag=user">
	<fieldset title="Adicionar Funcionario">
		<div class="form-group">
			<label>Nome:</label>
 			<input type="text" class="form-control" name="user_name" id="name" placeholder="Nome">		
		</div>
		<div class="form-group">
			<label>Nickname:</label>
 			 <input type="text" class="form-control" name="user_nick" id="user_nick" placeholder="nickname">		
 			 <%if(request.getAttribute("NickExistente") != null){ %><label>Nick já existente!</label> <%} %>
		</div>
		<div class="form-group">
			<label>	Email:</label>
 			 <input type="email" class="form-control" name="nick_email" id="nick_email" placeholder="email">		
		</div>
		<div class="form-group">
		    <label>Password:</label>
		    <input type="text" class="form-control"  name="user_pass" id="user_pass" placeholder="password">
		</div>
		<div class="form-group">
			<input type="hidden" name="logica" id="logica" value="SUser">
			<input type="hidden" name="acao" id="acao" value="confirmNick">
			<input class="btn btn-success" type="submit"  value="Inserir" name="inserir">
		</div>
	</fieldset>
</form>

</div>