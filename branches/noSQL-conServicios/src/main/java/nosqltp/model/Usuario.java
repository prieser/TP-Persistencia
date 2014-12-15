package main.java.nosqltp.model;

import java.util.ArrayList;
import java.util.List;

import net.vz.mongodb.jackson.ObjectId;
import nosqltp.exceptions.YaExisteException;
import nosqltp.servicios.Comentario;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario {
	@ObjectId
	@JsonProperty("_id")
	private String idUsuario;

	private String nombreDeUsuario;
	private List<Usuario> usuariosQueSigo;
	private List<Destino> destinos;

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public List<Usuario> getUsuariosQueSigo() {
		return usuariosQueSigo;
	}

	public void setUsuariosQueSigo(List<Usuario> usuariosQueSigo) {
		this.usuariosQueSigo = usuariosQueSigo;
	}

	public List<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public Usuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
		this.usuariosQueSigo = new ArrayList<Usuario>();
		this.destinos = new ArrayList<Destino>();
	}

	public Usuario() {
	}

	public void seguir(Usuario seguidor) {
		this.getUsuariosQueSigo().add(seguidor);
	}

	public void agregarDestino(Destino destinoNuevo) {
		if (!this.getDestinos().contains(destinoNuevo)) {
			this.getDestinos().add(destinoNuevo);
		} else {
			throw new YaExisteException("El destino que intenta guardar ya existe");
		}
	}

	public void comentarDestino(Destino destinoAComentar, Comentario comentario) {
		destinoAComentar.agregarComentario(comentario);
	}

	public boolean isSeguidor(Usuario amigoPosible) {
		return this.getUsuariosQueSigo().contains(amigoPosible);
	}

	public void agregarComentario(String nombreDestino, Comentario comentario) {
		for (Destino unDestino : this.getDestinos()) {
			if (unDestino.getNombreDestino().equals(nombreDestino)) {
				unDestino.agregarComentario(comentario);
			}
		}
	}

	public List<Comentario> getAllComentarios() {
		List<Comentario> comentarios;
		for (Destino unDestino : this.getDestinos()) {
			comentarios.addAll(unDestino.getComentarios());
		}
		return comentarios;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Usuario usuario = (Usuario) o;

		if (!nombreDeUsuario.equals(usuario.nombreDeUsuario))
			return false;

		return true;
	}

}
