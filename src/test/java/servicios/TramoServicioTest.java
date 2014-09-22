package servicios;

import java.util.Date;

import modelo.managers.TramoManager;

import org.junit.Before;


public class TramoServicioTest extends AbstractHibernateTest {
	
	private TramoManager manager;
	
	@Before
	public void setUp() {
		this.manager = new TramoManager();
	}

	public void testCrearTramo() throws Exception {
		manager.crearTramo("Brasil", "Argentina", new Date(01/01/2000), new Date(01/01/2000), 1100);
	}

}
