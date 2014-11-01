package modelo.daos;

import modelo.busquedas.Criterio;
import org.hibernate.Session;

public class CriterioDAO {

    public Criterio get(int idCriterio) {
        return (Criterio) SessionManager.getSession().get(Criterio.class, idCriterio);
    }

    public void save(Criterio criterio) {
        SessionManager.getSession().saveOrUpdate(criterio);
    }
}
