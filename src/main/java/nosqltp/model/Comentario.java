package nosqltp.model;

import net.vz.mongodb.jackson.ObjectId;

import org.codehaus.jackson.annotate.JsonProperty;

public class Comentario {

    @ObjectId
    @JsonProperty("_id")
    private String idComentario;

    private String nombreDelComentador;
    private String comentario;
    private Estado estado;
    private Privacidad politicaDePrivacidad;

    public String getNombreDelComentador() {
		return nombreDelComentador;
	}

	public void setNombreDelComentador(String nombreDelComentador) {
		this.nombreDelComentador = nombreDelComentador;
	}

	public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Privacidad getPoliticaDePrivacidad() {
        return politicaDePrivacidad;
    }

    public void setPoliticaDePrivacidad(Privacidad politicaDePrivacidad) {
        this.politicaDePrivacidad = politicaDePrivacidad;
    }

    public Comentario(String nombreDelUsuario, String comentario, Estado estado, Privacidad politicaDePrivacidad) {
    	this.nombreDelComentador = nombreDelUsuario;
        this.comentario = comentario;
        this.estado = estado;
        this.politicaDePrivacidad = politicaDePrivacidad;
    }

    public Comentario() {
    }

    public void meGusta() {
        this.setEstado(Estado.MEGUSTA);
    }

    public void noMeGusta() {
        this.setEstado(Estado.NOMEGUSTA);
    }


}
