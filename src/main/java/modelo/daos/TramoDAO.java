package modelo.daos;

import modelo.aerolinea.Tramo;

public class TramoDAO {
	
	public Tramo get(int id){
		return (Tramo)SessionManager.getSession().get(Tramo.class,id);
	}

	public void save(Tramo t) {
		SessionManager.getSession().saveOrUpdate(t);
	}

}
