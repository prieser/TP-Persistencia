package servicios;

import modelo.Vuelo;
import dao.VueloDAO;

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
