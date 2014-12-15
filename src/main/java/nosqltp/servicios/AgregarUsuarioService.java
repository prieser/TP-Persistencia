package main.java.nosqltp.servicios;

import main.java.Collection;
import main.java.SistemDB;
import main.java.nosqltp.exceptions.YaExisteException;
import main.java.nosqltp.model.Destino;
import main.java.nosqltp.model.Usuario;
import net.vz.mongodb.jackson.DBQuery;

import java.util.List;

public class AgregarUsuarioService {

    private Collection<Usuario> homeUsuarios = SistemDB.instance().collection(Usuario.class);
    private Usuario usuarioAAgregar;

    public AgregarUsuarioService(Usuario usuarioAAgregar) {
        this.usuarioAAgregar = usuarioAAgregar;
    }

    public void ejecutar() throws YaExisteException {
        List<Usuario> usuarios = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", usuarioAAgregar.getNombreDeUsuario())).toArray();

        if (!usuarios.contains(this.usuarioAAgregar)) {
            homeUsuarios.insert(this.usuarioAAgregar);
        } else {
            throw new YaExisteException("El objeto que intena guardar ya existe");
        }
    }
}
