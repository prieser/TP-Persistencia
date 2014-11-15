package modelo.servicios.aerolinea;

import modelo.aerolinea.Aerolinea;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class BuscarAerolineaPorID implements Operation<Aerolinea> {

    private int id;

    public BuscarAerolineaPorID(int id) {
        super();
        this.id = id;
    }

    public Aerolinea execute() {
        Aerolinea j;
        j = (Aerolinea) new GenericDAO<Aerolinea>(Aerolinea.class).get(id);
        return j;
    }

}
