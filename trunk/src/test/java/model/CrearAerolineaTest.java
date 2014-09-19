package model;

import modelo.managers.AerolineaManager;

public class CrearAerolineaTest extends AbstractHibernateTest {
	
	public void testApp() throws Exception {
		new AerolineaManager().crearAerolinea("Aerolineas Argentinas","La Pampa 99");

}
}
