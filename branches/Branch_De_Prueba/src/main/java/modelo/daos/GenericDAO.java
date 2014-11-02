package modelo.daos;

public class GenericDAO<T> {

    final Class<T> tipo;

    public GenericDAO(Class<T> tipo) {
        this.tipo = tipo;
    }

    public Object get(int idT) {
        return SessionManager.getSession().get(tipo, idT);
    }

    public void save(T instanciaT) {
        SessionManager.getSession().saveOrUpdate(instanciaT);
    }
}
