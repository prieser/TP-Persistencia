package modelo.aerolinea;

import java.util.Collection;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Tramo {
	private Collection<Asiento> asientos;
	private String origen;
	private String destino;
	private String horaDeLlegada;
	private String horaDeSalida;
	private int precio;
	
	
	
	public Collection<Asiento> getAsientos() {
		return asientos;
	}
	public void setAsientos(Collection<Asiento> asientos) {
		this.asientos = asientos;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getHoraDeLlegada() {
		return horaDeLlegada;
	}
	public void setHoraDeLlegada(String horaDeLlegada) {
		this.horaDeLlegada = horaDeLlegada;
	}
	public String getHoraDeSalida() {
		return horaDeSalida;
	}
	public void setHoraDeSalida(String horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
}
