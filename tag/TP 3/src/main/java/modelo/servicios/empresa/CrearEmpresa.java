package modelo.servicios.empresa;

import modelo.aerolinea.Empresa;
import modelo.daos.GenericDAO;
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
        new GenericDAO<Empresa>(Empresa.class).save(empresaAGuardar);
        return empresaAGuardar;
    }
}
