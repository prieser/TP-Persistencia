package modelo.aerolinea;

import modelo.usuario.Usuario;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Asiento {
	
	private Usuario usuario;
	private Categoria categoria;
	private int numero;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean estaReservado() {
		return (this.getUsuario() != null);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void reservarAsiento (Usuario usuario){
		this.setUsuario(usuario);
		
	}
	
	
}
