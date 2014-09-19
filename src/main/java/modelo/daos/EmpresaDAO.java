package modelo.daos;

import modelo.aerolinea.Empresa;

public class EmpresaDAO {

    public Empresa get(int idEmpresa) {
        return (Empresa) SessionManager.getSession().get(Empresa.class, idEmpresa);
    }

    public void save(Empresa empresaAGurdar) {
        SessionManager.getSession().saveOrUpdate(empresaAGurdar);
    }

}
