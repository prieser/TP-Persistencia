package modelo.busquedas;

import modelo.busquedas.operadores.And;
import modelo.busquedas.operadores.Operador;
import modelo.daos.CriterioDAO;
import modelo.managers.CriteriosManager;
import org.junit.Test;

public class CriterioTest {

    CriteriosManager manager = new CriteriosManager();

    @Test
    public void testGuardarCriterioSimple() {
        manager.crearCriterioSimple("nombre", "Aerolineas A");
    }

    @Test
    public void testGuardarCriterioCompuesto() {
        manager.crearCriterioCompuesto(new CriterioSimple("nombre", "Aerolineas Arg"), new CriterioSimple("nombre", "Austral"), new And());
    }

}
