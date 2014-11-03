package modelo.busquedas.operadores;

import modelo.busquedas.Componente;


public class Or extends Operador {

    public Or(Componente criterio1, Componente criterio2) {
		super(criterio1, criterio2);
	}

	@Override
    public String getOperador() {
        return " OR ";
    }
}
