package main.java.nosqltp.model;

public class Destino {

    private String comentario;
    private Estado estado;
    private Privacidad politicaDePrivacidad;


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
}
