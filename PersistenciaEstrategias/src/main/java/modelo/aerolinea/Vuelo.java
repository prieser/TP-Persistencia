package modelo.aerolinea;

import java.util.HashSet;
import java.util.Set;


public class Vuelo {
    private Set<Tramo> tramos = new HashSet<Tramo>();
    private int id;

    public Vuelo() {
        this.tramos = new HashSet<Tramo>();
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
