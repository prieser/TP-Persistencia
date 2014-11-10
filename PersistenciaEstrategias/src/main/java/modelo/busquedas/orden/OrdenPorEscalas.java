package modelo.busquedas.orden;

public class OrdenPorEscalas extends Orden {

	@Override
	public String getQuery() {
		return "GROUP BY v.id ORDER BY COUNT(t.idTramo) ASC";
	}

}
