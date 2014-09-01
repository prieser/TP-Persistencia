package modelo;

public class Usuario {

    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String email;
    private String fechaDeNacimiento;
    private String contrasenia;
    private String codigoDeValidacion;
    private boolean activo;

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

    public Usuario(String nombre, String apellido, String nombreUsuario, String email, String fechaDeNacimiento, String contrasenia) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasenia = contrasenia;
     }
    
    public Usuario(String nombre, String apellido, String nombreUsuario, String email, String fechaDeNacimiento, String contrasenia, String codigoDeValidacion, Boolean activo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.contrasenia = contrasenia;
        this.codigoDeValidacion = codigoDeValidacion;
        this.activo = activo;
     }

    public Usuario() {
        super();
    }

	public String getCodigoDeValidacion() {
		return codigoDeValidacion;
	}

	public void setCodigoDeValidacion(String codigoDeValidacion) {
		this.codigoDeValidacion = codigoDeValidacion;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public boolean getActivo() {
		return this.activo ;
	}
	
	public boolean equals(Object obj){
		Usuario usuario = (Usuario) obj;
		return (usuario.getNombreUsuario() == this.getNombreUsuario());
	}

}
