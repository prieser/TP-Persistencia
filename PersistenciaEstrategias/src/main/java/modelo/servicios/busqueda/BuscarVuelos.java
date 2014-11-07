package modelo.servicios.busqueda;

import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;

public class BuscarVuelos implements Operation<ArrayList<Vuelo>> {

    private Busqueda busqueda;

    public BuscarVuelos(Busqueda busqueda) {
        this.busqueda = busqueda;
    }


    @Override
    public ArrayList<Vuelo> execute() {
        Session session = SessionManager.getSession();
//        Query query = session.createQuery(busqueda.getQuery());
        Query query = session.createQuery("FROM Vuelo v INNER JOIN v.tramos t WHERE origen = 'BsAs'");
        return (ArrayList<Vuelo>) query.list();
    }
}
