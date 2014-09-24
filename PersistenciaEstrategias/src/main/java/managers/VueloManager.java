package managers;

import modelo.Vuelo;
import dao.SessionManager;
import servicios.ConsultarVuelo;
import servicios.CrearVuelo;


public class VueloManager {
	
	
	public Vuelo consultarAerolinea(int id) {
		return SessionManager.runInSession(new ConsultarVuelo(id));
	}

	public void crearVuelo(int id) {
		SessionManager.runInSession(new CrearVuelo(id));
	}

}
