package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;

public class Or extends Operador {
	
    public Or(Criterio primerCriterio, Criterio segundoCriterio) {
        this.criterio1 = primerCriterio;
        this.criterio2 = segundoCriterio;
    }
    
    public String getRestriction() {
    	return criterio1.getClave() + " == " + criterio1.getValor() + " OR " + criterio2.getClave() + " == " + criterio2.getValor(); 
    }
    
    public static void main(String[] args) {
		Criterio criterio1 = new Criterio();
		criterio1.setClave("nombre");
		criterio1.setValor("juan");
		
		Criterio criterio2 = new Criterio();
		criterio2.setClave("edad");
		criterio2.setValor("juan");
		
		Or or = new Or(criterio1, criterio2);
		System.out.println(or.getRestriction());
		
	}
}
