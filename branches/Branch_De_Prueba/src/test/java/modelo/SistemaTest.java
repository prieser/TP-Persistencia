package modelo;

import excepciones.UsuarioYaExisteException;
import junit.framework.Assert;
import modelo.usuario.Sistema;
import modelo.usuario.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import repository.UsuarioRepository;

@SuppressWarnings("deprecation")
public class SistemaTest {

    // Necesito tres variables de clase.
    private Usuario usuarioComunYCorriente;
    private Usuario usuarioRegistradoNoActivado;
    private Usuario usuarioRegistradoActivado;
    private Sistema sistema;
    private UsuarioRepository repositorio;

    @Before
    public void setUp() throws Exception {
        this.usuarioComunYCorriente = new Usuario("Juan", "Gomez", "juangomez", "jgomez@gmail.com", "20150501", "12345678");
        this.sistema = new Sistema();
        this.repositorio = new UsuarioRepository();

        this.usuarioRegistradoNoActivado = new Usuario("Jose", "Godoy", "josegodoy", "jgodoy@gmail.com", "20140501", "qwerty123");
        this.usuarioRegistradoNoActivado.setCodigoDeValidacion("xxxcodigoxxx");
        this.usuarioRegistradoNoActivado.setActivo(false);
        this.repositorio.guardar(usuarioRegistradoNoActivado);

        this.usuarioRegistradoActivado = new Usuario("Juan", "Zamora", "juanzamora", "jzamora@gmail.com", "20130622", "asdqweasd");
        this.usuarioRegistradoActivado.setActivo(true);
        this.repositorio.guardar(usuarioRegistradoActivado);

    }

    /**
     * Elimino los dos usuarios de prueba que podrian estar cargados en la base de datos.
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        if (repositorio.existe(usuarioComunYCorriente)) {
            repositorio.eliminar(usuarioComunYCorriente);
        }

        if (repositorio.existe(usuarioRegistradoNoActivado)) {
            repositorio.eliminar(usuarioRegistradoNoActivado);
        }
    }

    @Test
    public void testRegistrarUsuarioPorPrimeraVez() throws Exception {
        sistema.RegistrarUsuario(usuarioComunYCorriente);
        Assert.assertTrue("El usuario se ha insertado correctamente:", this.repositorio.existe(usuarioComunYCorriente));
    }

    @Test(expected = UsuarioYaExisteException.class)
    public void testRegistrarUsuarioQueYaExisteEnLaBaseDeDatos() throws Exception {
        sistema.RegistrarUsuario(usuarioComunYCorriente);
        sistema.RegistrarUsuario(usuarioComunYCorriente);
    }

    @Test
    public void testValidarCuenta() throws Exception {
        sistema.ValidarCuenta("xxxcodigoxxx");
        Assert.assertTrue("Se espera que el usuario se encuentre activo:", this.repositorio.dameUnoConCodigoDeValidacion("xxxcodigoxxx").isActivo());
    }

    @Test
    public void testIngresarUsuario() throws Exception {
        Usuario usuarioEsperado = this.repositorio.dameUno("juanzamora");
        Usuario usuarioIngresante = sistema.IngresarUsuario("juanzamora", "asdqweasd");
        Assert.assertEquals(usuarioEsperado, usuarioIngresante);
    }

    @Test
    public void testCambiarPassword() throws Exception {

        sistema.CambiarPassword("josegodoy", "qwerty123", "nuevaContras");
        Assert.assertEquals("Se espera que las password se haya modificado correctamente:", "nuevaContras", this.repositorio.dameUno("josegodoy").getContrasenia());
    }
}
