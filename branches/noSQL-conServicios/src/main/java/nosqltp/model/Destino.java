package main.java.nosqltp.model;

import net.vz.mongodb.jackson.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Destino {

    @ObjectId
    @JsonProperty("_id")
    private String idDestino;

    private String nombreDestino;
    private List<Comentario> comentarios;

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Destino() {
    }

    public Destino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
        this.comentarios = new ArrayList<Comentario>();
    }

    public void agregarComentario(Comentario comentario) {
        this.getComentarios().add(comentario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destino destino = (Destino) o;

        if (nombreDestino != null ? !nombreDestino.equals(destino.nombreDestino) : destino.nombreDestino != null)
            return false;

        return true;
    }
}
