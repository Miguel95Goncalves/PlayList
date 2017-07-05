package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Artista;

public class SArtista implements Logica{

	public Artista procurarArtista(int artista_id){
		for(Artista a : Logica.arArtitas){
			if(a.getArtista_id() == artista_id) return a;
		}
		
		return null;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return "/index.jsp";
	}

}
