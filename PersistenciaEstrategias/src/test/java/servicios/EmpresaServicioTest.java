package servicios;

import modelo.aerolinea.Empresa;
import modelo.managers.EmpresaManager;
import org.junit.After;
import org.junit.Before;

public class EmpresaServicioTest extends AbstractHibernateTest {

	private EmpresaManager manager;

	@Before
	public void setUp() {
		this.manager = new EmpresaManager();
	}

    public void testCrearEmpresa() throws Exception {
        manager.crearEmpresa("Empresa Nueva");
    }

	public void testModificarEmpresa() throws Exception {
		this.manager.crearEmpresa("Empresa SinModificar");
		Empresa empresaModificada = manager.modificarEmpresa(1, "Empresa Modificada");
		assertEquals("Empresa Modificada", empresaModificada.getNombreDeLaEmpresa());
	}


}