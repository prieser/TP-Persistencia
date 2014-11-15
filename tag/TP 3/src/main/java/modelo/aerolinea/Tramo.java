package modelo.aerolinea;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import modelo.usuario.Usuario;
import excepciones.AsientoYaReservadoException;

public class Tramo {

    private int idTramo;
    private String codigoDelTramo;
    private Set<Asiento> asientos;
    private String origen;
    private String destino;
    private Date horaDeLlegada;
    private Date horaDeSalida;
    private int precio;

    public Tramo(String codigoDelTramo, String origen, String destino, Date horaDeLlegada, Date horaDeSalida, int precio) {
        super();
        this.codigoDelTramo = codigoDelTramo;
        this.origen = origen;
        this.destino = destino;
        this.horaDeSalida = horaDeSalida;
        this.horaDeLlegada = horaDeLlegada;
        this.precio = precio;
        this.asientos = new HashSet<Asiento>();
    }

    public Tramo() {
    }

    public String getCodigoDelTramo() {
        return codigoDelTramo;
    }

    public void setCodigoDelTramo(String codigoDelTramo) {
        this.codigoDelTramo = codigoDelTramo;
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

    public void reservarAsientos(ArrayList<Integer> numeroDeAsientos, Usuario usuarioQueQuiereReservar) throws AsientoYaReservadoException {
        for (int numero : numeroDeAsientos) {
            this.reservarAsiento(numero, usuarioQueQuiereReservar);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tramo tramo = (Tramo) o;
        if (!codigoDelTramo.equals(tramo.codigoDelTramo)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return codigoDelTramo.hashCode();
    }

    public void agregarAsiento(Asiento asientoAAgregar) {
        this.getAsientos().add(asientoAAgregar);
    }
}
    
    
    
  
