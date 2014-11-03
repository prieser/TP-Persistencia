package modelo.busquedas;

import java.util.ArrayList;

import modelo.busquedas.operadores.Operador;

public class Busqueda {

    private ArrayList<Operador> criterios = new ArrayList<Operador>();
    private Orden orden;

    public ArrayList<Operador> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<Operador> criterios) {
        this.criterios = criterios;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }


    public void agregarCriterio(Operador criterioAAgregar) {
        this.criterios.add(criterioAAgregar);
    }

    public String getQuery() {
        String query = "from Vuelo WHERE";

        for (Operador unCriterio : this.criterios) {
            query = query + unCriterio.getQuery();

        }

        query += this.orden.getQuery();
        return query;

    }
}

