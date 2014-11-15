package modelo.aerolinea;

import java.util.Collection;

import modelo.usuario.Usuario;

/**
 * Created by Pablo Rieser on 11/09/2014.
 */
public class Empresa {

    private Integer idEmpresa;
    private String nombreDeLaEmpresa;
    private Collection<Aerolinea> aerolineas;

    public Empresa() {
        super();
    }

    public Empresa(String nombreParaLaEmpresa) {
        this.nombreDeLaEmpresa = nombreParaLaEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Collection<Aerolinea> getAerolineas() {
        return aerolineas;
    }

    public void setAerolineas(Collection<Aerolinea> aerolineas) {
        this.aerolineas = aerolineas;
    }

    public String getNombreDeLaEmpresa() {
        return nombreDeLaEmpresa;
    }

    public void setNombreDeLaEmpresa(String nombreDeLaEmpresa) {
        this.nombreDeLaEmpresa = nombreDeLaEmpresa;
    }

    public void reservarAsiento(Tramo tramo, Asiento asiento, Usuario usuario) {

		/*
         * Recorrer la lista de asientos sacadas desde el tramo preguntar si el asiento esta ocupado si no esta ocupado reservarlo enviadonle el metodo al asiento
		 */
        for (Asiento butaca : tramo.getAsientos()) {
            if (asiento.getNumero() == butaca.getNumero()) {
                asiento.reservarAsiento(usuario);
            }
        }

    }

}
