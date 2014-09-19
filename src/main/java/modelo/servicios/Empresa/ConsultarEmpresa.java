package modelo.servicios.Empresa;

import modelo.aerolinea.Empresa;
import modelo.daos.EmpresaDAO;
import modelo.servicios.Operation;

public class ConsultarEmpresa implements Operation<Empresa> {

    private int id;

    public ConsultarEmpresa(int id) {
        super();
        this.id = id;
    }

    public Empresa execute() {
        Empresa EmpresaQueBusco;
        EmpresaQueBusco = new EmpresaDAO().get(id);
        return EmpresaQueBusco;
    }

}
