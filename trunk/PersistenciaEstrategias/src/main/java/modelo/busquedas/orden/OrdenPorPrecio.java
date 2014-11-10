package modelo.busquedas.orden;

public class OrdenPorPrecio extends Orden {

	@Override
	public String getQuery() {
		return "ORDER BY t.precio asc";
	}
}
