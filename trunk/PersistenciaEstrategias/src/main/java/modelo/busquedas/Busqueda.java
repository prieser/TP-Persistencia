package modelo.busquedas;

import java.util.ArrayList;

public class Busqueda {
	
	private ArrayList<Criterio> criterios;
	private Orden orden;
	
	public void agregarCriterio(Criterio criterioAAgregar) {
		this.criterios.add(criterioAAgregar);
	}

	public String getQuery() {
		String query = "from Vuelo WHERE";

		for (Criterio unCriterio : this.criterios) {
			query+= unCriterio.getQuery() ;
            query = query + unCriterio.getQuery();

		}

			query+= this.orden.getQuery();
	
		return query;


	}
}
	
