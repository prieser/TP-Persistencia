package model;

import static org.junit.Assert.*;
import modelo.Sistema;
import modelo.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.UsuarioYaExisteException;

public class SistemaTest {

	// Necesito dos variables de la clase
	private Usuario usuarioComunYCorriente;
	private Sistema sistema;

	@Before
	public void setUp() throws Exception {
		// Instancio el sistema y el usuario. Asigno estas instancias a las variables.
		usuarioComunYCorriente = new Usuario("Juan", "Gomez", "juangomez", "jgomez@gmail.com", "01/08/2015");
		sistema = new Sistema();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testRegistrarUsuarioPorPrimeraVez() throws UsuarioYaExisteException {
		sistema.RegistrarUsuario(usuarioComunYCorriente);
		// TODO: Falta agregar el assert que verifique si efecticamente se guardo el usuario en la db.
	}

	@Test (expected = UsuarioYaExisteException.class)
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

}
