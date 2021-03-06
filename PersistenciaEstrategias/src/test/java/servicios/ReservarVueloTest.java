package servicios;

import java.util.Date;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.managers.TramoManager;
import modelo.managers.UsuarioManager;
import modelo.usuario.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReservarVueloTest extends AbstractHibernateTest {

    private TramoManager manager;
    private UsuarioManager managerUsuario;

    @Before
    public void setUp() {
        this.manager = new TramoManager();
        this.managerUsuario = new UsuarioManager();
    }

    @Test
    public void testReservarVueloCorrectamente() {
        Usuario usuario = new Usuario("Joaquin", "Soto");
        managerUsuario.guardarUsuario(usuario);
        Tramo tramo = new Tramo("ARG703", "Buenos Aires", "Montevideo", new Date(15 / 03 / 2015), new Date(15 / 03 / 2015), 300);
        tramo.getAsientos().add(new Asiento(21));
        manager.guardarTramo(tramo);

        this.manager.reservarVuelo(21, usuario, tramo);

        Tramo resultadoDelQuery = manager.buscarTramoPorCodigo(tramo.getCodigoDelTramo());

        Assert.assertEquals(usuario, resultadoDelQuery.getAsiento(21).getOcupante());

    }


}

    
 