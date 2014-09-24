package servicios.tramo;

import java.util.Date;

import modelo.Tramo;
import dao.TramoDAO;
import servicios.Operation;

public class CrearTramo implements Operation<Tramo> {

	private String origen;
	private String destino;
	private Date horaDeLlegada;
	private Date horaDeSalida;
	private int precio;
	
	

	public CrearTramo(String origen, String destino, Date horaDeLlegada,
			Date horaDeSalida, int precio) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.horaDeLlegada = horaDeLlegada;
		this.horaDeSalida = horaDeSalida;
		this.precio = precio;
	}



	
	public Tramo execute() {
		Tramo tramoAGuardar = new Tramo(origen, destino, horaDeLlegada, horaDeSalida, precio);
        new TramoDAO().save(tramoAGuardar);
        return tramoAGuardar;
	}

}
