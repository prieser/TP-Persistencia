package modelo.servicios;

import modelo.aerolinea.Aerolinea;
import modelo.daos.SessionManager;

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
