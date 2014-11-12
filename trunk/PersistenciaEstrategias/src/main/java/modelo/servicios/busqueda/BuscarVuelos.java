package modelo.servicios.busqueda;

import java.util.ArrayList;

import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;

import org.hibernate.Query;
import org.hibernate.Session;

public class BuscarVuelos implements Operation<ArrayList<Vuelo>> {

    private Busqueda busqueda;

    public BuscarVuelos(Busqueda busqueda) {
        this.busqueda = busqueda;
    }


    @Override
    public ArrayList<Vuelo> execute() {
        Session session = SessionManager.getSession();
        Query query = session.createQuery(busqueda.getQuery());
        return (ArrayList<Vuelo>) query.list();
    }
}

