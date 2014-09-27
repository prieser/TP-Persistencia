package modelo.aerolinea;

import java.util.ArrayList;
import java.util.Collection;

public class Vuelo {
    private Collection<Tramo> tramos;
    private int id;

    public Collection<Tramo> getTramos() {
        return tramos;
    }

    public void setTramos(Collection<Tramo> tramos) {
        this.tramos = tramos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vuelo(int id) {
        this.id = id;
        this.tramos = new ArrayList<Tramo>();
    }

    public int getCantidadTramos() {
        return this.tramos.size();
    }

    public void agregarTramo(Tramo tramo) {
        this.tramos.add(tramo);
    }

}
