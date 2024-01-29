package br.am.nimai.services;

public class Usuario {
	
	String user;
	
	public Usuario(String nomeUser) {
		this.setUser(nomeUser);
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
