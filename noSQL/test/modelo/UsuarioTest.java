package modelo;

import main.java.Collection;
import main.java.SistemDB;
import main.java.nosqltp.model.Destino;
import main.java.nosqltp.model.Estado;
import main.java.nosqltp.model.Privacidad;
import main.java.nosqltp.model.Usuario;
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
    public void testInsertarUsuario() {
        Usuario usuarioNuevo = new Usuario("USUARIONew");
        homeUsuarios.insert(usuarioNuevo);

        List<Usuario> usuarios = homeUsuarios.getMongoCollection().find(DBQuery.is("nombreDeUsuario", "USUARIONew")).toArray();
        Assert.assertTrue("El usuario debe estar en la lista", usuarios.contains(usuarioNuevo));
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
        Destino destino = new Destino("Me parecio lindo", Estado.MEGUSTA, Privacidad.PUBLICO);
        homeDestinos.insert(destino);

        Destino destinoGuardado = homeDestinos.getMongoCollection().find().next();
        Assert.assertEquals(destino, destinoGuardado);
    }

    @Test
    public void testUsuarioAgregaUnDestino() {
        Usuario usuarioComun = new Usuario("UsuarioComun");
        Destino destino = new Destino("Me parecio feo", Estado.NOMEGUSTA, Privacidad.PUBLICO);
        usuarioComun.agregarDestino(destino);

        homeUsuarios.insert(usuarioComun);

        Usuario usuarioGuardado = homeUsuarios.getMongoCollection().find().next();
        Assert.assertTrue(usuarioGuardado.getDestinos().contains(destino));
    }

}
