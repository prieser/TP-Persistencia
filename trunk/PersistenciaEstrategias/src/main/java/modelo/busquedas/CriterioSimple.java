package modelo.busquedas;

public class CriterioSimple extends Criterio {

    private String clave;
    private String valor;

    public CriterioSimple(String clave, String valor) {
        super();
        this.clave = clave;
        this.valor = valor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String getQuery() {
        return "(" + this.getClave() + " = " + this.getValor() + ")";
    }


}
