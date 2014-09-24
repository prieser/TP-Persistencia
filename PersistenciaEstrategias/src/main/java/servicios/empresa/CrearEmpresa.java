package servicios.empresa;

import modelo.Empresa;
import dao.EmpresaDAO;
import servicios.Operation;

public class CrearEmpresa implements Operation<Empresa> {

    private String nombre;

    public CrearEmpresa(String nombreDeLaEmpresa) {
        super();
        this.nombre = nombreDeLaEmpresa;
    }

    
    public Empresa execute() {
        Empresa empresaAGuardar = new Empresa(nombre);
        new EmpresaDAO().save(empresaAGuardar);
        return empresaAGuardar;
    }
}
