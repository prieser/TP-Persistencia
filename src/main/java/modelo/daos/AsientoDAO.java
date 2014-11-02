package modelo.daos;

import modelo.aerolinea.Asiento;

public class AsientoDAO {
	
	public Asiento get(int idAsiento){
		return (Asiento)SessionManager.getSession().get(Asiento.class, idAsiento);
	}

	public void save(Asiento asiento) {
		SessionManager.getSession().saveOrUpdate(asiento);
	}
}
