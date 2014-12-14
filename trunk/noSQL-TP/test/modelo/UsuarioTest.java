package modelo;

import main.java.Collection;
import main.java.SistemDB;
import main.java.nosqltp.model.Usuario;
import net.vz.mongodb.jackson.DBQuery;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UsuarioTest {

    private Collection<Usuario> home = SistemDB.instance().collection(Usuario.class);

    @Test
    public void testInsertarUsuario() {

        Usuario usuarioNuevo = new Usuario("USERNEW01");
        home.insert(usuarioNuevo);

        List<Usuario> usuarios = home.getMongoCollection().find(DBQuery.is("idUsuario", "USERNEW01")).toArray();
        Assert.assertTrue("El usuario debe estar en la lista", usuarios.contains(usuarioNuevo));

    }

}
