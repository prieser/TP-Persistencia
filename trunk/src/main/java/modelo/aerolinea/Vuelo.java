package modelo.aerolinea;

import java.util.Collection;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Vuelo {
	private Collection<Tramo> tramos;
	
	public int getCantidadTramos(){
		return this.tramos.size();
	}
	
	/*
	 * Se debera agregar la logica para que los tramos no se puedan pisar? 
	 * 
	 * */
	
	public void agregarTramo(Tramo tramo){
		this.tramos.add(tramo);
	}
}
