package modelo.daos;

import modelo.usuario.Usuario;

public class UsuarioDAO {
	
    public Usuario get(int idUsuario) {
        return (Usuario) SessionManager.getSession().get(Usuario.class, idUsuario);
    }

    public void save(Usuario usuarioAGuardar) {
        SessionManager.getSession().saveOrUpdate(usuarioAGuardar);
    }

}
