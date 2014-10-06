package modelo.servicios.tramo;


import excepciones.AsientoYaReservadoException;
import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Set;

public class ReservarMuchosAsientos implements Operation<Tramo> {

	private Set numeroDeAsientos;
	private Usuario usuarioQueLoQuiereReservar;
	private Tramo tramoPorReservar;

	public ReservarMuchosAsientos(Set<Asiento> numeroDeAsientos , Usuario usuarioQueLoQuiereReservar ,Tramo tramo ) {
		super();
		this.numeroDeAsientos = numeroDeAsientos;
		this.usuarioQueLoQuiereReservar = usuarioQueLoQuiereReservar;
		this.tramoPorReservar = tramo;
	}

	@Override
	public Tramo execute() {
		Tramo tramoPorReservar;
		Session session = SessionManager.getSession();
        Query query = session.createQuery("from Tramos where CODIGO_TRAMO = :codigoDelTramo");
        query.setParameter("codigoDelTramo", this.tramoPorReservar);
        query.setMaxResults(1);
        tramoPorReservar = (Tramo) query.uniqueResult();

		try {
			tramoPorReservar.reservarAsiento(this.numeroDeAsientos, this.usuarioQueLoQuiereReservar);
		} catch (AsientoYaReservadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tramoPorReservar;
	}
}
