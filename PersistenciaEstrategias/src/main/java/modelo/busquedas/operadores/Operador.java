package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;

public abstract class Operador {

	protected Criterio criterio1;
	protected Criterio criterio2;
	protected String operador;
	
	public Operador(Criterio criterio1, Criterio criterio2) {
		super();
		this.criterio1 = criterio1;
		this.criterio2 = criterio2;
	}

	public String getQuery() {
		return criterio1.getClave() + " == " + criterio1.getValor() + this.getOperador() + criterio2.getClave() + " == " + criterio2.getValor();
	}
	
	public abstract String getOperador();

}
