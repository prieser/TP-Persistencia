package servicios;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.managers.TramoManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;


public class TramoServicioTest extends AbstractHibernateTest {
	
	private TramoManager manager;
	
	@Before
	public void setUp() {
		this.manager = new TramoManager();
	}

	public void testCrearTramo() throws Exception {
		manager.crearTramo("BRA101", "Brasil", "Argentina", new Date(01/01/2000), new Date(01/01/2000), 1100);
	}

    public void testConsultarTramo() {
        // creo un tramo y le guardo tres asientos.
        Tramo unTramo = new Tramo("ARG205", "Buenos Aires", "Motevideo", new Date(15 / 03 / 2015), new Date(15 / 03 / 2015), 300);
        unTramo.getAsientos().add(new Asiento(44));
        unTramo.getAsientos().add(new Asiento(45));
        unTramo.getAsientos().add(new Asiento(46));

        manager.guardarTramo(unTramo);
        Tramo tramoObtenido = manager.consultarTramo(unTramo.getIdTramo());
        Assert.assertEquals(unTramo, tramoObtenido);
    }
}
