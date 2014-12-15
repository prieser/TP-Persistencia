package nosqltp.servicios;

import java.util.List;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.NoExisteException;
import nosqltp.model.Comentario;
import nosqltp.model.Destino;

public class VerComentariosDeUnDestinoService {
	
	private Collection<Destino> homeDestinos = SistemDB.instance().collection(Destino.class);
	private String nombreDelDestino;
	
	public VerComentariosDeUnDestinoService(String nombreDelDestino) {
		super();
		this.nombreDelDestino = nombreDelDestino;
	}
	
	public List<Comentario> ejecutar() throws NoExisteException {
        Destino destinoBuscado = homeDestinos.getMongoCollection().find(DBQuery.is("nombreDestino", this.nombreDelDestino)).next();
        if(destinoBuscado == null) {
        	throw new NoExisteException("El destino buscado no existe");
        } else {
        	return destinoBuscado.getComentarios();
        }
	}
	
	


}
