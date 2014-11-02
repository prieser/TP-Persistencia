package modelo.managers;

import modelo.busquedas.Criterio;
import modelo.busquedas.operadores.Operador;
import modelo.daos.SessionManager;
import modelo.servicios.CrearCriterioCompuesto;
import modelo.servicios.CrearCriterioSimple;

/**
 * Created by prieser on 01/11/14.
 */
public class CriteriosManager {

    public void crearCriterioSimple(String clave, String valor) {
        SessionManager.runInSession(new CrearCriterioSimple(clave, valor));
    }

    public void crearCriterioCompuesto(Criterio c1, Criterio c2, Operador op) {
        SessionManager.runInSession(new CrearCriterioCompuesto(c1, c2, op));
    }
}
