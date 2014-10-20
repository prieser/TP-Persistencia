package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;


public class Or extends Operador {
	
	public Or(Criterio criterio1, Criterio criterio2) {
		super(criterio1, criterio2);
	}

	@Override
	public String getOperador() {
		return " OR ";
	}
}
