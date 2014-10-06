package modelo.managers;

import modelo.aerolinea.Empresa;
import modelo.aerolinea.Tramo;
import modelo.daos.SessionManager;
import modelo.servicios.empresa.ConsultarEmpresa;
import modelo.servicios.empresa.CrearEmpresa;
import modelo.servicios.empresa.ModificarEmpresa;
import modelo.servicios.tramo.ReservarVuelo;
import modelo.usuario.Usuario;

public class EmpresaManager {

    public Empresa consultarEmpresa(int idDeLaEmpresa) {
        return SessionManager.runInSession(new ConsultarEmpresa(idDeLaEmpresa));
    }

    public void crearEmpresa(String nombreDeLaEmpresa) {
        SessionManager.runInSession(new CrearEmpresa(nombreDeLaEmpresa));
    }

    public Empresa modificarEmpresa(int id, String nombreDeLaEmpresa) {
        return SessionManager.runInSession(new ModificarEmpresa(id, nombreDeLaEmpresa));
    }

    public Tramo reservarAsiento(int numeroDeAsiento, Usuario usuario, Tramo tramo) {
        return SessionManager.runInSession(new ReservarVuelo(numeroDeAsiento, usuario, tramo));
    }
}
