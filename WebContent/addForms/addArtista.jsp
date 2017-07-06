<%@page import="java.util.ArrayList" %>
<%@page import="model.User" %>

<div>
<form method="POST"  action="Handler?pag=addArtista" >
	<fieldset title="Adicionar Funcionario">
		<div class="form-group">
			<label>Nome do artista:</label>
 			<input type="text" class="form-control" name="name_artista" id="name_artista" placeholder="Nome">		
		</div>
		<div class="form-group">
			<input type="hidden" name="logica" id="logica" value="SArtista">
			<input type="hidden" name="acao" id="acao" value="addArtista">
			<input class="btn btn-success" type="submit"  value="Inserir" name="inserir">
		</div>
	</fieldset>
</form>

</div>