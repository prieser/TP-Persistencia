package modelo.servicios.aerolinea;

import modelo.aerolinea.Aerolinea;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import org.hibernate.Query;
import org.hibernate.Session;

public class BuscarAerolineaPorNombre implements Operation<Aerolinea> {

    private String nombre;

    public BuscarAerolineaPorNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Aerolinea execute() {
    	Session session = SessionManager.getSession();
    	Query query = session.createQuery("from Aerolinea where NOMBRE = :nombreParametro");
        query.setParameter("nombreParametro", this.nombre);
        query.setMaxResults(1);
        return (Aerolinea) query.uniqueResult();
    }
}
