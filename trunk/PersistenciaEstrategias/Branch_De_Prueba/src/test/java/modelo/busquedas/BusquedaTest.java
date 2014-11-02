package modelo.busquedas;
import modelo.busquedas.operadores.Or;

import org.junit.Assert;
import org.junit.Test;

public class BusquedaTest {
	   @Test
	    public void testBusquedaQueryOR() {
	        Criterio criterio1 = new CriterioSimple("nombre", "juan");
	        Criterio criterio2 = new CriterioSimple("nombre", "pepe");
	        Orden orden = new Orden();
	        orden.setValor("nombre");
	        Or operador = new Or();
	        Criterio criterioFinal = new CriterioCompuesto(criterio1, criterio2, operador);
	        Busqueda busqueda = new Busqueda();
	        busqueda.agregarCriterio(criterioFinal);
	        busqueda.setOrden(orden);
	        System.out.println(busqueda.getQuery());
//	        Assert.assertEquals("((nombre = juan) OR (nombre = pepe))", criterioFinal.getQuery());
	    
	   }
}
