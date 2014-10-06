package modelo.servicios;

import modelo.daos.UsuarioDAO;
import modelo.usuario.Usuario;

public class GuardarUsuario implements Operation<Object>{
	
	
private Usuario usuario ;
	
	public GuardarUsuario(Usuario usuario){
		this.usuario = usuario ;
		
	}
	@Override
	public Object execute() {
		new UsuarioDAO().save(this.usuario);
		return null;
		
	}

}
