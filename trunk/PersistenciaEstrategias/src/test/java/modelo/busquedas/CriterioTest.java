package modelo.busquedas;

import modelo.busquedas.operadores.Operador2;
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
        manager.crearCriterioCompuesto(new CriterioSimple("nombre", "Aerolineas Arg"), new CriterioSimple("nombre", "Austral"), Operador2.AND);
    }

}
