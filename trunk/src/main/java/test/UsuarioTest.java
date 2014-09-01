package test;
import junit.framework.Assert;
import modelo.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import repository.UsuarioRepository;

public class UsuarioTest {
	public Usuario usuario1;
	public Usuario usuario1Actualizado;
	public Usuario usuario2;
	public UsuarioRepository userRepositorio = new UsuarioRepository();
	
	@Before
	public void setup() throws Exception{
		//USuario de Prueba
		this.usuario1 = new Usuario();
		this.usuario1.setNombre("Sergio");
		this.usuario1.setApellido("Delgadillo");
		this.usuario1.setEmail("sergio.edgardo.delgadillo@gmail.com");
		this.usuario1.setNombreUsuario("sdelgadillo");
		this.usuario1.setFechaDeNacimiento("20140804");
		this.usuario1.setCodigoDeValidacion("aj2");
		this.usuario1.setActivo(false);
		this.usuario1.setContrasenia("lalala");	
		
		//USuario de Prueba Actualizado
		this.usuario1Actualizado = new Usuario();
		this.usuario1Actualizado.setNombre("Juan");
		this.usuario1Actualizado.setApellido("Perez");
		this.usuario1Actualizado.setEmail("juan.perez@gmail.com");
		this.usuario1Actualizado.setNombreUsuario("sdelgadillo");
		this.usuario1Actualizado.setFechaDeNacimiento("20140805");
		this.usuario1Actualizado.setCodigoDeValidacion("aj3");
		this.usuario1Actualizado.setActivo(false);
		this.usuario1Actualizado.setContrasenia("lololo");
		
		//Otro usuario
		this.usuario2 = new Usuario();
		this.usuario2.setNombre("Pablo");
		this.usuario2.setApellido("Riester");
		this.usuario2.setEmail("pablo.riestrl@gmail.com");
		this.usuario2.setNombreUsuario("priestre");
		this.usuario2.setFechaDeNacimiento("20140805");
		this.usuario2.setCodigoDeValidacion("aj3");
		this.usuario2.setActivo(false);
		this.usuario2.setContrasenia("lololo");
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
		Assert.assertTrue(this.userRepositorio.guardar(this.usuario1));
		Usuario usuario = this.userRepositorio.dameUno("sdelgadillo");
		Assert.assertTrue(this.usuario1.equals(usuario));
		Assert.assertFalse(this.usuario1.equals(this.usuario2));
	}
	
		@Test
		public void testActualizarUsuario() throws Exception{
			String nombreUsuario = this.usuario1.getNombreUsuario();
			this.userRepositorio.guardar(this.usuario1);
			Assert.assertTrue(this.userRepositorio.actualizar(this.usuario1Actualizado));
			Usuario usuario = this.userRepositorio.dameUno(nombreUsuario);
			Assert.assertEquals(usuario, this.usuario1Actualizado) ;
		}
		
		@Test
		public void testActualizarDosVecesUsuario() throws Exception{
			String nombreUsuario = this.usuario1.getNombreUsuario();
			this.userRepositorio.guardar(this.usuario1);
			Assert.assertTrue(this.userRepositorio.actualizar(this.usuario1Actualizado));
			Usuario usuario = this.userRepositorio.dameUno(nombreUsuario);
			Assert.assertEquals(usuario, this.usuario1Actualizado) ;
		}
		
		@Test
		public void testEliminaUsuario() throws Exception{
			Assert.assertFalse(this.userRepositorio.eliminar(this.usuario1));
			this.userRepositorio.guardar(this.usuario1);
			Assert.assertTrue(this.userRepositorio.eliminar(this.usuario1));		
		}
}
