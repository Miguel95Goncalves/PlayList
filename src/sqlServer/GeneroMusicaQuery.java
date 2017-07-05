package sqlServer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.GeneroMusica;
import services.SGenero;
import services.SMusica;

public class GeneroMusicaQuery {

	public static void loadGeneroMusica(){
		SGenero sGenero = new SGenero();
		SMusica sMusica = new SMusica();
		
		String genero_musica = "SELECT gm_id, gm_genero_id, gm_musica_id FROM Genero_Musica";

		try {
			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();
            ResultSet rs;
 
            rs = st.executeQuery(genero_musica);
            
            while ( rs.next() ) {
                sGenero.procurarGenero(rs.getInt("gm_genero_id")).getGeneroMusica().add(new GeneroMusica(rs.getInt("gm_id"), sMusica.procurarMusica(rs.getInt("gm_musica_id"))));
            }
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
	}
	
	public static int addGeneroMusica(int genero_id, int musica_id) {
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"INSERT INTO Genero_Musica(gm_genero_id, gm_musica_id)"
						+ " VALUES ('" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(genero_id))) + "',"
						+ " '" + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(musica_id))) + "')");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		
		//-----------------------//-----------------------//
		
		String user = "SELECT MAX(gm_id) AS max_id FROM Genero_Musica"; //Query para ir buscar o ID maximo da tabela Genero_Musica
		
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
	
	public static void delGeneroMusica(int genero_musica_id){
		try {

			Connection conn = Coneccao.getConnection();

			Statement st = conn.createStatement();

			st.executeUpdate(
					"DELETE FROM Genero_Musica"
						+ " WHERE gm_id = " + Integer.parseInt(Coneccao.cleanQuery(Integer.toString(genero_musica_id))) + "");

			conn.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
}
