package modelo.managers;

import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.daos.SessionManager;
import modelo.servicios.busqueda.BuscarVuelos;
import modelo.servicios.busqueda.GuardarBusqueda;
import modelo.servicios.busqueda.TraerBusquedas;
import modelo.usuario.Usuario;

import java.util.ArrayList;

public class BusquedaManager {

    @SuppressWarnings("unchecked")
    public ArrayList<Busqueda> traerBusquedas(Usuario usuario) {
        return SessionManager.runInSession(new TraerBusquedas(usuario));
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Vuelo> buscarVuelos(Busqueda busqueda, Usuario usuarioQueRealizaBusqueda) {
        return SessionManager.runInSession(new BuscarVuelos(busqueda));
    }

    @SuppressWarnings("unchecked")
    public Busqueda guardarBusqueda(Busqueda busqueda) {
        return SessionManager.runInSession(new GuardarBusqueda(busqueda));
    }

}