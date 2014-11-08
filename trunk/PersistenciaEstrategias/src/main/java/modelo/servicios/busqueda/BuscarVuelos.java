package modelo.servicios.busqueda;

import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;

public class BuscarVuelos implements Operation<ArrayList<String>> {

    private Busqueda busqueda;

    public BuscarVuelos(Busqueda busqueda) {
        this.busqueda = busqueda;
    }


    @Override
    public ArrayList<String> execute() {
        Session session = SessionManager.getSession();
        Query query = session.createQuery(busqueda.getQuery());
        return (ArrayList<String>) query.list();
    }
}