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
	 * @param usuarioNuevo
	 * @throws UsuarioYaExisteException
	 */
	public void RegistrarUsuario(Usuario usuarioNuevo) throws UsuarioYaExisteException {

		this.usuarioRepository = new UsuarioRepository();

		try {
			if (!usuarioRepository.existe(usuarioNuevo)) {
				this.usuarioRepository.guardar(usuarioNuevo);
			} else {
				throw new UsuarioYaExisteException();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ValidarCuenta(String codigoValidación) throws ValidaciónException {

	}

	public Usuario IngresarUsuario(String userName, String password) throws UsuarioNoExiste {
		return null;

	}

	public void CambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInválida {
//
//		try {
//			this.connection = this.getConnection();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//
//			this.statementDeConsulta = connection.prepareStatement("UPDATE usuarios SET contraseña = ? WHERE nombreDeUsuario = ? AND contraseña = password");
//			statementDeConsulta.setString(1, nuevaPassword);
//			statementDeConsulta.setString(2, userName);
//			statementDeConsulta.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
	}

	/* Metodo auxiliar para conexion con la base de datos */
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/database?user=root&password=root");
	}
}
