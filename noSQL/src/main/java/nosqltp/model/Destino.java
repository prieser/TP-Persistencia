package main.java.nosqltp.model;

import net.vz.mongodb.jackson.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

public class Destino {

    @ObjectId
    @JsonProperty("_id")
    private String idDestino;

    private String comentario;
    private Estado estado;
    private Privacidad politicaDePrivacidad;

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Privacidad getPoliticaDePrivacidad() {
        return politicaDePrivacidad;
    }

    public void setPoliticaDePrivacidad(Privacidad politicaDePrivacidad) {
        this.politicaDePrivacidad = politicaDePrivacidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Destino() {
    }

    public Destino(String comentario, Estado estado, Privacidad politicaDePrivacidad) {
        this.comentario = comentario;
        this.estado = estado;
        this.politicaDePrivacidad = Privacidad.PUBLICO;
    }

    public void meGusta() {
        this.setEstado(Estado.MEGUSTA);
    }

    public void noMeGusta() {
        this.setEstado(Estado.NOMEGUSTA);
    }

    public void comentar(String comentario) {
        this.setComentario(comentario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destino destino = (Destino) o;

        if (comentario != null ? !comentario.equals(destino.comentario) : destino.comentario != null) return false;
        if (estado != destino.estado) return false;
        if (politicaDePrivacidad != destino.politicaDePrivacidad) return false;

        return true;
    }
}
