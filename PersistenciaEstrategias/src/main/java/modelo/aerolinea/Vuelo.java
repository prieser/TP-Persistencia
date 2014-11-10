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
    
    public int getPrecioDelVuelo() {
    	int precio = 0;
    	for (Tramo unTramo : this.getTramos()) {
			precio = precio + unTramo.getPrecio();
		}
    	return precio;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoVuelo == null) ? 0 : codigoVuelo.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if (codigoVuelo == null) {
			if (other.codigoVuelo != null)
				return false;
		} else if (!codigoVuelo.equals(other.codigoVuelo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
