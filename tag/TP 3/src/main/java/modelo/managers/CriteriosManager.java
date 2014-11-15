package modelo.managers;

import modelo.busquedas.Criterio;
import modelo.daos.SessionManager;
import modelo.servicios.busqueda.GuardarCriterio;

public class CriteriosManager {

    public Criterio crearCriterio(String clave, String valor) {
       return SessionManager.runInSession(new GuardarCriterio(clave, valor));
    }
}
