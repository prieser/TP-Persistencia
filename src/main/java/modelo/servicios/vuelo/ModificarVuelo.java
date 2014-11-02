package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.VueloDAO;

public class ModificarVuelo {


	private int id;


	public ModificarVuelo(int id) {
		super();
		this.id = id;
	}


	public Vuelo execute() {
		Vuelo v = new VueloDAO().get(id);
		v.setId(id);
		return v;
	}
	
	
}
