package modelo;

import repository.UsuarioRepository;
import excepciones.NuevaPasswordInválidaException;
import excepciones.PasswordIncorrectaException;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidaciónException;

public class Sistema {

	private UsuarioRepository usuarioRepository;

	/**
	 * Este metodo se encarga de registrar al usuario que recibe por parametros.
	 * Antes de eso verifica que no exista ya un usuario.
	 * 
	 * @param usuarioNuevo
	 * @throws UsuarioYaExisteException
	 */
	public void RegistrarUsuario(Usuario usuarioNuevo) throws Exception {

		this.usuarioRepository = new UsuarioRepository();

		if (!usuarioRepository.existe(usuarioNuevo)) {
			this.usuarioRepository.guardar(usuarioNuevo);
		} else {
			throw new UsuarioYaExisteException();
		}
	}

	/**
	 * Este metodo valida al usuario que tiene el codigo validacion pasado como
	 * parametro.
	 * 
	 * @param codigoValidación
	 * @throws Exception
	 */
	public void ValidarCuenta(String codigoValidación) throws Exception {
		this.usuarioRepository = new UsuarioRepository();
		Usuario usuario = this.usuarioRepository.dameUnoConCodigoDeValidacion(codigoValidación);
		if (usuario == null) {
			throw new ValidaciónException();
		} else {
			usuario.setActivo(true);
			this.usuarioRepository.actualizar(usuario);
		}

	}

	public Usuario IngresarUsuario(String userName, String password) throws Exception {
		this.usuarioRepository = new UsuarioRepository();
		Usuario usuario = this.usuarioRepository.dameUno(userName);
		
		if (usuario == null) {
			throw new UsuarioNoExiste();
		}
		
		if (password.equals(usuario.getContrasenia()) && (usuario.getActivo() == true)) {
			usuario = null;
		} else {
			throw new PasswordIncorrectaException();
		}
		return usuario;
	}

	/**
	 * Este metodo cambia la contrasenia del usuario userName por una nueva.
	 * Antes de hacerlo, verifica que su password actual sea correcta. Si es
	 * incorrecta lanza una excepcion.
	 * 
	 * @param userName
	 * @param viejaPassword
	 * @param nuevaPassword
	 * @throws Exception
	 */
	public void CambiarPassword(String userName, String viejaPassword,
			String nuevaPassword) throws Exception {
		this.usuarioRepository = new UsuarioRepository();
		Usuario usuario = this.usuarioRepository.dameUno(userName);
		if (viejaPassword.equals(nuevaPassword)) {
			throw new NuevaPasswordInválidaException();
		} else {
			usuario.setContrasenia(nuevaPassword);
			this.usuarioRepository.actualizar(usuario);
		}
	}

}
