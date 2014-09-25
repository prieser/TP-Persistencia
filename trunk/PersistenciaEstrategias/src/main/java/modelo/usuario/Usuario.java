package modelo.usuario;

import excepciones.AsientoYaReservadoException;
import modelo.aerolinea.Tramo;

public class Usuario {

    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String email;
    private String fechaDeNacimiento;
    private String contrasenia;
    private String codigoDeValidacion;
    private boolean activo;

    public Usuario(String nombre, String apellido, String nombreUsuario, String email, String fechaDeNacimiento, String contrasenia) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasenia = contrasenia;
    }

    public Usuario() {
        super();
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getCodigoDeValidacion() {
        return codigoDeValidacion;
    }

    public void setCodigoDeValidacion(String codigoDeValidacion) {
        this.codigoDeValidacion = codigoDeValidacion;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (nombreUsuario == null) {
            if (other.nombreUsuario != null)
                return false;
        } else if (!nombreUsuario.equals(other.nombreUsuario))
            return false;
        return true;
    }

    public void reservarAsiento(int numeroDeAsiento, Tramo tramoParaElQueQuieroReservar) throws AsientoYaReservadoException {
        tramoParaElQueQuieroReservar.reservarAsiento(numeroDeAsiento, this);
    }


}
