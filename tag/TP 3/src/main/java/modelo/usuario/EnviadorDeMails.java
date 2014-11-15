package modelo.usuario;

public class EnviadorDeMails {

    public boolean enviarMail(Mail unMail, Usuario usuario) {
        usuario.setCodigoDeValidacion(unMail.getBody());
        return true;
    }

}
