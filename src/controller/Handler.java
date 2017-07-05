package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.Logica;
import sqlServer.PageOnLoad;

@WebServlet("/Handler")
public class Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PageOnLoad pageOnLoad;
	
    public Handler() {
        super();
        pageOnLoad = new PageOnLoad();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession sessao = request.getSession(true);
		
		if(sessao.getAttribute("user_id") == null){
			pageOnLoad.carregarInformacao();
		}
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String parametro = request.getParameter("logica"); //Recebe como parametro do jsp, qual a class do service que irá atuar
	    String nomeDaClasse = "services." + parametro; //Nome da Classe
	    
	    try {
	      Class<?> classe = Class.forName(nomeDaClasse);
	      Logica logica = (Logica) classe.newInstance();
	      
	      String pagina = logica.executa(request, response);
	      
	      request.getRequestDispatcher(pagina).forward(request, response);

	    } catch (Exception e) {
	      throw new ServletException(
	          "A lógica causou uma exceção", e);
	    }
	}

}
