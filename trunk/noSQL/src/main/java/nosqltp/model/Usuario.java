package main.java.nosqltp.model;


import net.vz.mongodb.jackson.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario {
    @ObjectId
    @JsonProperty("_id")
    private String idUsuario;

    private String nombreDeUsuario;
    private List<Usuario> usuariosQueSigo;
    private List<Destino> destinos;

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

    public List<Usuario> getUsuariosQueSigo() {
        return usuariosQueSigo;
    }

    public void setUsuariosQueSigo(List<Usuario> usuariosQueSigo) {
        this.usuariosQueSigo = usuariosQueSigo;
    }

    public List<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<Destino> destinos) {
        this.destinos = destinos;
    }

    public Usuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.usuariosQueSigo = new ArrayList<Usuario>();
        this.destinos = new ArrayList<Destino>();
    }

    public Usuario() {
    }

    public void seguir(Usuario seguidor) {
        this.getUsuariosQueSigo().add(seguidor);
    }

    public void agregarDestino(Destino destinoNuevo) {
        this.getDestinos().add(destinoNuevo);
    }

    public void comentarDestino(Destino destinoAComentar, String comentario) {
        destinoAComentar.comentar(comentario);
    }

    public boolean isSeguidor(Usuario amigoPosible){
        return this.getUsuariosQueSigo().contains(amigoPosible);
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
