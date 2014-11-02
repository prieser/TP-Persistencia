package modelo.servicios;

import modelo.daos.GenericDAO;
import modelo.usuario.Usuario;

public class GuardarUsuario implements Operation<Object> {


    private Usuario usuario;

    public GuardarUsuario(Usuario usuario) {
        this.usuario = usuario;

    }

    @Override
    public Object execute() {
        new GenericDAO<Usuario>(Usuario.class).save(this.usuario);
        return null;

    }

}
