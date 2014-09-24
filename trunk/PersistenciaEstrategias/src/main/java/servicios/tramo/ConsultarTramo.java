package servicios.tramo;

import modelo.Tramo;
import dao.TramoDAO;
import servicios.Operation;

public class ConsultarTramo implements Operation<Tramo> {

	private int id;

	public ConsultarTramo(int id) {
		super();
		this.id = id;
	}

	public Tramo execute() {
		Tramo tramoBuscado;
		tramoBuscado = new TramoDAO().get(id);
		return tramoBuscado;
	}

}
