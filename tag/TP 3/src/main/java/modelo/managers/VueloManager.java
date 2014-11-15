package modelo.managers;

import modelo.aerolinea.Vuelo;
import modelo.daos.SessionManager;
import modelo.servicios.vuelo.ConsultarVuelo;
import modelo.servicios.vuelo.CrearVuelo;
import modelo.servicios.vuelo.EliminarVuelo;
import modelo.servicios.vuelo.GuardarVuelo;


public class VueloManager {


    public Vuelo consultarAerolinea(int id) {
        return SessionManager.runInSession(new ConsultarVuelo(id));
    }

    public void crearVuelo(String codigoVuelo) {
        SessionManager.runInSession(new CrearVuelo(codigoVuelo));
    }

    public void guardarVuelo(Vuelo vueloAGuardar) {
        SessionManager.runInSession(new GuardarVuelo(vueloAGuardar));
    }

    public void eliminarVuelo(Vuelo vueloAEliminar) {
        SessionManager.runInSession(new EliminarVuelo(vueloAEliminar));
    }

}
