package servicios;

import managers.AerolineaManager;

public class AerolineaServicioTest extends AbstractHibernateTest {

	public void testCrearAerolinea() throws Exception {
		new AerolineaManager().crearAerolinea("AA", "La Pampa 99");
	}

}
