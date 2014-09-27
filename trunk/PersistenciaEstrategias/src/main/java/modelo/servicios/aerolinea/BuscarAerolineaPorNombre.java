package modelo.servicios.aerolinea;

import modelo.aerolinea.Aerolinea;
import modelo.servicios.HibernateUtil;
import modelo.servicios.Operation;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

public class BuscarAerolineaPorNombre implements Operation<Aerolinea> {

    private String nombre;

    public BuscarAerolineaPorNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Aerolinea execute() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("from aerolineas where NOMBRE = :nombreParametro");
        query.setParameter("nombreParametro", this.nombre);
        query.setMaxResults(1);
        return (Aerolinea) query.uniqueResult();
    }
}
