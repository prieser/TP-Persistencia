package modelo.aerolinea;

import excepciones.AsientoYaReservadoException;
import modelo.usuario.Usuario;

import java.util.ArrayList;
import java.util.Collection;

public class Tramo {
    private ArrayList<Asiento> asientos;
    private String origen;
    private String destino;
    private String horaDeLlegada;
    private String horaDeSalida;
    private int precio;


    public ArrayList<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<Asiento> asientos) {
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

    public String getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public void setHoraDeLlegada(String horaDeLlegada) {
        this.horaDeLlegada = horaDeLlegada;
    }

    public String getHoraDeSalida() {
        return horaDeSalida;
    }

    public void setHoraDeSalida(String horaDeSalida) {
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
            throw new AsientoYaReservadoException("El asiento que quiere reservar ya esta ocupado");
        }
    }

    private Asiento getAsiento(int numeroDeAsiento) {
        return this.getAsientos().get(numeroDeAsiento);
    }
}
