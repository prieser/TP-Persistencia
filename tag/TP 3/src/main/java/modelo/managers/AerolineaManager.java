package modelo.managers;

import modelo.aerolinea.Aerolinea;
import modelo.daos.SessionManager;
import modelo.servicios.aerolinea.BuscarAerolineaPorNombre;
import modelo.servicios.aerolinea.CrearAerolinea;
import modelo.servicios.aerolinea.ModificarNombreAerolinea;

public class AerolineaManager {


    public void crearAerolinea(String nombre, String direccion) {
        SessionManager.runInSession(new CrearAerolinea(nombre, direccion));
    }

    public Aerolinea modificarNombre(int id, String nombre) {
        return SessionManager.runInSession(new ModificarNombreAerolinea(id, nombre));
    }

    public Aerolinea buscarAerolineaPorSuNombre(String nombre) {
        return SessionManager.runInSession(new BuscarAerolineaPorNombre(nombre));
    }

}
