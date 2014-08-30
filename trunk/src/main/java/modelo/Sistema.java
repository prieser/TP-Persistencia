package modelo;

import excepciones.NuevaPasswordInválida;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidaciónException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sistema {

    private Connection connection;
    private PreparedStatement statementDeInsertar;
    private PreparedStatement statementDeConsulta;

    /**
     * Este metodo se encarga de registrar al usuario que recibe por parametros. Antes de eso verifica que no exista ya un usuario que tenga el el mismo nick y email.
     * @param usuarioNuevo
     * @throws UsuarioYaExisteException
     */
    public void RegistrarUsuario(Usuario usuarioNuevo) throws UsuarioYaExisteException {
        try {
            this.connection = this.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.statementDeInsertar = connection.prepareStatement("INSERT  INTO usuarios (nombre, apellido, nombreDeUsuario, email, fechaDeNacimiento, contraseña) VALUES  (?,?,?,?,?,?)");
            statementDeInsertar.setString(1, usuarioNuevo.getNombre());
            statementDeInsertar.setString(2, usuarioNuevo.getApellido());
            statementDeInsertar.setString(3, usuarioNuevo.getNombreUsuario());
            statementDeInsertar.setString(4, usuarioNuevo.getEmail());
            statementDeInsertar.setString(5, usuarioNuevo.getFechaDeNacimiento());
            statementDeInsertar.setString(6, usuarioNuevo.getContraseña());

            this.statementDeConsulta = connection.prepareStatement("SELECT  * FROM  usuarios WHERE nombreDeUsuario = ? AND email = ?");
            statementDeConsulta.setString(1, usuarioNuevo.getNombreUsuario());
            statementDeConsulta.setString(2, usuarioNuevo.getEmail());
            statementDeConsulta.executeQuery();

            // Ejecuto la consulta primero para verificar que el usuario no exista ya en la base de datos.
            if (statementDeConsulta.getUpdateCount() > 0){
                throw new UsuarioYaExisteException();
            } else {
                statementDeInsertar.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ValidarCuenta(String codigoValidación) throws ValidaciónException {

    }

    public Usuario IngresarUsuario(String userName, String password) throws UsuarioNoExiste {
        return null;

    }

    public void CambiarPassword(String userName, String password, String nuevaPassword) throws NuevaPasswordInválida {
    	
    	try {
            this.connection = this.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	 try {
    		 
    	 this.statementDeConsulta = connection.prepareStatement("UPDATE usuarios SET contraseña = ? WHERE nombreDeUsuario = ? AND contraseña = password");
         statementDeConsulta.setString(1, nuevaPassword);
         statementDeConsulta.setString(2, userName);
         statementDeConsulta.executeUpdate();
    	
    	} catch (SQLException e) {
        e.printStackTrace();
    	}
  	
    }

    /* Metodo auxiliar para conexion con la base de datos */
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/database?user=root&password=root");
    }
}
