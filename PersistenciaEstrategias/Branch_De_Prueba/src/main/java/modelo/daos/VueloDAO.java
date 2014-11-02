package modelo.daos;

import modelo.aerolinea.Vuelo;

public class VueloDAO {
	
	public Vuelo get(int id){
		return (Vuelo)SessionManager.getSession().get(Vuelo.class,id);
	}

	public void save(Vuelo v) {
		SessionManager.getSession().saveOrUpdate(v);
	}

}
