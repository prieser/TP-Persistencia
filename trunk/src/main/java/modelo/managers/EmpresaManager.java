package modelo.managers;

import modelo.aerolinea.Empresa;
import modelo.daos.SessionManager;
import modelo.servicios.empresa.ConsultarEmpresa;
import modelo.servicios.empresa.CrearEmpresa;
import modelo.servicios.empresa.ModificarEmpresa;

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
