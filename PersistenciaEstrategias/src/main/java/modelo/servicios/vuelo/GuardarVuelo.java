package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

/**
 * Created by Pablo Rieser on 07/11/2014.
 */
public class GuardarVuelo implements Operation<Vuelo> {

    private Vuelo vueloAGuardar;

    public GuardarVuelo(Vuelo vueloAGuardar) {
        this.vueloAGuardar = vueloAGuardar;
    }

    @Override
    public Vuelo execute() {
        new GenericDAO<Vuelo>(Vuelo.class).save(this.vueloAGuardar);
        return null;
    }
}
