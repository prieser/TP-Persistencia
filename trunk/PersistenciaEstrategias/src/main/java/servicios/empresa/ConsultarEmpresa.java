package servicios.empresa;

import modelo.Empresa;
import dao.EmpresaDAO;
import servicios.Operation;

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
