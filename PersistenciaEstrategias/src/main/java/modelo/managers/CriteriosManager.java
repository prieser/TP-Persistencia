package modelo.managers;

import modelo.daos.SessionManager;
import modelo.servicios.CrearCriterio;

/**
 * Created by prieser on 01/11/14.
 */
public class CriteriosManager {

    public void crearCriterio(String clave, String valor) {
        SessionManager.runInSession(new CrearCriterio(clave, valor));
    }
}
