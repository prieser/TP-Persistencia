package test;
import junit.framework.Assert;
import modelo.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import repository.UsuarioRepository;

public class UsuarioTest {
	public Usuario usuario1;
	public UsuarioRepository userRepositorio = new UsuarioRepository();
	
	@Before
	public void setup() throws Exception{
		this.usuario1 = new Usuario();
		this.usuario1.setNombre("Sergio");
		this.usuario1.setApellido("Delgadillo");
		this.usuario1.setEmail("sergio.edgardo.delgadillo@gmail.com");
		this.usuario1.setNombreUsuario("sdelgadillo");
		this.usuario1.setFechaDeNacimiento("20140804");
		this.usuario1.setCodigoDeValidacion("aj2");
		this.usuario1.setActivo(false);
		this.usuario1.setContrasenia("lalala");	
	}
	
	@After
	public void tearDown() throws Exception{
		this.userRepositorio.eliminar(this.usuario1);
	}
	
		
	@Test
	public void testAgregarUsuarioDosVeces() throws Exception  {
		//Debe guardar el usuario y al intentar guardarlo otra vez no deberia poder
		Assert.assertTrue(this.userRepositorio.guardar(this.usuario1));
		Assert.assertFalse(this.userRepositorio.guardar(this.usuario1));
	}
	
	@Test
	public void testAgregarYTraerUsuario() throws Exception{
		this.userRepositorio.guardar(this.usuario1);
		Usuario usuarioRecibido = this.userRepositorio.dameUno("sdelgadillo");
		Assert.assertTrue(this.usuario1.equals(usuarioRecibido));
		System.out.println(this.usuario1.getNombreUsuario());
		System.out.println(usuarioRecibido.getNombreUsuario());
	}
	
	
}
