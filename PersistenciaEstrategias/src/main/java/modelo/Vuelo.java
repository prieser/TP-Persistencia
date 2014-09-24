package modelo;

import java.util.Collection;

public class Vuelo {
	private Collection<Tramo> tramos;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vuelo(int id) {
		super();
		this.id = id;
	}

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
