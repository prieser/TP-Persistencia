package modelo.servicios.tramo;

import modelo.aerolinea.Tramo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

import java.util.Date;

public class CrearTramo implements Operation<Tramo> {

    private String codigoDelTramo;
    private String origen;
    private String destino;
    private Date horaDeLlegada;
    private Date horaDeSalida;
    private int precio;


    public CrearTramo(String codigoDelTramo, String origen, String destino, Date horaDeLlegada,
                      Date horaDeSalida, int precio) {
        super();
        this.codigoDelTramo = codigoDelTramo;
        this.origen = origen;
        this.destino = destino;
        this.horaDeLlegada = horaDeLlegada;
        this.horaDeSalida = horaDeSalida;
        this.precio = precio;
    }


    @Override
    public Tramo execute() {
        Tramo tramoAGuardar = new Tramo(codigoDelTramo, origen, destino, horaDeLlegada, horaDeSalida, precio);
        new GenericDAO<Tramo>(Tramo.class).save(tramoAGuardar);
        return tramoAGuardar;
    }

}
