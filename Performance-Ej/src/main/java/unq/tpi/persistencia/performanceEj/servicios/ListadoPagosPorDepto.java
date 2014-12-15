package unq.tpi.persistencia.performanceEj.servicios;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;

public class ListadoPagosPorDepto extends AbstractListado {

	private String num;
	private Department depto = null;

	public ListadoPagosPorDepto(String num) {
		this.num = num;
	}

	@Override
	protected void doListado() throws Exception {
		depto = new DepartmentDAO().getByCodeToPagosReview(num);
//		depto = new DepartmentDAO().getByCode(num);

		
		// Con la nueva query la busqueda se hace bien pero el problema esta que en el get totalsalaries de abajo hace una consulta
		// x cada empleado para obtener el salario 
		
		this.newLine();
		this.addColumn("Total").addColumn(depto.getTotalSalaries()).newLine();
    	this.newLine();
		
		this.addColumn("Nombre");
		this.addColumn("Titulo");
		this.addColumn("Monto");
		this.newLine();

    	for (Employee e : depto.getEmployees()) {
			this.addColumn(e.getFullName());
			this.addColumn(e.getTitle());
     		this.addColumn(e.getSalary());
			this.newLine();
		}
	}

	@Override
	public String getFilename() {
		return "./target/PagosPorDepto.csv";
	}
}
