package modelo.servicios;


import excepciones.AsientoYaReservadoException;

public interface Operation<T> {
    public T execute();
}
