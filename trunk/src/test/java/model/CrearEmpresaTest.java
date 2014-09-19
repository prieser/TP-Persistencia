package model;

import modelo.servicios.Empresa.EmpresaManager;

public class CrearEmpresaTest extends AbstractHibernateTest {

    public void testApp() throws Exception {
        new EmpresaManager().crearEmpresa("Empresa A");
    }
}
