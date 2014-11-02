package modelo.servicios.vuelo;

import modelo.aerolinea.Vuelo;
import modelo.daos.VueloDAO;
import modelo.servicios.Operation;

public class CrearVuelo implements Operation<Vuelo> {
		private int id;
		

		public CrearVuelo(int id) {
			super();
			this.id = id;
		}

		public Vuelo execute() {
			Vuelo v = new Vuelo(id);
			new VueloDAO().save(v);
			return v;
		}
	
	
	}
