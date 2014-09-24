package servicios;

import managers.EmpresaManager;
import modelo.Empresa;

import org.junit.After;
import org.junit.Before;

public class EmpresaServicioTest extends AbstractHibernateTest {

	private EmpresaManager manager;

	@Before
	public void setUp() {
		this.manager = new EmpresaManager();
	}

	@After
	public void tearDown() {
	}

	/**
	 * El test de consultar nunca va a funcionar bien porque como la consulta es por id, 
	 * nunca me aseguro de que el id de esa empresa sea el mismo.
	 * @throws Exception
	 */
	public void testConsultarEmpresa() throws Exception {
		this.manager.crearEmpresa("Empresa Consultar");
		Empresa empresaConsultada = manager.consultarEmpresa(3);
		assertEquals("Empresa Consultar", empresaConsultada.getNombreDeLaEmpresa());
	}

	public void testModificarEmpresa() throws Exception {
		this.manager.crearEmpresa("Empresa SinModificar");
		Empresa empresaModificada = manager.modificarEmpresa(1, "Empresa Modificada");
		assertEquals("Empresa Modificada", empresaModificada.getNombreDeLaEmpresa());
	}

	public void testCrearEmpresa() throws Exception {
		manager.crearEmpresa("Empresa Nueva");
	}

}