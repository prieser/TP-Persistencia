package modelo.servicios.empresa;

import modelo.aerolinea.Empresa;
import modelo.daos.EmpresaDAO;
import modelo.servicios.Operation;

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
