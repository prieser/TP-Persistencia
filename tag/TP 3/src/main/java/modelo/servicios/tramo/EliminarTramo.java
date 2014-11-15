package modelo.servicios.tramo;

import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;

public class EliminarTramo implements Operation<Object> {

    private Tramo tramo;

    public EliminarTramo(Tramo tramo) {
        this.tramo = tramo;
    }

    @Override
    public Object execute() {
        SessionManager.getSession().delete(tramo);
        return null;
    }

}
