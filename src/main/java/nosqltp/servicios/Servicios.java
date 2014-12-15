package nosqltp.servicios;

import java.util.List;

import nosqltp.exceptions.NoExisteException;
import nosqltp.exceptions.YaExisteException;
import nosqltp.model.Comentario;
import nosqltp.model.Destino;
import nosqltp.model.Estado;
import nosqltp.model.Privacidad;
import nosqltp.model.Usuario;

public abstract class Servicios {

    public static void agregarDestino(String nombreDeUsuario, String nombreDelDestino) throws YaExisteException {
        Destino destinoAAgregar = new Destino(nombreDelDestino);
        new AgregarDestinoService(nombreDeUsuario, destinoAAgregar).ejecutar();
    }

    public static void agregarUsuario(String nombreDelUsuario) throws YaExisteException {
        Usuario usuarioAAgregar = new Usuario(nombreDelUsuario);
        new AgregarUsuarioService(usuarioAAgregar).ejecutar();
    }

    public static void comentarDestino(String usuarioQueComenta, String destinoQueComenta, String comentario, Estado estado, Privacidad privacidad) throws YaExisteException, NoExisteException {
        new AgregarComentario(usuarioQueComenta, destinoQueComenta, comentario, estado, privacidad);
    }
    
    public static List<Comentario> verComentariosDeUnUsuario(String nombreDeUsuario) throws YaExisteException {
    	return new VerComentariosDeUnUsuarioService(nombreDeUsuario).ejecutar();
    }
    
    public static List<Comentario> verComentariosDeUnDestino(String nombreDestino) throws YaExisteException, NoExisteException {
    	return new VerComentariosDeUnDestinoService(nombreDestino).ejecutar();
    }
}
