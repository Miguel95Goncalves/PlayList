package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ArtistaMusica;
import services.SArtista;
import services.SMusica;

public class ArtistaMusicaQuery {

	public static void loadArtistaMusica(){
		SArtista sArtista = new SArtista();
		SMusica sMusica = new SMusica();
		
		String artista_musica = "SELECT am_id, am_artista_id, am_musica_id FROM Artista_Musica";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(artista_musica);
            
            while ( rs.next() ) {
                sArtista.procurarArtista(rs.getInt("am_artista_id")).getArtistaMusica().add(new ArtistaMusica(rs.getInt("am_id"), sMusica.procurarMusica(rs.getInt("am_musica_id"))));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addArtistaMusica(int artista_id, int musica_id) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Artista_Musica(am_artista_id, am_musica_id)"
						+ " VALUES ('" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(artista_id))) + "',"
						+ " '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_id))) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(am_id) AS max_id FROM Artista_Musica"; //Query para ir buscar o ID maximo da tabela Artista_Musica
		
		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
			ResultSet rs;

			rs = st.executeQuery(user);

			while(rs.next()) {
				if(rs.getInt("max_id") >= 1) { //Se o ID retornado pela query for maior ou igual a 1, este metodo ira retornar esse valor mais um
					return rs.getInt("max_id")+1;
				}else { //Caso contrario ira retornar 1
					return 1;
				}
			}
			
			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! TemaQuerys.load()");
			System.err.println(e.getMessage());
		}
		
		return 0;
	}
	
	public static void delArtistaMusica(int artista_musica_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"DELETE FROM Artista_Musica"
						+ " WHERE am_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(artista_musica_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
