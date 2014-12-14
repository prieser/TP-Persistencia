package main.java.nosqltp.model;


import java.util.HashSet;
import java.util.Set;

public class Usuario {

    private String idUsuario;
    private Set<Usuario> amigos;
    private Set<Destino> destinos;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Set<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(Set<Usuario> amigos) {
        this.amigos = amigos;
    }

    public Set<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(Set<Destino> destinos) {
        this.destinos = destinos;
    }

    public Usuario(String idUsuario) {
        this.idUsuario = idUsuario;
        this.amigos = new HashSet<Usuario>();
        this.destinos = new HashSet<Destino>();
    }

    public void agregarAmigo(Usuario amigoNuevo) {
        this.getAmigos().add(amigoNuevo);
        amigoNuevo.getAmigos().add(this);
    }

    public void agregarDestino(Destino destinoNuevo) {
        this.getDestinos().add(destinoNuevo);
    }

    public void comentarDestino(Destino destinoAComentar, String comentario) {
        destinoAComentar.comentar(comentario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!idUsuario.equals(usuario.idUsuario)) return false;

        return true;
    }
}
