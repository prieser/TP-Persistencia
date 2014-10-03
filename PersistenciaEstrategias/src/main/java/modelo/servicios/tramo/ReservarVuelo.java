package modelo.servicios.tramo;

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

    /**
     * Esta operacion espera un tramo, asiento y usuario que realiza la reserva. Si el asiento ya esta reservado lanza una excepcion.
     * @return
     */
    public ReservarVuelo(int numeroDeAsientoAReservar, Usuario usuarioQueQuiereReservar, Tramo tramoAReservar) {
        this.numeroDeAsientoAReservar = numeroDeAsientoAReservar;
        this.usuarioQueQuiereReservar = usuarioQueQuiereReservar;
        this.tramoAreservar = tramoAReservar;
    }

    @Override
    public Tramo execute() {
        Tramo tramoBuscado = new TramoManager().buscarTramoPorCodigo(this.tramoAreservar.getCodigoDelTramo());
        try {
            tramoBuscado.reservarAsiento(this.numeroDeAsientoAReservar, this.usuarioQueQuiereReservar);
        } catch (AsientoYaReservadoException e) {
            e.printStackTrace();
        }
        return tramoBuscado;
    }
}
