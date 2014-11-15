package modelo.managers;


import modelo.daos.SessionManager;
import modelo.servicios.GuardarUsuario;
import modelo.usuario.Usuario;

public class UsuarioManager {

    public Object guardarUsuario(Usuario usuario) {
        return SessionManager.runInSession(new GuardarUsuario(usuario));
    }

}
