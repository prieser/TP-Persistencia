package nosqltp.servicios;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.NoExisteException;
import nosqltp.model.Comentario;
import nosqltp.model.Destino;
import nosqltp.model.Estado;
import nosqltp.model.Privacidad;
import nosqltp.model.Usuario;

/**
 * Created by prieser on 15/12/14.
 */
public class AgregarComentario {

    private Collection<Destino> homeDestinos = SistemDB.instance().collection(Destino.class);
    private Collection<Usuario> homeUsuarios = SistemDB.instance().collection(Usuario.class);
    private Collection<Comentario> homeComentarios = SistemDB.instance().collection(Comentario.class);
    private Comentario comentarioAAgregar;

    public AgregarComentario(String nombreDeUsuario, String destino, String comentario, Estado estado, Privacidad privacidad) throws NoExisteException {
        comentarioAAgregar = new Comentario(nombreDeUsuario,comentario, estado, privacidad);
       
        Destino destinoGuardado = homeDestinos.getMongoCollection().find(DBQuery.is("nombreDestino", destino)).next();
        Usuario usuarioGuardado = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", nombreDeUsuario)).next();
        
        if (destinoGuardado == null || usuarioGuardado == null) {
            throw new NoExisteException("El destino o el usuario no existen");
        } else {
            destinoGuardado.agregarComentario(comentarioAAgregar);
            usuarioGuardado.agregarComentario(destino, comentarioAAgregar);
            
            homeDestinos.updateById(destinoGuardado.getIdDestino(), destinoGuardado);
            homeUsuarios.updateById(usuarioGuardado.getIdUsuario(), usuarioGuardado);
            homeComentarios.insert(comentarioAAgregar);
        }

    }
}
