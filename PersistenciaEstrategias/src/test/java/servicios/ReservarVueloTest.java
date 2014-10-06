package servicios;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.managers.TramoManager;
import modelo.managers.UsuarioManager;
import modelo.usuario.Usuario;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ReservarVueloTest extends AbstractHibernateTest {

    private TramoManager manager;
    private UsuarioManager managerUsuario;
    private Set<Asiento> asientos1y2;
    private Asiento asiento21;
	private Asiento asiento22;

    @Before
    public void setUp() {
        this.manager = new TramoManager();
        this.managerUsuario = new UsuarioManager();
        this.asientos1y2 = new HashSet<Asiento>();
        this.asiento21 = new Asiento(21);
		this.asiento22 = new Asiento(22);
		this.asientos1y2.add(asiento21);
		this.asientos1y2.add(asiento22);
        
        
    }
    

	
    @Test
    public void testReservarVueloCorrectamente() {
        Usuario usuario = new Usuario("Ramiro", "Lopez");
        managerUsuario.guardarUsuario(usuario);
        Tramo tramo = new Tramo("ARG701", "Buenos Aires", "Montevideo", new Date(15 / 03 / 2015), new Date(15 / 03 / 2015), 300);
        tramo.getAsientos().add(new Asiento(21));
        manager.guardarTramo(tramo);
            
        this.manager.reservarVuelo(21, usuario, tramo);
        
        Tramo resultadoDelQuery = manager.buscarTramoPorCodigo(tramo.getCodigoDelTramo());
        
        Assert.assertEquals(usuario, resultadoDelQuery.getAsiento(21).getOcupante());

    }
    

}

    
 