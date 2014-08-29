package modelo;

public interface Home<Objeto> {
	public void guardar(Objeto obj) throws Exception;
	public boolean existe(Objeto obj) throws Exception;
	public boolean actualizar(Objeto obj) throws Exception;
}
