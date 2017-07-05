package model;

public class ArtistaMusica {
	private int am_id;
	private Musica musica;
	
	public ArtistaMusica() {
	}
	
	public ArtistaMusica(int am_id, Musica musica) {
		super();
		this.am_id = am_id;
		this.musica = musica;
	}
	
	public int getAm_id() {
		return am_id;
	}
	public void setAm_id(int am_id) {
		this.am_id = am_id;
	}
	public Musica getMusica() {
		return musica;
	}
	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	
}
