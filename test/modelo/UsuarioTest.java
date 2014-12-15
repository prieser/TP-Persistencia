package modelo;

import java.util.List;

import net.vz.mongodb.jackson.DBQuery;
import nosqltp.Collection;
import nosqltp.SistemDB;
import nosqltp.exceptions.NoExisteException;
import nosqltp.exceptions.YaExisteException;
import nosqltp.model.Destino;
import nosqltp.model.Estado;
import nosqltp.model.Privacidad;
import nosqltp.model.Usuario;
import nosqltp.servicios.Servicios;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioTest {

    private Collection<Usuario> homeUsuarios = SistemDB.instance().collection(Usuario.class);
    private Collection<Destino> homeDestinos = SistemDB.instance().collection(Destino.class);

    @After
    public void cleanDB() {
        homeUsuarios.getMongoCollection().drop();
        homeDestinos.getMongoCollection().drop();
    }

    @Test
    public void testGuardarUsuario() throws YaExisteException {
        Servicios.agregarUsuario("USUARIONew");
        List<Usuario> usuarios = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", "USUARIONew")).toArray();
        
        //Como deberia ser el assert?
        Assert.assertTrue(usuarios.size() == 1);
    }

    @Test (expected = YaExisteException.class)
    public void testGuardarUsuarioRepetido() throws YaExisteException {
        Servicios.agregarUsuario("USUARIONew");
        Servicios.agregarUsuario("USUARIONew");
    }

  
    @Test
    public void testGuardarUnDestino() throws YaExisteException{
        Servicios.agregarUsuario("Usuario");
    	Servicios.agregarDestino("Usuario", "Cancun");
    	
        Destino destinoGuardado = homeDestinos.getMongoCollection().find(DBQuery.is("nombreDestino", "Cancun")).next();
    }

    @Test
    public void testTraerComentariosPublicos() throws YaExisteException, NoExisteException {
    	 Servicios.agregarUsuario("Usuario");
        Servicios.agregarDestino("Usuario", "Mar Del Plata");
        Servicios.comentarDestino("Usuario", "Mar Del Plata", "Me gusto mucho", Estado.MEGUSTA, Privacidad.PUBLICO);
        Servicios.comentarDestino("Usuario", "Mar Del Plata", "Me gusto bastante", Estado.MEGUSTA, Privacidad.PUBLICO);
        Servicios.comentarDestino("Usuario", "Mar Del Plata", "Me gusto bastante", Estado.MEGUSTA, Privacidad.PRIVADO);

    }
}
