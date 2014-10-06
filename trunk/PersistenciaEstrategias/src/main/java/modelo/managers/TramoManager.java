package modelo.managers;

import modelo.aerolinea.Asiento;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.AsientosDisponible;
import modelo.servicios.tramo.*;
import modelo.usuario.Usuario;

import java.util.Date;
import java.util.List;

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

    public void crearTramo(String codigoDelTramo, String origen, String destino, Date horarioLlegada, Date horarioSalida, int precio) {
        SessionManager.runInSession(new CrearTramo(codigoDelTramo, origen, destino, horarioLlegada, horarioSalida, precio));
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

}
