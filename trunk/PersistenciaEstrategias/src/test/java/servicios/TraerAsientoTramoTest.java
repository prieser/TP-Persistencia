package servicios;


import java.util.Date;
import java.util.Set;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.managers.TramoManager;

import org.junit.After;
import org.junit.Before;

public class TraerAsientoTramoTest  extends AbstractHibernateTest {
    
	private TramoManager manager;

	@Before
	public void setUp() {
		this.manager = new TramoManager() ;
	}

	@After
	public void tearDown() {
	}
	

	 public void testTraerAsientosDeUnTramo() {
		 Tramo tramo = new Tramo("asd", "asd", new Date(20140101), new Date(20140101), 11);
		 @SuppressWarnings("unused")
		Set<Asiento> resultadoDeQuery = manager.TraerAsientosTramo(tramo);
		 
	 }
}
