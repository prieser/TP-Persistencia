package modelo.busquedas;

public abstract class Criterio {

    private int idCriterio;

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public abstract String getQuery();
}
