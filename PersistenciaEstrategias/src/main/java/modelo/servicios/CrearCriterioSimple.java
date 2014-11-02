package modelo.servicios;

import modelo.busquedas.Criterio;
import modelo.busquedas.CriterioSimple;
import modelo.daos.GenericDAO;

/**
 * Created by prieser on 01/11/14.
 */
public class CrearCriterioSimple implements Operation<Criterio> {

    private String clave;
    private String valor;


    public CrearCriterioSimple(String clave, String valor) {
        super();
        this.clave = clave;
        this.valor = valor;
    }

    public Criterio execute() {
        Criterio a = new CriterioSimple(clave, valor);
        new GenericDAO<Criterio>(Criterio.class).save(a);
        return a;
    }
}

