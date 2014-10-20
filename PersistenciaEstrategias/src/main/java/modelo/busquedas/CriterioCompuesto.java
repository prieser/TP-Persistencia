package modelo.busquedas;

import modelo.busquedas.operadores.Operador;

public class CriterioCompuesto extends Criterio {
	
	private Criterio criterio1;
	private Criterio criterio2;
	private Operador operador;

	@Override
	public String getQuery() {
		return "(" + criterio1.getQuery() + operador.getOperador() + criterio2.getQuery() + ")";
	}

}
