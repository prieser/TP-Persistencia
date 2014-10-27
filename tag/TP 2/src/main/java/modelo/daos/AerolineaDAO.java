package modelo.daos;

import modelo.aerolinea.Aerolinea;

public class AerolineaDAO {
	
	
	public Aerolinea get(int id){
		return (Aerolinea)SessionManager.getSession().get(Aerolinea.class,id);
	}

	public void save(Aerolinea a) {
		SessionManager.getSession().saveOrUpdate(a);
	}

}