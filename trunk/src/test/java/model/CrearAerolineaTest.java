package model;

import modelo.managers.AerolineaManager;

public class CrearAerolineaTest extends AbstractHibernateTest {
	
	public void testApp() throws Exception {
		new AerolineaManager().crearAerolinea("AA","La Pampa 99");

}
}
