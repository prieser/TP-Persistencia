package modelo.managers;

import modelo.aerolinea.Asiento;
import modelo.daos.AsientoDAO;


public class AsientoManager {
	
	public Object guardarAsiento(Asiento asiento) {
		new AsientoDAO().save(asiento);
		return null;
	}

}
