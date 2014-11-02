package modelo.busquedas;

public class Orden {

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

    public String getQuery() {
        return "order by " + this.getValor();
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}