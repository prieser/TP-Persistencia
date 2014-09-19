package modelo.managers;

import modelo.aerolinea.Vuelo;
import modelo.daos.SessionManager;
import modelo.servicios.ConsultarVuelo;
import modelo.servicios.CrearVuelo;
import modelo.servicios.ModificarVuelo;


public class VueloManager {
	
	
	public Vuelo consultarAerolinea(int id) {
		return SessionManager.runInSession(new ConsultarVuelo(id));
	}

	public void crearVuelo(int id) {
		SessionManager.runInSession(new CrearVuelo(id));
	}

}
