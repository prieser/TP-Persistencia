package servicios;

import java.util.ArrayList;
import java.util.Date;

import modelo.aerolinea.Tramo;
import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.busquedas.Criterio;
import modelo.busquedas.operadores.And;
import modelo.busquedas.operadores.Or;
import modelo.busquedas.orden.Orden;
import modelo.busquedas.orden.OrdenPorEscalas;
import modelo.busquedas.orden.OrdenPorPrecio;
import modelo.managers.BusquedaManager;
import modelo.managers.TramoManager;
import modelo.managers.VueloManager;
import modelo.usuario.Usuario;

import org.junit.Before;
import org.junit.Test;

public class BusquedaServicioTest extends AbstractHibernateTest {

    Usuario usuarioQueRealizaBusqueda = new Usuario("joaquin", "ramirez", "jramirez", null, null, null);
    VueloManager vueloManager = new VueloManager();
    TramoManager tramoManager = new TramoManager();
    BusquedaManager busquedaManager = new BusquedaManager();
    Vuelo v1 = new Vuelo("V101");
    Vuelo v2 = new Vuelo("V102");
    Vuelo v3 = new Vuelo("V103");

    Tramo t1 = new Tramo("CODT1", "BsAs", "Montevideo", new Date(114, 10, 10),new Date(114, 10, 10), 400);
    Tramo t2 = new Tramo("CODT2", "Montevideo", "San Pablo", new Date(114, 10, 10), new Date(114, 10, 10), 1500);

    Tramo t3 = new Tramo("CODT3", "BsAs", "Montevideo", new Date(114, 10, 11), new Date(114, 10, 11), 600);
    Tramo t4 = new Tramo("CODT4", "Montevideo", "San Pablo", new Date(114, 10, 11), new Date(114, 10, 11), 1600);
    Tramo t5 = new Tramo("CODT5", "San Pablo", "Pretoria", new Date(114, 10, 11), new Date(114, 10, 11), 3500);

    Tramo t6 = new Tramo("CODT6", "BsAs", "Montevideo", new Date(114, 10, 12), new Date(114, 10, 12), 300);
    Tramo t7 = new Tramo("CODT7", "Montevideo", "Asuncion", new Date(114, 10, 12), new Date(114, 10, 12), 1000);
    Tramo t8 = new Tramo("CODT8", "Asuncion", "Quito", new Date(114, 10, 12), new Date(114, 10, 12), 1200);
    Tramo t9 = new Tramo("CODT9", "Quito", "Caracas", new Date(114, 10, 12), new Date(114, 10, 12), 1000);



    @Before
    public void setUp() throws Exception {
        v1.agregarTramo(t1);
        v1.agregarTramo(t2);

        v2.agregarTramo(t3);
        v2.agregarTramo(t4);
        v2.agregarTramo(t5);

        v3.agregarTramo(t6);
        v3.agregarTramo(t7);
        v3.agregarTramo(t8);
        v3.agregarTramo(t9);

        vueloManager.guardarVuelo(v1);
        vueloManager.guardarVuelo(v2);
        vueloManager.guardarVuelo(v3);
    }

    @Override
    public void tearDown() throws Exception {
        vueloManager.eliminarVuelo(v1);
        vueloManager.eliminarVuelo(v2);
        vueloManager.eliminarVuelo(v3);
    }

    @Test
    public void testConstruirQueryCorrectamente() {
        String consultaEsperada = "SELECT v FROM Vuelo v INNER JOIN v.tramos t WHERE ((nombre = 'pepe') AND ((nombre = 'tartu') OR (edad = '23')))";
        Busqueda busqueda = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("nombre", "pepe");
        Criterio c2 = new Criterio("nombre", "tartu");
        Criterio c3 = new Criterio("edad", "23");
        busqueda.agregarCriterio(new And(c1, new Or(c2, c3)));
        assertEquals("Se espera que los dos strings sean iguales", consultaEsperada, busqueda.getQuery());
    }

    @Test
    public void testBuscarVuelosConOrigen() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("ORIGEN", "BsAs");
        busquedaARealizar.agregarCriterio(c1);
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(resultado.contains(v1));
        assertTrue(resultado.contains(v2));
        assertTrue(resultado.contains(v3));
    }

    @Test
    public void testBuscarVuelosConDestino() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("DESTINO", "Quito");
        busquedaARealizar.agregarCriterio(c1);
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(resultado.contains(v3));
        assertFalse(resultado.contains(v1));
        assertFalse(resultado.contains(v2));
    }
    
    @Test
    public void testBuscarVuelosConFecha() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("HORA_SALIDA", "2014-11-10");
        busquedaARealizar.agregarCriterio(c1);
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(resultado.contains(v1));
        assertFalse(resultado.contains(v2));
        assertFalse(resultado.contains(v3));
    }

    @Test
    public void testBuscarVuelosConOrigenYDestinoNoCompatibles() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("ORIGEN", "Montevideo");
        Criterio c2 = new Criterio("DESTINO", "Miami");
        busquedaARealizar.agregarCriterio(new And(c1, c2));
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testBuscarVuelosConOrigenYDestinoCompatibles() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("ORIGEN", "San Pablo");
        Criterio c2 = new Criterio("DESTINO", "Pretoria");
        busquedaARealizar.agregarCriterio(new And(c1, c2));
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(resultado.contains(v2));
        assertFalse(resultado.contains(v1));
        assertFalse(resultado.contains(v3));
    }

    /* **********************************************************
     * Tests de orden
     * **********************************************************/

    @Test
    public void testBuscarVuelosConOrigenOrdenadoPorPrecio() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("ORIGEN", "BsAs");
        Orden orden = new OrdenPorPrecio();
        busquedaARealizar.agregarCriterio(c1);
        busquedaARealizar.agregarOrden(orden);
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(v3.equals(resultado.get(0)));
        assertTrue(v1.equals(resultado.get(1)));
        assertTrue(v2.equals(resultado.get(2)));
    }
    
    @Test
    public void testBuscarVuelosConOrigenOrdenadoPorCantidadDeEscalas() {
        Busqueda busquedaARealizar = new Busqueda(usuarioQueRealizaBusqueda);
        Criterio c1 = new Criterio("ORIGEN", "BsAs");
        Orden orden = new OrdenPorEscalas();
        busquedaARealizar.agregarCriterio(c1);
        busquedaARealizar.agregarOrden(orden);
        ArrayList<Vuelo> resultado = busquedaManager.buscarVuelos(busquedaARealizar);
        assertTrue(v1.equals(resultado.get(0)));
        assertTrue(v2.equals(resultado.get(1)));
        assertTrue(v3.equals(resultado.get(2)));
    }

}
