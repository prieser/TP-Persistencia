package modelo;

import excepciones.NuevaPasswordInválida;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidaciónException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import repository.UsuarioRepository;

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
	 * Antes de hacerlo, verifica que su password actual sea correcta.
	 * @param userName
	 * @param password
	 * @param nuevaPassword
	 * @throws Exception
	 */
	public void CambiarPassword(String userName, String password, String nuevaPassword) throws Exception {
		
		this.usuarioRepository = new UsuarioRepository();
		if (usuarioRepository.sonValidosElUsernameYPassword(userName, password)) {
			this.usuarioRepository.actualizarPassword(userName, nuevaPassword);
		}
	}

}
