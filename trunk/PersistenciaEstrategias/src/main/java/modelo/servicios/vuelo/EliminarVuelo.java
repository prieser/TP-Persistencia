package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class EliminarVuelo implements Operation<Vuelo> {

    private Vuelo vueloAEliminar;

    public EliminarVuelo(Vuelo vueloAEliminar) {
        this.vueloAEliminar = vueloAEliminar;
    }

    @Override
    public Vuelo execute() {
        new GenericDAO<Vuelo>(Vuelo.class).remove(this.vueloAEliminar);
        return null;
    }
}
