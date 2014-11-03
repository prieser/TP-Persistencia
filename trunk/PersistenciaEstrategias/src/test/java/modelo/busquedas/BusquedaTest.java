package modelo.busquedas;

import modelo.busquedas.operadores.Or;
import modelo.busquedas.operadores.And;

import org.junit.Test;

import modelo.busquedas.Criterio;

public class BusquedaTest {
    @Test
    public void testBusquedaQueryOR() {
    	
    	Busqueda busqueda = new Busqueda();
    	busqueda.agregarCriterio(new Or(new And(new Criterio("nombre","pepe"),new Criterio("nombre","pepe")),new Criterio("apellido","pe") ));
    	busqueda.setOrden(new Orden("nombre"));
    	System.out.println(busqueda.getQuery());
//        Criterio criterio1 = new CriterioSimple("nombre", "juan");
//        Criterio criterio2 = new CriterioSimple("nombre", "pepe");
//        Orden orden = new Orden();
//        orden.setValor("nombre");
//        Or operador = new Or();
//        Criterio criterioFinal = new CriterioCompuesto(criterio1, criterio2, operador);
//        Busqueda busqueda = new Busqueda();
//        busqueda.agregarCriterio(criterioFinal);
//        busqueda.setOrden(orden);
//        System.out.println(busqueda.getQuery());
//	        Assert.assertEquals("((nombre = juan) OR (nombre = pepe))", criterioFinal.getQuery());

    }
}
