package modelo;

import main.java.Collection;
import main.java.SistemDB;
import main.java.nosqltp.exceptions.NoExisteException;
import main.java.nosqltp.exceptions.YaExisteException;
import main.java.nosqltp.model.Destino;
import main.java.nosqltp.model.Estado;
import main.java.nosqltp.model.Privacidad;
import main.java.nosqltp.model.Usuario;
import main.java.nosqltp.servicios.Servicios;
import net.vz.mongodb.jackson.DBQuery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
        Assert.assertTrue(usuarios.size() == 1);
    }

    @Test (expected = YaExisteException.class)
    public void testGuardarUsuarioRepetido() throws YaExisteException {
        Servicios.agregarUsuario("USUARIONew");
        Servicios.agregarUsuario("USUARIONew");
    }

    @Test
    public void testSeguirOtroUsuario() {
        Usuario usuarioComun = new Usuario("UsuarioComun");
        Usuario usuarioFamoso = new Usuario("UsuarioFamoso");
        usuarioComun.seguir(usuarioFamoso);

        homeUsuarios.insert(usuarioComun);
        homeUsuarios.insert(usuarioFamoso);

        List<Usuario> usuariosGuardados = homeUsuarios.getMongoCollection().find().toArray();
        Usuario usuarioGuardado = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", "UsuarioComun")).next();
        Assert.assertTrue("El usuario comun debe estar en la lista", usuariosGuardados.contains(usuarioComun));
        Assert.assertTrue("El usuario famoso debe estar en la lista", usuariosGuardados.contains(usuarioFamoso));
        Assert.assertTrue("El usuario comun debe seguir al famoso", usuarioGuardado.isSeguidor(usuarioFamoso)); // ACa se puede terminar si supera como obtener el usuario y no el array de usuarios.
    }

    @Test
    public void testGuardarUnDestino(){
        Destino destino = new Destino("Cancun");
        homeDestinos.insert(destino);

        Destino destinoGuardado = homeDestinos.getMongoCollection().find().next();
        Assert.assertEquals(destino, destinoGuardado);
    }

    @Test
    public void testUsuarioAgregaUnDestino() {
        Usuario usuarioComun = new Usuario("UsuarioComun");
        Destino destino = new Destino("Mar del Plata");
        usuarioComun.agregarDestino(destino);

        homeUsuarios.insert(usuarioComun);

        Usuario usuarioGuardado = homeUsuarios.getMongoCollection().find().next();
        Assert.assertTrue(usuarioGuardado.getDestinos().contains(destino));
    }

    @Test
    public void testTraerComentariosPublicos() throws YaExisteException, NoExisteException {
        Servicios.agregarDestino("Mar Del Plata");
        Servicios.comentarDestino("Mar Del Plata", "Me gusto mucho", Estado.MEGUSTA, Privacidad.PUBLICO);
        Servicios.comentarDestino("Mar Del Plata", "Me gusto bastante", Estado.MEGUSTA, Privacidad.PUBLICO);
        Servicios.comentarDestino("Mar Del Plata", "Me gusto bastante", Estado.MEGUSTA, Privacidad.PRIVADO);

    }
}
