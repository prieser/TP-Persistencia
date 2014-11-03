package modelo.servicios;

import modelo.busquedas.Criterio;
import modelo.daos.GenericDAO;

/**
 * Created by prieser on 01/11/14.
 */
public class CrearCriterio implements Operation<Criterio> {

    private String clave;
    private String valor;


    public CrearCriterio(String clave, String valor) {
        super();
        this.clave = clave;
        this.valor = valor;
    }

    public Criterio execute() {
        Criterio a = new Criterio(clave, valor);
        new GenericDAO<Criterio>(Criterio.class).save(a);
        return a;
    }
}

