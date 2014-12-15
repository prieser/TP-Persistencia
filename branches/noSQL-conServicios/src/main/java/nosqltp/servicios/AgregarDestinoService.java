package main.java.nosqltp.servicios;

import main.java.Collection;
import main.java.SistemDB;
import main.java.nosqltp.exceptions.YaExisteException;
import main.java.nosqltp.model.Destino;
import net.vz.mongodb.jackson.DBQuery;

import java.util.List;

public class AgregarDestinoService {

    private Collection<Destino> homeDestinos = SistemDB.instance().collection(Destino.class);
    private Destino destinoAAgregar;

    public AgregarDestinoService(Destino destinoAAgregar) {
        this.destinoAAgregar = destinoAAgregar;
    }

    public void ejecutar() throws YaExisteException {
        List<Destino> destinos = homeDestinos.getMongoCollection().find(DBQuery.is("nombreDestino", destinoAAgregar.getNombreDestino())).toArray();

        if (!destinos.contains(this.destinoAAgregar)) {
            homeDestinos.insert(this.destinoAAgregar);
        } else {
            throw new YaExisteException("El objeto que intena guardar ya existe");
        }
    }
}
