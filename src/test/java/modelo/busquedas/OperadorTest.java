package modelo.busquedas;

import modelo.busquedas.operadores.And;
import modelo.busquedas.operadores.Or;
import org.junit.Assert;
import org.junit.Test;

public class OperadorTest {

    @Test
    public void testCreacionDeQueryOR() {
        Criterio criterio1 = new CriterioSimple("nombre", "juan");
        Criterio criterio2 = new CriterioSimple("nombre", "pepe");
        Or operador = new Or();
        Criterio criterioFinal = new CriterioCompuesto(criterio1, criterio2, operador);

        Assert.assertEquals("((nombre = juan) OR (nombre = pepe))", criterioFinal.getQuery());
    }

    @Test
    public void testCreacionDeQueryAND() {
        Criterio criterio1 = new CriterioSimple("nombre", "juan");
        Criterio criterio2 = new CriterioSimple("nombre", "pepe");
        And operador = new And();
        Criterio criterioFinal = new CriterioCompuesto(criterio1, criterio2, operador);

        Assert.assertEquals("((nombre = juan) AND (nombre = pepe))", criterioFinal.getQuery());
    }

}
