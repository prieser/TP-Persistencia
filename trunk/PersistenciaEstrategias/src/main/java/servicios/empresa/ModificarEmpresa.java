package servicios.empresa;

import modelo.Empresa;
import dao.EmpresaDAO;
import servicios.Operation;

public class ModificarEmpresa implements Operation<Empresa> {

    private String nuevoNombre;
    private int id;

    public ModificarEmpresa(int id, String nombre) {
        super();
        this.nuevoNombre = nombre;
        this.id = id;
    }


    public Empresa execute() {
        Empresa empresaQueVoyAModificar = new EmpresaDAO().get(id);
        empresaQueVoyAModificar.setNombreDeLaEmpresa(nuevoNombre);
        return empresaQueVoyAModificar;
    }
}
