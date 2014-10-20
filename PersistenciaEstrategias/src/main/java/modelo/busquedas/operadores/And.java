package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;

import java.util.Set;

public class And implements Operador {

    public static And(Criterio primerCriterio, Criterio segundoCriterio) {
        Criterio criterio1 = primerCriterio;
        Criterio criterio2 = segundoCriterio;

        criterio1.consultar();
        criterio2.consultar();

    }

}
