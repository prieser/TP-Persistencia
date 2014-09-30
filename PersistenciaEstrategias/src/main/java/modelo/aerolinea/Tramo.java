package modelo.aerolinea;

import modelo.usuario.Usuario;
import excepciones.AsientoYaReservadoException;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tramo {
    private Set<Asiento> asientos;
    private int idTramo;
    private String origen;
    private String destino;
    private Date horaDeLlegada;
    private Date horaDeSalida;
    private int precio;

    public Tramo(String origen, String destino, Date horaDeLlegada, Date horaDeSalida, int precio) {
        super();
        this.origen = origen;
        this.destino = destino;
        this.horaDeSalida = horaDeSalida;
        this.horaDeLlegada = horaDeLlegada;
        this.precio = precio;
        this.asientos = new HashSet<Asiento>();
    }

    public int getIdTramo() {
        return idTramo;
    }

    public void setIdTramo(int idTramo) {
        this.idTramo = idTramo;
    }

    public Set<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(Set<Asiento> asientos) {
        this.asientos = asientos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(Date horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public Date getHoraDeSalida() {
        return horaDeSalida;
    }

    public void setHoraDeSalida(Date horaDeSalida) {
        this.horaDeSalida = horaDeSalida;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Object getAsientosSinReservar() {
        // Deberia retornar los asientos disponibles
        return null;
    }

    public void reservarAsiento(int numeroDeAsiento, Usuario usuarioQueQuiereReservar) throws AsientoYaReservadoException {
        Asiento asientoBuscado = this.getAsiento(numeroDeAsiento);
        if (!asientoBuscado.estaReservado()) {
            asientoBuscado.reservarAsiento(usuarioQueQuiereReservar);
        } else {
            throw new AsientoYaReservadoException(
                    "El asiento que quiere reservar ya esta ocupado");
        }
    }

    public Asiento getAsiento(int numeroDeAsiento) {
        Asiento asientoBuscado = null;
        for (Asiento asiento : asientos) {
            if (asiento.getNumero() == numeroDeAsiento) {
                asientoBuscado = asiento;
            }
        }
        return asientoBuscado;
    }
}
