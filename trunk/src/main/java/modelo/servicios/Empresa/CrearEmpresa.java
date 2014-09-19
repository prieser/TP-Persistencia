package modelo.servicios.Empresa;

import modelo.aerolinea.Empresa;
import modelo.daos.EmpresaDAO;
import modelo.servicios.Operation;

public class CrearEmpresa implements Operation<Empresa> {

    private String nombre;

    public CrearEmpresa(String nombreDeLaEmpresa) {
        super();
        this.nombre = nombreDeLaEmpresa;
    }

    @Override
    public Empresa execute() {
        Empresa empresaAGuardar = new Empresa(nombre);
        new EmpresaDAO().save(empresaAGuardar);
        return empresaAGuardar;
    }
}
