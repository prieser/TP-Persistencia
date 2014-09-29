package servicios;

import org.junit.After;
import org.junit.Before;

import modelo.aerolinea.Aerolinea;
import modelo.managers.AerolineaManager;


public class AerolineaServicioTest extends AbstractHibernateTest {

    private AerolineaManager manager = new AerolineaManager();

	@Before
	public void setUp() {
		this.manager = new AerolineaManager();
	}

	@After
	public void tearDown() {
	}
	
	
	public void testCrearAerolinea() throws Exception {
        manager.crearAerolinea("AA", "La Pampa 99");
	}

    public void testBuscarAerolineaPorNombre() {
        manager.crearAerolinea("AeroPlus", "Corrientes 123");
        Aerolinea resultadoDeQuery = manager.buscarAerolineaPorSuNombre("AeroPlus");
        assertEquals("Se espera que el nombre de la Aerolinea sea el buscado", "AeroPlus", resultadoDeQuery.getNombre());
        assertEquals("Se espera que la direccion de la Aerolinea sea el correcto", "Corrientes 123", resultadoDeQuery.getDireccion());
    }

}
