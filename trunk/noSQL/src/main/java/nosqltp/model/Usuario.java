package main.java.nosqltp.model;


import net.vz.mongodb.jackson.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
    @ObjectId
    @JsonProperty("_id")
    private String idUsuario;

    private String nombreDeUsuario;
    private Set<Usuario> amigos;
    private Set<Destino> destinos;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
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

    public Usuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.amigos = new HashSet<Usuario>();
        this.destinos = new HashSet<Destino>();
    }

    public Usuario() {
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

        if (!nombreDeUsuario.equals(usuario.nombreDeUsuario)) return false;

        return true;
    }

}
