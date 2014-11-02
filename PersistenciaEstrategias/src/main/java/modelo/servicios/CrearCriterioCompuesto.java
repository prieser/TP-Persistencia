package modelo.servicios;

import modelo.busquedas.Criterio;
import modelo.busquedas.CriterioCompuesto;
import modelo.busquedas.operadores.Operador;
import modelo.daos.GenericDAO;

/**
 * Created by prieser on 01/11/14.
 */
public class CrearCriterioCompuesto implements Operation<Criterio> {

    private Criterio criterio1;
    private Criterio criterio2;
    private Operador operation;


    public CrearCriterioCompuesto(Criterio criterio1, Criterio criterio2, Operador operation) {
        super();
        this.criterio1 = criterio1;
        this.criterio2 = criterio2;
        this.operation = operation;
    }

    public Criterio execute() {
        Criterio a = new CriterioCompuesto(criterio1, criterio2, operation);
        new GenericDAO<Criterio>(Criterio.class).save(a);
        return a;
    }
}
