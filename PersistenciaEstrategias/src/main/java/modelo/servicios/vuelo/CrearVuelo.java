package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class CrearVuelo implements Operation<Vuelo> {
    private String codigoVuelo;


    public CrearVuelo(String codigoVuelo) {
        super();
        this.codigoVuelo = codigoVuelo;
    }

    public Vuelo execute() {
        Vuelo v = new Vuelo(codigoVuelo);
        new GenericDAO<Vuelo>(Vuelo.class).save(v);
        return v;
    }


}
