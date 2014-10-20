package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;

public class Or implements Operador {

    public static Or(Criterio primerCriterio, Criterio segundoCriterio) {
        Criterio criterio1 = primerCriterio;
        Criterio criterio2 = segundoCriterio;

        criterio1.consultar();
        criterio2.consultar();

    }
}
