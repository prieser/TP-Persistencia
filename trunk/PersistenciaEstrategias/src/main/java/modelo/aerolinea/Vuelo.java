package modelo.aerolinea;

import java.util.HashSet;
import java.util.Set;


public class Vuelo {
    private String codigoVuelo;
    private Set<Tramo> tramos = new HashSet<Tramo>();
    private int id;

    public Vuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
        this.tramos = new HashSet<Tramo>();
    }

    public Vuelo() {
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Set<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(Set<Tramo> tramos) {
        this.tramos = tramos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadTramos() {
        return this.tramos.size();
    }

    public void agregarTramo(Tramo tramo) {
        this.tramos.add(tramo);
    }

}
