package modelo.busquedas;

public class Criterio implements Componente {

	private int idCriterio;
	private String clave;
	private String valor;

	public Criterio(String clave, String valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}

	public void setIdCriterio(int idCriterio) {
		this.idCriterio = idCriterio;
	}

	public int getIdCriterio() {
		return idCriterio;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getQuery() {
		return "(" + this.getClave() + " = " + "'" + this.getValor()+  "'" + ")";
	};
}
