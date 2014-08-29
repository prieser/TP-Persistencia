package modelo;

public interface Home<Objecto> {
	public void guardar(Objecto obj) throws Exception;
	public boolean existe(Objecto obj) throws Exception;
	public boolean actualizar(Objecto obj) throws Exception;
}
