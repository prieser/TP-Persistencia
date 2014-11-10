package modelo.managers;

import java.util.ArrayList;

import modelo.aerolinea.Vuelo;
import modelo.busquedas.Busqueda;
import modelo.daos.SessionManager;
import modelo.servicios.busqueda.BuscarVuelos;
import modelo.usuario.Usuario;

import org.hibernate.Query;
import org.hibernate.Session;

public class BusquedaManager {

    @SuppressWarnings("unchecked")
	public ArrayList<Busqueda> traerBusquedas(Usuario usuario) {
    	Session session = SessionManager.getSession();
		Query query = session.createQuery("SELECT busqueda from Usuario usuario join usuario.busquedas busqueda where usuario = :usuario");
        query.setParameter("usuario", usuario);
		return (ArrayList<Busqueda>) query.list();
    }
    
	@SuppressWarnings("unchecked")
	public ArrayList<Vuelo> buscarVuelos(Busqueda busqueda) {
        return SessionManager.runInSession(new BuscarVuelos(busqueda));
	}

}