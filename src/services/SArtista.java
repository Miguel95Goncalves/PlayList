package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import model.Artista;
import sqlServer.ArtistaQuery;

public class SArtista implements Logica{

	ArtistaQuery artistaQuery = new ArtistaQuery();
	
	public void addArtista(int artista_id, String artista_nome) {
		Logica.arArtistas.add(new Artista(artista_id,artista_nome));
	}
	
	public Artista procurarArtista(int artista_id){
		for(Artista a : Logica.arArtistas){
			if(a.getArtista_id() == artista_id) return a;
		}
		
		return null;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getParameter("acao").equals("addArtista")){ //SIGNIFICA QUE DE FATO O NICK NAO ESTA REPETIDO

				addArtista(artistaQuery.addArtista(req.getParameter("name_artista")),req.getParameter("name_artista"));
				
			}else{
				
			}
		
			req.setAttribute("listaArtista", Logica.arArtistas);
					
			return "index.jsp";
		}
}
