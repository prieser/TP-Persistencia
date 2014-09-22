package modelo.servicios.Empresa;

import modelo.aerolinea.Empresa;
import modelo.daos.SessionManager;

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
}
