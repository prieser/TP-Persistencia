package modelo.servicios.busqueda;

import modelo.busquedas.Busqueda;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;

public class GuardarBusqueda implements Operation<Busqueda> {

    private Usuario usuarioQueRealizaBusqueda;

    public GuardarBusqueda(Usuario usuarioQueRealizaBusqueda) {
        this.usuarioQueRealizaBusqueda = usuarioQueRealizaBusqueda;
    }

    @Override
    public Busqueda execute() {
        Busqueda a = new Busqueda(usuarioQueRealizaBusqueda);
        new GenericDAO<Busqueda>(Busqueda.class).save(a);
        return a;
    }
}
