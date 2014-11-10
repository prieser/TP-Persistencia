package modelo.busquedas.orden;

public abstract class Orden {

    private int idOrden;
    private String valor;

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public abstract String getQuery();

}