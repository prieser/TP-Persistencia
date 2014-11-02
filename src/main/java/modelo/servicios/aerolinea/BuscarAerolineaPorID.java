package modelo.servicios.aerolinea;

import modelo.aerolinea.Aerolinea;
import modelo.daos.AerolineaDAO;
import modelo.servicios.Operation;

public class BuscarAerolineaPorID implements Operation<Aerolinea> {

private int id;
	
	public BuscarAerolineaPorID(int id) {
		super();
		this.id = id;
	}

	public Aerolinea execute() {
		Aerolinea j;
		j = new AerolineaDAO().get(id);
		return j;
	}

}
