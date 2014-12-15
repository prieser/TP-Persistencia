package nosqltp.servicios;

import java.util.List;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.YaExisteException;
import nosqltp.model.Usuario;

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
