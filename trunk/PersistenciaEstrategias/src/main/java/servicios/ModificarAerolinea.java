package servicios;

import modelo.Aerolinea;
import dao.AerolineaDAO;

public class ModificarAerolinea implements Operation<Aerolinea>{

	
	private String nombre;
	private int id;
	private String direccion;

	public ModificarAerolinea(int id,String nombre,String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.id = id;
	}


	public Aerolinea execute() {
		Aerolinea j = new AerolineaDAO().get(id);
		j.setNombre(nombre);
		return j;
	}
}
