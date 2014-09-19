package model;

import modelo.servicios.AerolineaManager;

public class CrearAerolineaTest extends AbstractHibernateTest {
	
	public void testApp() throws Exception {
		new AerolineaManager().crearAerolinea("Aerolineas Argentinas","La Pampa 99");

}
}
