package modelo.managers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.asiento.AsientosDisponible;
import modelo.servicios.tramo.BuscarTramoPorCodigo;
import modelo.servicios.tramo.ConsultarTramo;
import modelo.servicios.tramo.CrearTramo;
import modelo.servicios.tramo.EliminarTramo;
import modelo.servicios.tramo.GuardarTramo;
import modelo.servicios.tramo.ReservarMuchosAsientos;
import modelo.servicios.tramo.ReservarVuelo;
import modelo.usuario.Usuario;

public class TramoManager {

    public Tramo consultarTramo(int id) {
        return SessionManager.runInSession(new ConsultarTramo(id));
    }

    public Object guardarTramo(Tramo tramo) {
        return SessionManager.runInSession(new GuardarTramo(tramo));
    }

    public Object eliminarTramo(Tramo tramo) {
        return SessionManager.runInSession(new EliminarTramo(tramo));
    }

    public Tramo crearTramo(String codigoDelTramo, String origen, String destino, Date horarioLlegada, Date horarioSalida, int precio) {
       return SessionManager.runInSession(new CrearTramo(codigoDelTramo, origen, destino, horarioLlegada, horarioSalida, precio));
    }

    public List<Asiento> TraerAsientosTramo(Tramo tramo) {
        return SessionManager.runInSession(new AsientosDisponible(tramo));
    }

    public Object reservarVuelo(int nroAsientoAReservar, Usuario usuarioQueReserva, Tramo tramoDeLaReserva) {
        return SessionManager.runInSession(new ReservarVuelo(nroAsientoAReservar, usuarioQueReserva, tramoDeLaReserva));
    }

    public Tramo buscarTramoPorCodigo(String codigoDelTramoBuscado) {
        return SessionManager.runInSession(new BuscarTramoPorCodigo(codigoDelTramoBuscado));
    }

    public Tramo reservarMuchosAsientos(ArrayList<Integer> asientos, Usuario usuarioQueLoQuiereReservar, Tramo tramo) {
        return SessionManager.runInSession(new ReservarMuchosAsientos(asientos, usuarioQueLoQuiereReservar, tramo));
    }
}
