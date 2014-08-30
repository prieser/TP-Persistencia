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

import excepciones.UsuarioYaExisteException;

public class SistemaTest {

    // Necesito tres variables de clase.
    private Usuario usuarioComunYCorriente;
    private Sistema sistema;
    private Connection connection;
    private PreparedStatement ps;

    @Before
    public void setUp() throws Exception {
        // Instancio el sistema y el usuario. Asigno estas instancias a las variables de clase. Por ultimo pido una conexion con la base de datos.
        usuarioComunYCorriente = new Usuario("Juan", "Gomez", "juangomez", "jgomez@gmail.com", "01/08/2015");
        sistema = new Sistema();
        this.connection = this.getConnection();
    }

    @After
    public void tearDown() throws Exception {
        if (this.connection != null) {
            this.connection.close(); // Cierro la conexion con la base de datos
        }
        if (this.ps != null) {
            this.ps.close(); // Cierro el statement.
        }
    }

    @Test
    public void testRegistrarUsuarioPorPrimeraVez() throws UsuarioYaExisteException, SQLException {
        sistema.RegistrarUsuario(usuarioComunYCorriente);
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM usuarios WHERE nombre = Juan AND apellido = Gomez AND nombreDeUsuario = juangomez AND email = jgomez@gmail.com");
        ps.execute();
        Assert.assertEquals("Se espera se haya encontrado al usuario insertado:", 1, ps.getUpdateCount());
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
    public void testIngresarUsuario() {
        fail("Not yet implemented");
    }

    @Test
    public void testCambiarPassword() {
        fail("Not yet implemented");
    }

    /* Metodo auxiliar para conexion con la base de datos */
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/database?user=root&password=root");
    }

}
