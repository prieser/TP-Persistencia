package servicios;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.managers.TramoManager;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TraerAsientoTramoTest  extends AbstractHibernateTest {
    
	private TramoManager tramoManager;
	private Set<Asiento> asientos1y2 ;
	private Set<Asiento> asientos1y2y3;
	private Asiento asiento1;
	private Asiento asiento2;
	private Asiento asiento3;
	private Tramo tramo;
	
	@Before
	public void setUp() {
		this.tramoManager = new TramoManager() ;
		this.asientos1y2 = new HashSet<Asiento>();
		this.asientos1y2y3 = new HashSet<Asiento>();
		this.asiento1 = new Asiento(1);
		this.asiento2 = new Asiento(2);
		this.asiento3 = new Asiento(3);
		this.asientos1y2.add(asiento1);
		this.asientos1y2.add(asiento2);
		this.asientos1y2y3.add(asiento1);
		this.asientos1y2y3.add(asiento2);
		this.asientos1y2y3.add(asiento3);
		this.tramo = new Tramo("ASD185", "asd", "asd", new Date(20140101), new Date(20140101), 11);
	}

	@After
	public void tearDown() {
		this.tramoManager.eliminarTramo(this.tramo);
	}
	
	@Test
	 public void testCuandoGuardoAsientosEntoncesEsperoLosMismos() {
		this.tramo.setAsientos(this.asientos1y2);
		tramoManager.guardarTramo(tramo);
		Set<Asiento> asientosRespuesta =new HashSet<Asiento> (tramoManager.TraerAsientosTramo(tramo));
		assertTrue(CollectionUtils.isEqualCollection(asientosRespuesta, this.asientos1y2));
	 }
	
	@Test
	 public void testCuandoGuardoAsientosEntoncesNoEsperoOtros() {
		this.tramo.setAsientos(this.asientos1y2);
		tramoManager.guardarTramo(tramo);
		Set<Asiento> asientosRespuesta =new HashSet<Asiento> (tramoManager.TraerAsientosTramo(tramo));
		assertFalse(CollectionUtils.isEqualCollection(asientosRespuesta, this.asientos1y2y3));
	 }
	
	@Test
	 public void testCuandoConsultoPorTramoInexistenteEntoncesElementosCero() {
		Set<Asiento> asientosRespuesta =new HashSet<Asiento> (tramoManager.TraerAsientosTramo(tramo));
		assertEquals(asientosRespuesta.size(), 0 ) ;
	}
	
}
