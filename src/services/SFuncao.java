package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcao;
import sqlServer.FuncaoQuery;

public class SFuncao implements Logica{
	
	FuncaoQuery funcaoQuery = new FuncaoQuery();
	
	public void addFuncao(HttpServletRequest req){
		Logica.arFuncoes.add(new Funcao(funcaoQuery.addFuncao(req.getParameter("funcao")),req.getParameter("funcao")));
	}
	
	public Funcao procurarFuncao(int funcao_id) {
		for(Funcao f : Logica.arFuncoes) {
			if(f.getFuncao_id() == funcao_id) return f;
		}
		
		return null;
	}
	
	public void elimFuncao(int funcao_id) {
		for(int i=0; i < Logica.arFuncoes.size(); i++) {
			if(Logica.arFuncoes.get(i).getFuncao_id() == funcao_id) {
				Logica.arFuncoes.remove(i);
			}
		}
	}
	
	public void editarFuncao(int funcao_id, String funcao_nome) {
		for(int i=0; i < Logica.arFuncoes.size(); i++) {
			if(Logica.arFuncoes.get(i).getFuncao_id() == funcao_id) {
				Logica.arFuncoes.get(i).setFuncao_descricao(funcao_nome);
			}
		}
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		if(req.getParameter("acao").equals("addFuncao")){
			addFuncao(req);
			
		}else if(req.getParameter("acao").equals("procurarFuncao")){
			
			req.setAttribute("funcao_id", procurarFuncao(Integer.parseInt(req.getParameter("editFuncao_id"))).getFuncao_id());
			req.setAttribute("funcao_nome", procurarFuncao(Integer.parseInt(req.getParameter("editFuncao_id"))).getFuncao_descricao());
			
		}else if(req.getParameter("acao").equals("elimFuncao")) {
			elimFuncao(Integer.parseInt(req.getParameter("elimFuncao_id")));
			
		}else if(req.getParameter("acao").equals("EditarFuncao")){
			editarFuncao(Integer.parseInt(req.getParameter("funcao_id")), req.getParameter("nova_funcao"));
		}
	
		req.setAttribute("listasFuncao", Logica.arFuncoes);
		return "/index.jsp";
		
	}
}
