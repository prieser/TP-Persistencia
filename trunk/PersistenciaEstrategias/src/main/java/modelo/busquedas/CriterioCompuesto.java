package modelo.busquedas;

import modelo.busquedas.operadores.Operador2;

public class CriterioCompuesto extends Criterio {

    private Criterio criterio1;
    private Criterio criterio2;
    private Operador2 operador;

    public CriterioCompuesto() {
    }

    public CriterioCompuesto(Criterio criterioSimple1, Criterio criterioSimple2, Operador2 operador) {
        super();
        this.criterio1 = criterioSimple1;
        this.criterio2 = criterioSimple2;
        this.operador = operador;
    }

    public Criterio getCriterio1() {
        return criterio1;
    }

    public void setCriterio1(Criterio criterio1) {
        this.criterio1 = criterio1;
    }

    public Criterio getCriterio2() {
        return criterio2;
    }

    public void setCriterio2(Criterio criterio2) {
        this.criterio2 = criterio2;
    }

    public Operador2 getOperador() {
        return operador;
    }

    public void setOperador(Operador2 operador) {
        this.operador = operador;
    }

    @Override
    public String getQuery() {
        return "(" + criterio1.getQuery() + operador.getOperador() + criterio2.getQuery() + ")";
    }

}
