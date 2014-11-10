package modelo.servicios.tramo;

import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;

import org.hibernate.Query;
import org.hibernate.Session;


public class BuscarTramoPorCodigo implements Operation<Tramo> {

    private String codigoDelTramoBuscado;

    public BuscarTramoPorCodigo(String codigoDelTramoBuscado) {
        this.codigoDelTramoBuscado = codigoDelTramoBuscado;
    }

    @Override
    public Tramo execute() {
        Session session = SessionManager.getSession();
        Query query = session.createQuery("from Tramo where codigoDelTramo = :codigoDelTramo");
        query.setParameter("codigoDelTramo", this.codigoDelTramoBuscado);
        query.setMaxResults(1);
        return (Tramo) query.uniqueResult();
    }
}
