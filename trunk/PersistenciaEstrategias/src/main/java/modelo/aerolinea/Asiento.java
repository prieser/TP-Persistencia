package modelo.aerolinea;

import modelo.usuario.Usuario;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Asiento {

	private int IdAsiento;
    private int numero;
    private Usuario ocupante;
    private Categoria categoria;


    public int getIdAsiento() {
		return IdAsiento;
	}

	public void setIdAsiento(int idAsiento) {
		IdAsiento = idAsiento;
	}

	public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean estaReservado() {
        return (this.getOcupante() != null);
    }

    public Usuario getOcupante() {
        return ocupante;
    }

    public void setOcupante(Usuario ocupante) {
        this.ocupante = ocupante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void reservarAsiento(Usuario usuario) {
        this.setOcupante(usuario);
    }

	public Asiento(int numero) {
		super();
		this.numero = numero;
	}
    
    


}
