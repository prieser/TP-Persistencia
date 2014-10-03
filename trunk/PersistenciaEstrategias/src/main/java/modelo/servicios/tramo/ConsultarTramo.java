package modelo.servicios.tramo;

import modelo.aerolinea.Aerolinea;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.daos.TramoDAO;
import modelo.servicios.Operation;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultarTramo implements Operation<Tramo> {

	private int id;

	public ConsultarTramo(int id) {
		super();
		this.id = id;
	}

	@Override
	public Tramo execute() {
		Tramo tramoBuscado;
		tramoBuscado = new TramoDAO().get(id);
		return tramoBuscado;
	}
}
