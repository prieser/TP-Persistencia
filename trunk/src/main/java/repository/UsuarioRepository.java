package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Home;
import modelo.Usuario;

 public class UsuarioRepository extends Repository implements Home<Usuario> {
	 
	 public void RegistrarUsuario(Usuario usuario) throws Exception{
		 //Connection connection = this.getConnection();
		 // this.ExisteUsuario(usuario);
	 }

	public void guardar(Usuario usuario) throws Exception  {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = this.getConnection();
			ps = conn.prepareStatement("INSERT INTO usuarios (nombre,apellido,nombreDeUsuario,email,fechaDeNacimiento) VALUE (?,?,?,?,?)");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getNombreUsuario());
			ps.setString(4, usuario.getEmail());
			ps.setString(5, usuario.getFechaDeNacimiento());
			ps.execute();
		}finally{
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}

	}
		

	public boolean existe(Usuario usuario) throws Exception{
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		try{
			conn = this.getConnection();
			ps = conn.prepareStatement("select 1 from usuarios where nombreDeUsuario= ? limit 0,1");
			ps.setString(1, usuario.getNombreUsuario());
			ResultSet rs = ps.executeQuery();
			Integer filasEncontradas = 0 ;
			while(rs.next()){
				 filasEncontradas = rs.getInt("1");
			}

			if (1 == filasEncontradas){
				result = true;
			}
			ps.close();
		}finally{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		return result;
	}

	public boolean actualizar(Usuario usuario) throws Exception {
		boolean updated = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = this.getConnection();
			ps = conn.prepareStatement("update usuarios set nombre = ? ,apellido = ?, email = ?, fechaDeNacimiento = ? where nombreDeUsuario = ?)");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getApellido());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getFechaDeNacimiento());
			ps.setString(5, usuario.getNombreUsuario());
			ps.execute();
			if (1 == ps.getUpdateCount()){
				updated = true ;
			}
		}finally{
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		return updated;
	}

	 
	 //public boolean ExisteUsuario(Usuario usuario) throws Exception{
	/*	 Connection conn = null;
			PreparedStatement ps = null;
			try{
				ps = conn.prepareStatement("SELECT ID,NOMBRE,CODIGO FROM Aerolinea WHERE CODIGO = ?");
				ps.setString(1, "UNA");
				ResultSet rs = ps.executeQuery();
			}
		*/ 
	 //}
	
}
