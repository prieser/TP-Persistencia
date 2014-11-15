package modelo.busquedas.operadores;

public enum Operador2 {
	AND {
		@Override
		public String getOperador() {
			return " AND ";
		}
	},
	OR {
		@Override
		public String getOperador() {
			return " OR ";
		}
	};
	
	
	public abstract String getOperador();

}
