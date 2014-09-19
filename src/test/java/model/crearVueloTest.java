package model;

import modelo.managers.VueloManager;

public class crearVueloTest extends AbstractHibernateTest {
	
	public void testApp() throws Exception {
		new VueloManager().crearVuelo(99); 

}
}