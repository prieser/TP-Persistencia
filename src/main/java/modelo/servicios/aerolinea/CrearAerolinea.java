package modelo.servicios.aerolinea;

import modelo.aerolinea.Aerolinea;
import modelo.daos.AerolineaDAO;
import modelo.servicios.Operation;


public class CrearAerolinea implements Operation<Aerolinea> {

        private String nombre;
		private String direccion;
		

		public CrearAerolinea(String nombre, String direccion) {
			super();
			this.nombre = nombre;
			this.direccion = direccion;
		}

		public Aerolinea execute() {
			Aerolinea a = new Aerolinea(nombre, direccion);
			new AerolineaDAO().save(a);
			return a;
		}
	}
	
	
	


