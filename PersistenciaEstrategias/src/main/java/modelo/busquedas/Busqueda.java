package modelo.busquedas;

import modelo.usuario.Usuario;

import java.util.ArrayList;

public class Busqueda {

    private int idBusqueda;
    private ArrayList<Componente> criterios = new ArrayList<Componente>();
    private Orden orden;
    private Usuario usuario;

    public int getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(int idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

    public ArrayList<Componente> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<Componente> criterios) {
        this.criterios = criterios;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarCriterio(Componente criterioAAgregar) {
        this.criterios.add(criterioAAgregar);
    }

    public Busqueda(Usuario usuario) {
        this.criterios = new ArrayList<Componente>();
        this.usuario = usuario;
    }

    public String getQuery() {
        String query = "FROM Tramos INNER JOIN Vuelos WHERE ";

        for (Componente unCriterio : this.criterios) {
            query = query + unCriterio.getQuery();
        }

        if (this.orden != null) {
            query += this.orden.getQuery();
        }
        return query;

    }
}

