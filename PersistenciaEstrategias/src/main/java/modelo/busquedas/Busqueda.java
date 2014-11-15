package modelo.busquedas;

import java.util.ArrayList;
import java.util.HashSet;

import modelo.busquedas.orden.Orden;
import modelo.usuario.Usuario;

public class Busqueda {

    private int idBusqueda;
    private HashSet<Componente> criterios;
    private Orden orden;

    public int getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(int idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

    public HashSet<Componente> getCriterios() {
        return criterios;
    }

    public void setCriterios(HashSet<Componente> criterios) {
        this.criterios = criterios;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void agregarCriterio(Componente criterioAAgregar) {
        this.criterios.add(criterioAAgregar);
    }

    public void agregarOrden (Orden ordenAAgregar) {
        this.setOrden(ordenAAgregar);
    }

    public Busqueda() {
        this.criterios = new HashSet<Componente>();
    }

    public String getQuery() {
        String query = "SELECT v FROM Vuelo v INNER JOIN v.tramos t WHERE ";

        for (Componente unCriterio : this.criterios) {
            query = query + unCriterio.getQuery();
        }

        if (this.orden != null) {
            query += this.orden.getQuery();
        }
        return query;

    }
}

