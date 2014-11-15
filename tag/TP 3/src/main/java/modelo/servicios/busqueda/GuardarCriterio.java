package modelo.servicios.busqueda;

import modelo.busquedas.Criterio;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class GuardarCriterio implements Operation<Criterio> {

    private String clave;
    private String valor;


    public GuardarCriterio(String clave, String valor) {
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

