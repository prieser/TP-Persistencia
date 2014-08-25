package modelo;

import excepciones.NuevaPasswordInválida;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioYaExisteException;
import excepciones.ValidaciónException;

public class Sistema {
	
	public void RegistrarUsuario (Usuario usuarioNuevo) throws UsuarioYaExisteException {
		
	}
	
	public void ValidarCuenta (String codigoValidación) throws ValidaciónException {
		
	}

	public Usuario IngresarUsuario (String userName, String password) throws UsuarioNoExiste {
		return null;
		
	}
	
	public void CambiarPassword ( String userName, String password, String nuevaPassword) throws NuevaPasswordInválida {
		
	}
}
