package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;

import org.junit.Assert;
import org.junit.Test;

public class OperadorTest {

	@Test
	public void testCreacionDeQueryOR() {
		Criterio criterio1 = new Criterio();
		criterio1.setClave("nombre");
		criterio1.setValor("juan");

		Criterio criterio2 = new Criterio();
		criterio2.setClave("nombre");
		criterio2.setValor("pepe");
		
		Or or = new Or(criterio1, criterio2);
		Assert.assertEquals("nombre == juan OR nombre == pepe", or.getQuery());
	}
	
	@Test
	public void testCreacionDeQueryAND() {
		Criterio criterio1 = new Criterio();
		criterio1.setClave("nombre");
		criterio1.setValor("juan");

		Criterio criterio2 = new Criterio();
		criterio2.setClave("nombre");
		criterio2.setValor("pepe");
		
		And or = new And(criterio1, criterio2);
		Assert.assertEquals("nombre == juan AND nombre == pepe", or.getQuery());
	}

}
