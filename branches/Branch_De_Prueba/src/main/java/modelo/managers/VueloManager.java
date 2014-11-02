package modelo.managers;

import modelo.aerolinea.Vuelo;
import modelo.daos.SessionManager;
import modelo.servicios.vuelo.ConsultarVuelo;
import modelo.servicios.vuelo.CrearVuelo;


public class VueloManager {


    public Vuelo consultarAerolinea(int id) {
        return SessionManager.runInSession(new ConsultarVuelo(id));
    }

    public void crearVuelo(int id) {
        SessionManager.runInSession(new CrearVuelo(id));
    }

}
