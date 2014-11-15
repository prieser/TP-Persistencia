package modelo.servicios.tramo;


import java.util.ArrayList;

import modelo.aerolinea.Tramo;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;
import excepciones.AsientoYaReservadoException;

public class ReservarMuchosAsientos implements Operation<Tramo> {

    private ArrayList<Integer> numeroDeAsientos;
    private Usuario usuarioQueLoQuiereReservar;
    private Tramo tramoPorReservar;

    public ReservarMuchosAsientos(ArrayList<Integer> asientos, Usuario usuarioQueLoQuiereReservar, Tramo tramo) {
        super();
        this.numeroDeAsientos = asientos;
        this.usuarioQueLoQuiereReservar = usuarioQueLoQuiereReservar;
        this.tramoPorReservar = tramo;
    }

    @Override
    public Tramo execute() {
        try {
            tramoPorReservar.reservarAsientos(this.numeroDeAsientos, this.usuarioQueLoQuiereReservar);
        } catch (AsientoYaReservadoException e) {
            e.printStackTrace();
        }
        return tramoPorReservar;
    }
}
