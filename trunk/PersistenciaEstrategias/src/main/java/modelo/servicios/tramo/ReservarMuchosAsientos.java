package modelo.servicios.tramo;


import excepciones.AsientoYaReservadoException;
import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.managers.TramoManager;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Set;

public class ReservarMuchosAsientos implements Operation<Tramo> {

	private ArrayList asientos;
	private Usuario usuarioQueLoQuiereReservar;
	private Tramo tramoPorReservar;

	public ReservarMuchosAsientos(ArrayList<Integer> asientos , Usuario usuarioQueLoQuiereReservar ,Tramo tramo ) {
		super();
		this.asientos = asientos;
		this.usuarioQueLoQuiereReservar = usuarioQueLoQuiereReservar;
		this.tramoPorReservar = tramo;
	}

	@Override
	public Tramo execute() {
//		Tramo tramoPorReservar;
//		Session session = SessionManager.getSession();
//        Query query = session.createQuery("from Tramos where CODIGO_TRAMO = :codigoDelTramo");
//        query.setParameter("codigoDelTramo", this.tramoPorReservar);
//        query.setMaxResults(1);
//        tramoPorReservar = (Tramo) query.uniqueResult();

        Tramo tramoPorReservar  = new TramoManager().buscarTramoPorCodigo(this.tramoPorReservar.getCodigoDelTramo());

		try {
			tramoPorReservar.reservarAsiento(this.asientos, this.usuarioQueLoQuiereReservar);
		} catch (AsientoYaReservadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tramoPorReservar;
	}
}
