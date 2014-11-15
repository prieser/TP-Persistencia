package modelo.managers;

import modelo.aerolinea.Asiento;
import modelo.daos.GenericDAO;
import modelo.daos.SessionManager;

import org.hibernate.Query;
import org.hibernate.Session;

public class AsientoManager {
	
	public void guardarAsiento(Asiento asiento) {
		new GenericDAO<Asiento>(Asiento.class).save(asiento);
	}
	
	public Asiento buscarAsiento(int numeroDeAsiento) {
		Session session = SessionManager.getSession();
		Query query = session.createQuery("SELECT Asiento from Asiento where NUMERO_ASIENTO = :numeroParametro");
        query.setParameter("numeroParametro", numeroDeAsiento);
        query.setMaxResults(1);
        return (Asiento) query.uniqueResult();
	}

}
