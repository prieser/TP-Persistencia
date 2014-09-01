package modelo;

public interface Home<Objeto> {
	public boolean guardar(Objeto obj) throws Exception;
	public boolean existe(Objeto obj) throws Exception;
	public boolean actualizar(Objeto obj) throws Exception;
	public Objeto dameUno(String obj) throws Exception;
	public boolean eliminar(Objeto obj) throws Exception;
}
