package modelo.busquedas.orden;

public abstract class Orden {

    private int idOrden;

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public abstract String getQuery();

}