package modelo.busquedas.operadores;

import modelo.busquedas.Criterio;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class And extends Operador {
	
    public And(Criterio primerCriterio, Criterio segundoCriterio) {
        this.criterio1 = primerCriterio;
        this.criterio2 = segundoCriterio;
    }
    
    public Criterion getRestriction() {
    	Criterion criterion = Restrictions.and(Restrictions.eq(criterio1.getClave(), criterio1.getValor()), Restrictions.eq(criterio1.getClave(), criterio1.getValor()));
		return criterion;
    }

}
