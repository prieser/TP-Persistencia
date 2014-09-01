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

	public void CambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInválida {

		PreparedStatement statement;
		Connection connection = null;
		this.usuarioRepository = new UsuarioRepository();

		try {
			connection = this.usuarioRepository.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			statement = connection.prepareStatement("UPDATE usuarios SET contrasenia = ? WHERE nombreDeUsuario = ? AND contrasenia = ?");
			statement.setString(1, nuevaPassword);
			statement.setString(2, userName);
			statement.setString(3, password);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
