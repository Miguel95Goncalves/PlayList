package model;

public class GeneroMusica {
	private int gm_id;
	private Musica musica;
	
	public GeneroMusica(int gm_id, Musica musica) {
		super();
		this.gm_id = gm_id;
		this.musica = musica;
	}
	
	public GeneroMusica(){
		
	}
	
	public int getGm_id() {
		return gm_id;
	}
	public void setGm_id(int gm_id) {
		this.gm_id = gm_id;
	}
	public Musica getMusica() {
		return musica;
	}
	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	
}
