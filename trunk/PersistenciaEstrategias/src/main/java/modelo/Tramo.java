package modelo;

import java.util.ArrayList;
import java.util.Date;

import modelo.Usuario;
import excepciones.AsientoYaReservadoException;

public class Tramo {
	private ArrayList<Asiento> asientos;
	private int idTramo;
	private String origen;
	private String destino;
	private Date horaDeLlegada;
	private Date horaDeSalida;
	private int precio;

	public Tramo(String origen, String destino,
			Date horaDeLlegada, Date horaDeSalida, int precio) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.horaDeSalida = horaDeSalida;
		this.horaDeLlegada = horaDeLlegada;
		this.precio = precio;
		this.asientos = new ArrayList<Asiento>();
	}

	public int getIdTramo() {
		return idTramo;
	}

	public void setIdTramo(int idTramo) {
		this.idTramo = idTramo;
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
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

	public Date getHoraDeLlegada() {
		return horaDeLlegada;
	}

	public void setHoraDeLlegada(Date horaDeLlegada) {
		this.horaDeLlegada = horaDeLlegada;
	}

	public Date getHoraDeSalida() {
		return horaDeSalida;
	}

	public void setHoraDeSalida(Date horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Object getAsientosSinReservar() {
		// Deberia retornar los asientos disponibles
		return null;
	}

	public void reservarAsiento(int numeroDeAsiento,
			Usuario usuarioQueQuiereReservar)
			throws AsientoYaReservadoException {
		Asiento asientoBuscado = this.getAsiento(numeroDeAsiento);
		if (!asientoBuscado.estaReservado()) {
			asientoBuscado.reservarAsiento(usuarioQueQuiereReservar);
		} else {
			throw new AsientoYaReservadoException(
					"El asiento que quiere reservar ya esta ocupado");
		}
	}

	private Asiento getAsiento(int numeroDeAsiento) {
		Asiento asientoBuscado = null;
		for (Asiento asiento : asientos) {
			if (asiento.getNumero() == numeroDeAsiento) {
				asientoBuscado = asiento;
			}
		}
		return asientoBuscado;
	}
}
