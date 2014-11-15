package modelo.servicios.tramo;

import modelo.aerolinea.Tramo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class ConsultarTramo implements Operation<Tramo> {

    private int id;

    public ConsultarTramo(int id) {
        super();
        this.id = id;
    }

    @Override
    public Tramo execute() {
        Tramo tramoBuscado;
        tramoBuscado = (Tramo) new GenericDAO<Tramo>(Tramo.class).get(id);
        return tramoBuscado;
    }
}
