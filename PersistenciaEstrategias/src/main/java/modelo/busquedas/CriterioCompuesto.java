package modelo.busquedas;

import modelo.busquedas.operadores.Operador;

public class CriterioCompuesto extends Criterio {
	
	private Criterio criterio1;
	private Criterio criterio2;
	private Operador operador;


    public CriterioCompuesto(Criterio criterioSimple1, Criterio criterioSimple2, Operador operador){
        super();
        this.criterio1 = criterioSimple1;
        this.criterio2 = criterioSimple2;
        this.operador = operador;
    }

	@Override
	public String getQuery() {
		return "(" + criterio1.getQuery() + operador.getOperador() + criterio2.getQuery() + ")";
	}

}
