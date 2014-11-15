package servicios;

import java.util.ArrayList;
import java.util.Date;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.managers.TramoManager;
import modelo.managers.UsuarioManager;
import modelo.usuario.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReservarVariosAsientosTest extends AbstractHibernateTest {

    private TramoManager managerTramo;
    private UsuarioManager managerUsuario;

    @Before
    public void setUp() {
        this.managerTramo = new TramoManager();
        this.managerUsuario = new UsuarioManager();
    }

    @Test
    public void testReservarVariosVuelosCorrectamente() {
        Usuario usuario = new Usuario("Ramiro", "Lopez");
        managerUsuario.guardarUsuario(usuario);

        Tramo tramo = new Tramo("ARG701", "Buenos Aires", "Montevideo", new Date(15 / 03 / 2015), new Date(15 / 03 / 2015), 300);
        tramo.getAsientos().add(new Asiento(55));
        tramo.getAsientos().add(new Asiento(56));
        tramo.getAsientos().add(new Asiento(57));
        managerTramo.guardarTramo(tramo);

        ArrayList asientos = new ArrayList<Integer>();
        asientos.add(55);
        asientos.add(56);
        asientos.add(57);

        this.managerTramo.reservarMuchosAsientos(asientos, usuario, tramo);
        Tramo resultadoDelQuery = managerTramo.buscarTramoPorCodigo(tramo.getCodigoDelTramo());

        Assert.assertEquals(usuario, resultadoDelQuery.getAsiento(55).getOcupante());
        Assert.assertEquals(usuario, resultadoDelQuery.getAsiento(56).getOcupante());
        Assert.assertEquals(usuario, resultadoDelQuery.getAsiento(57).getOcupante());
    }
}
