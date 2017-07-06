<%@page import="java.util.ArrayList" %>
<%@page import="model.User" %>

<div>
<form method="POST"  action="Handler?pag=addFuncao">
	<fieldset title="Adicionar Funcionario">
		<div class="form-group">
			<label>Funcao:</label>
 			<input type="text" class="form-control" name="funcao" id="funcao" placeholder="Funcao">		
		</div>
		<div class="form-group">
			<input type="hidden" name="logica" id="logica" value="SFuncao">
			<input type="hidden" name="acao" id="acao" value="addFuncao">
			<input class="btn btn-success" type="submit"  value="Inserir" name="inserir">
		</div>
	</fieldset>
</form>
</div>