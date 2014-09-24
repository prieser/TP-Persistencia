package managers;

import modelo.Aerolinea;
import dao.SessionManager;
import servicios.ConsultarAerolinea;
import servicios.CrearAerolinea;
import servicios.ModificarAerolinea;

public class AerolineaManager {
	
	
	public Aerolinea consultarAerolinea(int id) {
		return SessionManager.runInSession(new ConsultarAerolinea(id));
	}

	public void crearAerolinea(String nombre, String direccion) {
		SessionManager.runInSession(new CrearAerolinea(nombre, direccion));
	}

	public Aerolinea modificarNombre(int id, String nombre, String direccion) {
		return SessionManager.runInSession(new ModificarAerolinea(id,nombre,direccion));
	}

}
