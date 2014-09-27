package modelo.servicios;

import modelo.aerolinea.Aerolinea;
import modelo.daos.AerolineaDAO;

public class ModificarNombreAerolinea implements Operation<Aerolinea>{

	
	private String nombre;
	private int id;

	public ModificarNombreAerolinea(int id,String nombre) {
		super();
		this.nombre = nombre;
		this.id = id;
	}


	public Aerolinea execute() {
		Aerolinea j = new AerolineaDAO().get(id);
		j.setNombre(nombre);
		return j;
	}
}
