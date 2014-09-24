package servicios;

import modelo.Vuelo;
import dao.VueloDAO;

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
