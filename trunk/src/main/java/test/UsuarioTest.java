package test;
import junit.framework.Assert;
import modelo.Usuario;

import org.junit.Test;

import repository.UsuarioRepository;

public class UsuarioTest {

	@Test
	public void testAgregarUsuario() throws Exception  {
		Usuario usuario = new Usuario();
		usuario.setNombre("Sergio");
		usuario.setApellido("Delgadillo");
		usuario.setEmail("sergio.edgardo.delgadillo@gmail.com");
		usuario.setNombreUsuario("sdelgadillo");
		usuario.setFechaDeNacimiento("20140804");
		UsuarioRepository UserRepositorio = new UsuarioRepository();
		UserRepositorio.existe(usuario);
		//UserRepositorio.guardar(usuario);
		
		
	}		
}
