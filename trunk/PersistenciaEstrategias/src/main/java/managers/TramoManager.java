package managers;

import java.util.Date;

import modelo.Tramo;
import dao.SessionManager;
import servicios.tramo.ConsultarTramo;
import servicios.tramo.CrearTramo;

public class TramoManager {
	
	public Tramo consultarTramo(int id) {
		return SessionManager.runInSession(new ConsultarTramo(id));
	}

	public void crearTramo(String origen, String destino, Date horarioLlegada,Date horarioSalida, int precio) {
		SessionManager.runInSession(new CrearTramo(origen, destino, horarioLlegada, horarioSalida, precio));
	}
}
