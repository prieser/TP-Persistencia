package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class CrearVuelo implements Operation<Vuelo> {
    private int id;


    public CrearVuelo(int id) {
        super();
        this.id = id;
    }

    public Vuelo execute() {
        Vuelo v = new Vuelo();
        new GenericDAO<Vuelo>(Vuelo.class).save(v);
        return v;
    }


}
