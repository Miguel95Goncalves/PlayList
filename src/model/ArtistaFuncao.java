package model;

public class ArtistaFuncao {
	private int af_id;
	private Funcao funcao;
	
	public ArtistaFuncao() {
	}
	
	public ArtistaFuncao(int af_id, Funcao funcao) {
		super();
		this.af_id = af_id;
		this.funcao = funcao;
	}
	
	public int getAf_id() {
		return af_id;
	}
	public void setAf_id(int af_id) {
		this.af_id = af_id;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
}