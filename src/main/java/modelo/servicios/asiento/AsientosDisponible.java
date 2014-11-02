package modelo.servicios.asiento;


import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class AsientosDisponible implements Operation<List<Asiento>> {

    private int idTramo;

    public AsientosDisponible(Tramo tramo) {
        this.idTramo = tramo.getIdTramo();
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Asiento> execute() {
        Session session = SessionManager.getSession();
        Query query = session.createQuery("SELECT asientos FROM Tramo as tramo join tramo.asientos as asientos where tramo.idTramo = :nombreParametro");
        query.setParameter("nombreParametro", this.idTramo);
        return query.list();

    }

}
