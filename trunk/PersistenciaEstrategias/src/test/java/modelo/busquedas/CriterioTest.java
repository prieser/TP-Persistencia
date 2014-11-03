package modelo.busquedas;

import modelo.managers.CriteriosManager;

import org.junit.Test;

public class CriterioTest {

    CriteriosManager manager = new CriteriosManager();

    @Test
    public void testGuardarCriterioSimple() {
        manager.crearCriterio("nombre", "aldo");
    }

}
