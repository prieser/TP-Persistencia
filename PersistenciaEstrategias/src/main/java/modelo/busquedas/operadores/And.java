package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;


public class And extends Operador {
	
	public And(Criterio criterio1, Criterio criterio2) {
		super(criterio1, criterio2);
	}

	@Override
	public String getOperador() {
		return " AND ";
	}
    
}
