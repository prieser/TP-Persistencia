package modelo.servicios;

import excepciones.AsientoYaReservadoException;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.managers.TramoManager;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;
import org.hibernate.Session;

public class ReservarVuelo implements Operation<Tramo> {

    private Session session = SessionManager.getSession();
    private int numeroDeAsientoAReservar;
    private Tramo tramoAreservar;
    private Usuario usuarioQueQuiereReservar;

    public ReservarVuelo(int numeroDeAsientoAReservar, Usuario usuarioQueQuiereReservar, Tramo tramoAReservar) {
        this.numeroDeAsientoAReservar = numeroDeAsientoAReservar;
        this.usuarioQueQuiereReservar = usuarioQueQuiereReservar;
        this.tramoAreservar = tramoAReservar;
    }

    @Override
    public Tramo execute() {
        Tramo tramoBuscado = new TramoManager().consultarTramo(this.tramoAreservar.getIdTramo());
        try {
            tramoBuscado.reservarAsiento(this.numeroDeAsientoAReservar, this.usuarioQueQuiereReservar);
        } catch (AsientoYaReservadoException e) {
            e.printStackTrace();
        }
        return tramoBuscado;
    }
}
