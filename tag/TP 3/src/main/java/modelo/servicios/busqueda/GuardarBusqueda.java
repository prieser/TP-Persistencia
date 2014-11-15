package modelo.servicios.busqueda;

import modelo.busquedas.Busqueda;
import modelo.daos.GenericDAO;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import org.hibernate.Session;

public class GuardarBusqueda implements Operation<Busqueda> {

    private Busqueda busquedaRealizada;

    public GuardarBusqueda(Busqueda busquedaRealizada) {
        this.busquedaRealizada = busquedaRealizada;
    }

    @Override
    public Busqueda execute() {
        Session session = SessionManager.getSession();
        new GenericDAO<Busqueda>(Busqueda.class).save(this.busquedaRealizada);
        return busquedaRealizada;
    }
}
