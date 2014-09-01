package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Home;
import modelo.Usuario;

public class UsuarioRepository extends Repository implements Home<Usuario> {

	public boolean guardar(Usuario usuario) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean guardoObjecto = false;
		try {
			if (!this.existe(usuario)) {
				conn = this.getConnection();
				ps = conn.prepareStatement("INSERT INTO usuarios (nombre,apellido,nombreDeUsuario,email,fechaDeNacimiento,codigoValidacion,activo,contrasenia) VALUE (?,?,?,?,?,?,?,?)");
				ps.setString(1, usuario.getNombre());
				ps.setString(2, usuario.getApellido());
				ps.setString(3, usuario.getNombreUsuario());
				ps.setString(4, usuario.getEmail());
				ps.setString(5, usuario.getFechaDeNacimiento());
				ps.setString(6, usuario.getCodigoDeValidacion());
				ps.setBoolean(7, usuario.getActivo());
				ps.setString(8, usuario.getContrasenia());
				ps.execute();
				guardoObjecto = true;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return guardoObjecto;
	}

	public boolean existe(Usuario usuario) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("select 1 from usuarios where nombreDeUsuario= ? limit 0,1");
			ps.setString(1, usuario.getNombreUsuario());
			ResultSet rs = ps.executeQuery();
			Integer filasEncontradas = 0;
			while (rs.next()) {
				filasEncontradas = rs.getInt("1");
			}

			if (1 == filasEncontradas) {
				result = true;
			}
			ps.close();
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}

	public boolean actualizar(Usuario usuario) throws Exception {
		boolean updated = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("update usuarios set nombre = ? ,apellido = ?, email = ?, fechaDeNacimiento = ? ,codigoValidacion = ?, activo = ?, contrasenia = ? where nombreDeUsuario = ?)");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getFechaDeNacimiento());
			ps.setString(5, usuario.getNombreUsuario());
			ps.setString(6, usuario.getCodigoDeValidacion());
			ps.setBoolean(7, usuario.getActivo());
			ps.setString(8, usuario.getContrasenia());
			ps.execute();
			if (1 == ps.getUpdateCount()) {
				updated = true;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return updated;
	}

	public Usuario dameUno(Usuario usuario) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		Usuario UsuarioEncontrado = new Usuario();
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("select * from usuarios where nombreDeUsuario= ? limit 0,1");
			ps.setString(1, usuario.getNombreUsuario());
			ResultSet rs = ps.executeQuery();
			// if (1 != rs.getRow()){
			// throw new UsuarioYaExisteException();
			// }
			while (rs.next()) {
				UsuarioEncontrado.setNombre(rs.getString("nombre"));
				UsuarioEncontrado.setApellido(rs.getString("apellido"));
				UsuarioEncontrado.setEmail(rs.getString("email"));
				UsuarioEncontrado.setContrasenia(rs.getString("contrasenia"));
				UsuarioEncontrado.setActivo(rs.getBoolean("activo"));
				UsuarioEncontrado.setCodigoDeValidacion(rs.getString("codigoValidacion"));
				UsuarioEncontrado.setNombreUsuario(rs.getString("nombreDeUsuario"));
				UsuarioEncontrado.setFechaDeNacimiento(rs.getString("fechaDeNacimiento"));
			}

			ps.close();
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		return UsuarioEncontrado;
	}

	public boolean eliminar(Usuario usuario) throws Exception {
		boolean updated = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("delete from usuarios where nombreDeUsuario = ?");
			ps.setString(1, usuario.getNombreUsuario());
			ps.execute();
			if (1 == ps.getUpdateCount()) {
				updated = true;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return updated;
	}

	/**
	 * Este metodo recibe un nombre de usuario y una password y se encarga de validar si hay un usuario en la db que tenga esas credenciales. Este metodo se usa para verificar antes de cambiar el password y para el login de usuarios al sistema.
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public boolean sonValidosElUsernameYPassword(String username, String password) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;

		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("select 1 from usuarios where nombreDeUsuario= ? AND contrasenia = ? limit 0,1");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			Integer filasEncontradas = 0;
			while (rs.next()) {
				filasEncontradas = rs.getInt("1");
			}

			if (1 == filasEncontradas) {
				result = true;
			}
			ps.close();
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		return result;
	}

	/**
	 * Este metodo actualiza el password de un usuario por el recibido por parametros. 
	 * Se asume que ya se verifico que el usuario pueda realizar esta operacion.
	 * @param username
	 * @param nuevaPassword
	 * @return
	 * @throws Exception
	 */
	public boolean actualizarPassword(String username, String nuevaPassword) throws Exception {
		boolean updated = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement("update usuarios set contrasenia = ? where nombreDeUsuario = ?)");
			ps.setString(1, username);
			ps.setString(2, nuevaPassword);
			
			ps.execute();
			if (1 == ps.getUpdateCount()) {
				updated = true;
			}
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return updated;
	}

}
