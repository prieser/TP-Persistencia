package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentDAO {

	public Department getByName(final String name) {
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("from Department where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	public Department getByCode(String num) {
		Session session = SessionManager.getSession();
		return (Department) session.get(Department.class, num);
	}

	public Department getByCodeToPagosReview(String num) {
		Session session = SessionManager.getSession();
		Query query = session.createQuery("select d from Department d join d.employees e join e.salaries s where d.number = :number and s.to = '9999-01-01'");
		query.setParameter("number", num);
		return (Department) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createCriteria(Department.class).list();
	}

	public List<Department> getAllWithManager() {
		Session session = SessionManager.getSession();
		return session.createQuery("select d from Department d join d.managers").list();
	}

}
