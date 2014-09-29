package modelo.servicios;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;

public class AsientosDisponible implements Operation<Set<Asiento>> {

    private int idTramo;

    public  AsientosDisponible(Tramo tramo) {
        this.idTramo = tramo.getIdTramo();
    }
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Asiento> execute() {
		
	 	Session session = SessionManager.getSession();
	 	Query query = session.createQuery("SELECT asientos FROM Tramo as tramo join Tramo.asientos as asientos where tramo.idTramo = :nombreParametro");
        query.setParameter("nombreParametro", this.idTramo);
		@SuppressWarnings("rawtypes")
		Set resultado =  (Set) query.list();
        return resultado ;
	}

}
