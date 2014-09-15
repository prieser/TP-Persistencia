package modelo.aerolinea;

import java.util.Collection;


/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Aerolinea {

    private int id;
	private Collection<Vuelo> vuelos;
    private String nombre;
    private String direccion;
    
    public Collection<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(Collection<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Collection<Vuelo> vuelosOfertados(){
    	return this.vuelos ;
    	
    }
}
