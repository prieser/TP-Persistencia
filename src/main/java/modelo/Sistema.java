package modelo;

import repository.UsuarioRepository;
import excepciones.NuevaPasswordInválidaException;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidaciónException;

public class Sistema {

	private UsuarioRepository usuarioRepository;

	/**
	 * Este metodo se encarga de registrar al usuario que recibe por parametros. Antes de eso verifica que no exista ya un usuario.
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

	public void ValidarCuenta(String codigoValidación) throws ValidaciónException {

	}

	public Usuario IngresarUsuario(String userName, String password) throws UsuarioNoExiste {
		return null;

	}

	/** 
	 * Este metodo cambia la contrasenia del usuario userName por una nueva. 
	 * Antes de hacerlo, verifica que su password actual sea correcta. Si es incorrecta lanza una excepcion.
	 * @param userName
	 * @param viejaPassword
	 * @param nuevaPassword
	 * @throws Exception
	 */
	public void CambiarPassword(String userName, String viejaPassword, String nuevaPassword) throws Exception {
		this.usuarioRepository = new UsuarioRepository();
		Usuario usuario = this.usuarioRepository.dameUno(userName);
		if (viejaPassword.equals(usuario.getContrasenia())) {
			usuario.setContrasenia(nuevaPassword);
			this.usuarioRepository.actualizar(usuario);
		} else {
			throw new NuevaPasswordInválidaException();
		}
	}

}
