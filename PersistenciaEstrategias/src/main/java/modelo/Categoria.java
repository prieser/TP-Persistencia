package modelo;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public abstract class Categoria {
	
	String descripcion ;
	Float precio ;
	
	public String getDescipcion() {
		return this.descripcion;
	}
	
	public void setDescipcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio(){
		return this.precio ;
	}
	
	public void setPrecio(Float precio){
		this.precio = precio ;
	}

}
