package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.GenericDAO;

public class ModificarVuelo {


    private int id;


    public ModificarVuelo(int id) {
        super();
        this.id = id;
    }


    public Vuelo execute() {
        Vuelo v = (Vuelo) new GenericDAO<Vuelo>(Vuelo.class).get(id);
        v.setId(id);
        return v;
    }


}
