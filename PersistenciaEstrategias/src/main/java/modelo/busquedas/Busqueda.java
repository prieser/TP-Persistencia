package modelo.busquedas;

import java.util.ArrayList;

public class Busqueda {


    private ArrayList<Criterio> criterios;
    private Orden orden;

    public ArrayList<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(ArrayList<Criterio> criterios) {
        this.criterios = criterios;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }


    public void agregarCriterio(Criterio criterioAAgregar) {
        this.criterios.add(criterioAAgregar);
    }

    public String getQuery() {
        String query = "from Vuelo WHERE";

        for (Criterio unCriterio : this.criterios) {
            query = query + unCriterio.getQuery();

        }
        query += this.orden.getQuery();
        return query;


    }
}

