package modelo.servicios.busqueda;

import modelo.busquedas.Busqueda;
import modelo.daos.SessionManager;
import modelo.servicios.Operation;
import modelo.usuario.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;

public class TraerBusquedas implements Operation<ArrayList<Busqueda>> {

    private Usuario usuario;

    public TraerBusquedas(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public ArrayList<Busqueda> execute() {
        Session session = SessionManager.getSession();
        Query query = session.createQuery("SELECT b FROM Busqueda b");
        return (ArrayList<Busqueda>) query.list();
    }
}
