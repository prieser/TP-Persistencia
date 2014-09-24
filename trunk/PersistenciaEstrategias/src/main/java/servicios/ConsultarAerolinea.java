package servicios;

import modelo.Aerolinea;
import dao.AerolineaDAO;

public class ConsultarAerolinea implements Operation<Aerolinea> {

private int id;
	
	public ConsultarAerolinea(int id) {
		super();
		this.id = id;
	}

	public Aerolinea execute() {
		Aerolinea j;
		j = new AerolineaDAO().get(id);
		return j;
	}

}
