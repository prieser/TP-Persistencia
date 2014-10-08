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
    
	public Asiento() {
		super();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asiento other = (Asiento) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
    


}
