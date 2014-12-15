package nosqltp.servicios;

import java.util.List;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.YaExisteException;
import nosqltp.model.Comentario;
import nosqltp.model.Usuario;

public class VerComentariosDeUnUsuarioService {
	
	private Collection<Usuario> homeUsuarios = SistemDB.instance().collection(Usuario.class);
	private String nombreDeUsuario;

	public VerComentariosDeUnUsuarioService(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public List<Comentario> ejecutar() throws YaExisteException {
		List<Comentario> comentariosDelUsuario;
        Usuario usuarioGuardado = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", nombreDeUsuario)).next();
        comentariosDelUsuario = usuarioGuardado.getAllComentarios();
        
        // ¿Y si quiero los comentarios con estado publico? ¿Va en la query o en la logica java?
        return comentariosDelUsuario;
	}
}
