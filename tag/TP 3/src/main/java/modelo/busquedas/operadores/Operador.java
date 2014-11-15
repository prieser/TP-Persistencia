package modelo.busquedas.operadores;

import modelo.busquedas.Componente;

public abstract class Operador implements Componente {

	private Integer idOperador;
	private Componente criterio1;
	private Componente criterio2;

	public Integer getIdOperador() {
		return idOperador;
	}
	
	public void setIdOperador(Integer idOperador) {
		this.idOperador = idOperador;
	}

	public Componente getCriterio1() {
		return criterio1;
	}

	public void setCriterio1(Componente criterio1) {
		this.criterio1 = criterio1;
	}

	public Componente getCriterio2() {
		return criterio2;
	}

	public void setCriterio2(Componente criterio2) {
		this.criterio2 = criterio2;
	}

	public Operador(Componente criterio1, Componente criterio2) {
		super();
		this.criterio1 = criterio1;
		this.criterio2 = criterio2;
	}

	public abstract String getOperador();

	public String getQuery() {
		return "(" + criterio1.getQuery() + this.getOperador()
				+ criterio2.getQuery() + ")";
	}

}
