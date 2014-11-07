package servicios;

import modelo.aerolinea.Aerolinea;
import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.busquedas.Criterio;
import modelo.busquedas.Orden;
import modelo.busquedas.operadores.And;
import modelo.busquedas.operadores.Or;
import modelo.managers.AerolineaManager;
import modelo.managers.BusquedaManager;
import modelo.managers.TramoManager;
import modelo.managers.VueloManager;
import modelo.usuario.Usuario;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class BusquedaServicioTest extends  AbstractHibernateTest {

    Usuario usuarioQueRealizaBusqueda;
    Busqueda busquedaARealizar;
    VueloManager vueloManager;
    TramoManager tramoManager;
    BusquedaManager busquedaManager;

    @Override
    public void setUp() throws Exception {
        this.usuarioQueRealizaBusqueda = new Usuario("joaquin", "ramirez", "jramirez", null, null, null);
        this.busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        this.busquedaManager = new BusquedaManager();
        this.tramoManager = new TramoManager();
        this.vueloManager = new VueloManager();
    }

    @Test
    public void testConstruirQueryCorrectamente() {
        String consultaEsperada = "FROM Tramos INNER JOIN Vuelos WHERE ((nombre = pepe) AND ((nombre = tartu) OR (edad = 23))) ORDER BY nombre";
        Busqueda busqueda = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("nombre", "pepe");
        Criterio c2 = new Criterio("nombre", "tartu");
        Criterio c3 = new Criterio("edad", "23");
        busqueda.agregarCriterio(new And(c1, new Or(c2, c3)));
        busqueda.setOrden(new Orden("nombre"));
        assertEquals("Se espera que los dos strings sean iguales", consultaEsperada, busqueda.getQuery());
    }

    @Test
    public void testBuscarVuelos() {

        Vuelo v1 = new Vuelo();
        Vuelo v2 = new Vuelo();

        Tramo t1 = new Tramo("CODT1", "BsAs", "Montevideo", new Date(20141105), new Date(20141105), 300);
        Tramo t2 = new Tramo("CODT2", "BsAs", "Santiago de Chile", new Date(20141109), new Date(201411010), 500);
        Tramo t3 = new Tramo("CODT3", "BsAs", "Santiago de Chile", new Date(20141110), new Date(201411010), 500);
        Tramo t4 = new Tramo("CODT4", "BsAs", "San Pablo", new Date(20141111), new Date(201411011), 500);
        v1.agregarTramo(t1);
        v1.agregarTramo(t2);
        v2.agregarTramo(t3);
        v2.agregarTramo(t4);

        vueloManager.guardarVuelo(v1);
        vueloManager.guardarVuelo(v2);

        Criterio c1 = new Criterio("ORIGEN", "BsAs");
//        Criterio c2 = new Criterio("DESTINO", "Santiago de Chile");
       busquedaARealizar.agregarCriterio(c1);
       ArrayList<Vuelo> resultado =  new BusquedaManager().buscarVuelos(busquedaARealizar);
    }
}
