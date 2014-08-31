package model;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import junit.framework.Assert;
import modelo.Sistema;
import modelo.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import repository.UsuarioRepository;
import excepciones.NuevaPasswordInválida;
import excepciones.UsuarioYaExisteException;

public class SistemaTest {

    // Necesito tres variables de clase.
    private Usuario usuarioComunYCorriente;
    private Sistema sistema;
    private UsuarioRepository repositorio;
    
    @Before
    public void setUp() throws Exception {
        this.usuarioComunYCorriente = new Usuario("Juan", "Gomez", "juangomez", "jgomez@gmail.com", "20150501", "12345678");
        this.sistema = new Sistema();
        this.repositorio = new UsuarioRepository();
    }

    @After
    public void tearDown() throws Exception {
    	if (repositorio.existe(usuarioComunYCorriente)) {
			repositorio.eliminar(usuarioComunYCorriente);
		}
    }

    @Test 
    public void testRegistrarUsuarioPorPrimeraVez() throws Exception {
        sistema.RegistrarUsuario(usuarioComunYCorriente);
        Assert.assertTrue("El usuario se ha insertado correctamente:", this.repositorio.existe(usuarioComunYCorriente));
    }

    @Test(expected = UsuarioYaExisteException.class)
    public void testRegistrarUsuarioQueYaExisteEnLaBaseDeDatos() throws UsuarioYaExisteException {
        sistema.RegistrarUsuario(usuarioComunYCorriente);
        sistema.RegistrarUsuario(usuarioComunYCorriente);
    }

    @Test
    public void testValidarCuenta() {
        fail("Not yet implemented");
    }

    @Test
    public void testIngresarUsuario() throws NuevaPasswordInválida, SQLException, UsuarioYaExisteException {
        fail("Not yet implemented");
    }

    @Test
    public void testCambiarPassword() throws Exception {

        try {
            sistema.RegistrarUsuario(usuarioComunYCorriente);
        } catch (UsuarioYaExisteException e) {
            e.printStackTrace();
        }
        try {
            sistema.CambiarPassword("juangomez", "12345678", "87654321");
            Connection connection = this.repositorio.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuarios WHERE nombreDeUsuario = juangomez AND contrasenia = 87654321");
            ps.executeQuery();
            Assert.assertEquals("Se espera se haya encontrado al usuario insertado:", 1, ps.getUpdateCount());
        } catch (NuevaPasswordInválida nuevaPasswordInválida) {
            nuevaPasswordInválida.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TODO: ¿como podemos extraer el calor de la consulta para compararlo con el valor esperado?
    }

    /* Metodo auxiliar para conexion con la base de datos */
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/database?user=root&password=root");
    }

}
