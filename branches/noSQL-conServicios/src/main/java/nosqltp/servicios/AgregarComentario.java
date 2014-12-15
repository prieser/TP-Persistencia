package main.java.nosqltp.servicios;

import main.java.Collection;
import main.java.SistemDB;
import main.java.nosqltp.exceptions.NoExisteException;
import main.java.nosqltp.model.Comentario;
import main.java.nosqltp.model.Destino;
import main.java.nosqltp.model.Estado;
import main.java.nosqltp.model.Privacidad;
import net.vz.mongodb.jackson.DBQuery;

/**
 * Created by prieser on 15/12/14.
 */
public class AgregarComentario {

    private Collection<Destino> homeDestinos = SistemDB.instance().collection(Destino.class);
    private Comentario comentarioAAgregar;

    public AgregarComentario(String destino, String comentario, Estado estado, Privacidad privacidad) throws NoExisteException {
        comentarioAAgregar = new Comentario(comentario, estado, privacidad);
        Destino destinoGuardado = homeDestinos.getMongoCollection().find(DBQuery.is("nombreDestino", destino)).next();

        if (destinoGuardado == null) {
            throw new NoExisteException("El destino no existe");
        } else {
            destinoGuardado.agregarComentario(comentarioAAgregar);
            homeDestinos.insert(destinoGuardado);
        }

    }
}
