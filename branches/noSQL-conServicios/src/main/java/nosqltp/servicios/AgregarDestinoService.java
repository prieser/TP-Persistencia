package nosqltp.servicios;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.YaExisteException;
import nosqltp.model.Destino;
import nosqltp.model.Usuario;

public class AgregarDestinoService {

    private Collection<Destino> homeDestinos = SistemDB.instance().collection(Destino.class);
    private Collection<Usuario> homeUsuarios = SistemDB.instance().collection(Usuario.class);
    private Destino destinoAAgregar;
    private String nombreDeusuarioQueAgregaElDestino;

    public AgregarDestinoService(String nombreDeUsuario, Destino destinoAAgregar) {
    	this.nombreDeusuarioQueAgregaElDestino = nombreDeUsuario;
        this.destinoAAgregar = destinoAAgregar;
    }

    public void ejecutar() throws YaExisteException {
        Usuario usuarioGuardado = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", nombreDeusuarioQueAgregaElDestino)).next();
        usuarioGuardado.agregarDestino(destinoAAgregar);
        homeUsuarios.updateById(usuarioGuardado.getIdUsuario(), usuarioGuardado);
        homeDestinos.insert(destinoAAgregar);
    }
}
