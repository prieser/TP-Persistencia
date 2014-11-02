package modelo.servicios.empresa;

import modelo.aerolinea.Empresa;
import modelo.daos.GenericDAO;
import modelo.servicios.Operation;

public class ConsultarEmpresa implements Operation<Empresa> {

    private int id;

    public ConsultarEmpresa(int id) {
        super();
        this.id = id;
    }

    public Empresa execute() {
        Empresa EmpresaQueBusco;
        EmpresaQueBusco = (Empresa) new GenericDAO<Empresa>(Empresa.class).get(id);
        return EmpresaQueBusco;
    }

}
