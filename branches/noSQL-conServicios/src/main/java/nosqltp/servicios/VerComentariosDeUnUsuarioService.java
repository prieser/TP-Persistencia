package nosqltp.servicios;

import java.util.List;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.YaExisteException;
import nosqltp.model.Comentario;

public class VerComentariosDeUnUsuarioService {
	
    private Collection<Comentario> homeComentarios = SistemDB.instance().collection(Comentario.class);
	private String nombreDeUsuario;

	public VerComentariosDeUnUsuarioService(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public List<Comentario> ejecutar() throws YaExisteException {
		List<Comentario> comentariosDelUsuario = homeComentarios.getMongoCollection().find(DBQuery.is("nombreDelComentador", nombreDeUsuario)).toArray();
        return comentariosDelUsuario;
	}
}
