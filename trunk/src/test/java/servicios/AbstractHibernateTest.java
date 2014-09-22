package servicios;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import junit.framework.TestCase;

public abstract class AbstractHibernateTest extends TestCase {

	private SessionFactory sessionFactory;

	public AbstractHibernateTest() {
		super();
	}

	public AbstractHibernateTest(String name) {
		super(name);
	}

}