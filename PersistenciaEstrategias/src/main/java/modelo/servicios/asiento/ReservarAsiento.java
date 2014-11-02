package modelo.servicios.asiento;

import modelo.aerolinea.Asiento;
import modelo.managers.AsientoManager;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;

public class ReservarAsiento implements Operation<Asiento> {

    private int numeroDelAsientoAReservar;
    private Usuario usuarioQueReserva;

    public ReservarAsiento(int numeroDelAsientoAReservar,
                           Usuario usuarioQueReserva) {
        super();
        this.numeroDelAsientoAReservar = numeroDelAsientoAReservar;
        this.usuarioQueReserva = usuarioQueReserva;
    }

    @Override
    public Asiento execute() {
        Asiento asientoBuscado = new AsientoManager().buscarAsiento(numeroDelAsientoAReservar);
        return asientoBuscado;
    }


}
