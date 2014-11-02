package modelo.servicios.tramo;

import modelo.aerolinea.Tramo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class GuardarTramo implements Operation<Object> {

    private Tramo tramo;

    public GuardarTramo(Tramo tramo) {
        this.tramo = tramo;

    }

    @Override
    public Object execute() {
        new GenericDAO<Tramo>(Tramo.class).save(this.tramo);
        return null;

    }


}
