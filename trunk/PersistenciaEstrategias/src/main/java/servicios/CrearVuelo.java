package servicios;

import modelo.Vuelo;
import dao.VueloDAO;

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
