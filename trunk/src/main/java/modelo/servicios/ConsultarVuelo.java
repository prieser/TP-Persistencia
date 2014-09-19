package modelo.servicios;

import modelo.aerolinea.Vuelo;
import modelo.daos.VueloDAO;

public class ConsultarVuelo implements Operation<Vuelo> {
	
	private int id;
	
	public ConsultarVuelo(int id) {
		super();
		this.id = id;
	}

	public Vuelo execute() {
		Vuelo v;
		v = new VueloDAO().get(id);
		return v;
	}

}
