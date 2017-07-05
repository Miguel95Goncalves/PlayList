package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Genero;

public class SGenero implements Logica {

	public Genero procurarGenero(int genero_id){
		for(Genero g : Logica.arGeneros){
			if(g.getGenero_id() == genero_id) return g;
		}
		
		return null;
	}
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return null;
	}

}
