package modelo.busquedas;

import java.util.ArrayList;

public class Busqueda {
	
	private ArrayList<Criterio> criterios;
	private Orden orden;
	
	public void agregarCriterio(Criterio criterioAAgregar) {
		this.criterios.add(criterioAAgregar);
	}

	public String getQuery() {
        String query = "SELECT * FROM Vuelos WHERE ";
		for (Criterio unCriterio : this.criterios) {
            query = query + unCriterio.getQuery();
		}
        return  query;
	}
}
	
