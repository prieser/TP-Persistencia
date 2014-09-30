package servicios;

import junit.framework.TestCase;
import modelo.aerolinea.Tramo;
import modelo.servicios.ReservarVuelo;
import modelo.usuario.Usuario;
import org.junit.Assert;

import java.util.Date;

public class ReservarVueloTest extends AbstractHibernateTest {

    public void testReservarVueloCorrectamente() {
        Usuario usuario = new Usuario();
        Tramo tramo = new Tramo("Buenos Aires", "Motevideo", new Date(15/03/2015), new Date(15/03/2015), 300);
        new ReservarVuelo(21, usuario, tramo);

        Assert.assertEquals(usuario, tramo.getAsiento(21).getOcupante());

    }

}