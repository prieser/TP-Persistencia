package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class ConsultarVuelo implements Operation<Vuelo> {

    private int id;

    public ConsultarVuelo(int id) {
        super();
        this.id = id;
    }

    public Vuelo execute() {
        Vuelo v;
        v = (Vuelo) new GenericDAO<Vuelo>(Vuelo.class).get(id);
        return v;
    }

}
