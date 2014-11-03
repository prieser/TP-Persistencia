package modelo.busquedas;

import java.util.ArrayList;

public class Busqueda {

    private ArrayList<Componente> criterios = new ArrayList<Componente>();
    private Orden orden;

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


    public void agregarCriterio(Componente criterioAAgregar) {
        this.criterios.add(criterioAAgregar);
    }

    public String getQuery() {
        String query = "from Vuelo WHERE";

        for (Componente unCriterio : this.criterios) {
            query = query + unCriterio.getQuery();
        }

        query += this.orden.getQuery();
        return query;

    }
}

