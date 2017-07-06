<h1 class="page-header">Editar Funcao</h1>
<form method="POST" action="Handler?pag=funcao">
	<fieldset title="Editar Funcao">
		<div class="form-group">
			<label>Nome:
			<input class="form-control" type="text" name="nova_funcao" id="nova_funcao" value='<%=request.getAttribute("funcao_nome")%>'>>
		</div>
		<div class="form-group">
			<input type="hidden" name="logica" value="SFuncao">
			<input type="hidden" name="acao" value="EditarFuncao">
			<input type="hidden" name="funcao_id" value='<%=request.getAttribute("funcao_id")%>'>
			<input class="btn btn-success" type="submit" value="Editar" name="editar">
		</div>
	</fieldset>
</form>