package modelo.managers;

import java.util.Date;
import java.util.Set;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.AsientosDisponible;
import modelo.servicios.tramo.ConsultarTramo;
import modelo.servicios.tramo.CrearTramo;

public class TramoManager {
	
	public Tramo consultarTramo(int id) {
		return SessionManager.runInSession(new ConsultarTramo(id));
	}
	
	public Object guardarTramo(Tramo tramo) {
		return SessionManager.runInSession(new GuardarTramo(tramo));
	}

	public void crearTramo(String origen, String destino, Date horarioLlegada,Date horarioSalida, int precio) {
		SessionManager.runInSession(new CrearTramo(origen, destino, horarioLlegada, horarioSalida, precio));
	}
	
	public Set<Asiento> TraerAsientosTramo(Tramo tramo) {
		return SessionManager.runInSession(new AsientosDisponible(tramo));
	}
}
