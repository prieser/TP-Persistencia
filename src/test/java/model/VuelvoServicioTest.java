package model;

import modelo.managers.VueloManager;

public class VuelvoServicioTest extends AbstractHibernateTest {
	
	public void testCrearVuelo() throws Exception {
		new VueloManager().crearVuelo(99); 

}

}
