package modelo.servicios.tramo;

import modelo.aerolinea.Tramo;
import modelo.daos.TramoDAO;
import modelo.servicios.Operation;

public class GuardarTramo implements Operation<Object> {
	
	private Tramo tramo ;
	
	public GuardarTramo(Tramo tramo){
		this.tramo = tramo ;
		
	}
	@Override
	public Object execute() {
		new TramoDAO().save(this.tramo);
		return null;
		
	}


}
