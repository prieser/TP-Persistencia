package main.java.nosqltp.servicios;

import main.java.nosqltp.exceptions.NoExisteException;
import main.java.nosqltp.exceptions.YaExisteException;
import main.java.nosqltp.model.Destino;
import main.java.nosqltp.model.Estado;
import main.java.nosqltp.model.Privacidad;
import main.java.nosqltp.model.Usuario;

public abstract class Servicios {

    public static void agregarDestino(String nombreDelDestino) throws YaExisteException {
        Destino destinoAAgregar = new Destino(nombreDelDestino);
        new AgregarDestinoService(destinoAAgregar).ejecutar();
    }

    public static void agregarUsuario(String nombreDelUsuario) throws YaExisteException {
        Usuario usuarioAAgregar = new Usuario(nombreDelUsuario);
        new AgregarUsuarioService(usuarioAAgregar).ejecutar();
    }

    public static void comentarDestino(String s, String s1, Estado megusta, Privacidad publico) throws YaExisteException, NoExisteException {
        new AgregarComentario(s, s1, megusta, publico);
    }
}
