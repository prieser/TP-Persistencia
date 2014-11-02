package modelo.usuario;

import excepciones.NuevaPasswordInválidaException;
import excepciones.PasswordIncorrectaException;
import excepciones.UsuarioNoExiste;
import excepciones.UsuarioYaExisteException;
import repository.UsuarioRepository;

import java.util.Random;

public class Sistema {

    private UsuarioRepository usuarioRepository;

    /**
     * Este metodo se encarga de registrar al usuario que recibe por parametros.
     * Antes de eso verifica que no exista ya un usuario.
     *
     * @param usuarioNuevo
     * @throws UsuarioYaExisteException
     */
    public void RegistrarUsuario(Usuario usuarioNuevo) throws Exception {

        this.usuarioRepository = new UsuarioRepository();

        if (!usuarioRepository.existe(usuarioNuevo)) {
            this.mandarMailValidacion(usuarioNuevo);
            this.usuarioRepository.guardar(usuarioNuevo);
        } else {
            throw new UsuarioYaExisteException();
        }
    }

    /**
     * Este metodo valida al usuario que tiene el codigo validacion pasado como
     * parametro.
     *
     * @param codigoValidación
     * @throws Exception
     */
    public void ValidarCuenta(String codigoValidación) throws Exception {
        this.usuarioRepository = new UsuarioRepository();
        Usuario usuario = this.usuarioRepository.dameUnoConCodigoDeValidacion(codigoValidación);
        if (usuario == null) {
            throw new UsuarioNoExiste();
        } else {
            usuario.setActivo(true);
            this.usuarioRepository.actualizar(usuario);
        }

    }

    public Usuario IngresarUsuario(String userName, String password)
            throws Exception {
        this.usuarioRepository = new UsuarioRepository();
        Usuario usuario = this.usuarioRepository.dameUno(userName);

        if (usuario == null) {
            throw new UsuarioNoExiste();
        }

        if ((password.equals(usuario.getContrasenia()) && (usuario.isActivo()))) {
            return usuario;
        } else {
            throw new PasswordIncorrectaException();
        }

    }

    /**
     * Este metodo cambia la contrasenia del usuario userName por una nueva.
     * Antes de hacerlo, verifica que su password actual sea correcta. Si es
     * incorrecta lanza una excepcion.
     *
     * @param userName
     * @param viejaPassword
     * @param nuevaPassword
     * @throws Exception
     */
    public void CambiarPassword(String userName, String viejaPassword,
                                String nuevaPassword) throws Exception {
        this.usuarioRepository = new UsuarioRepository();
        Usuario usuario = this.usuarioRepository.dameUno(userName);
        if (viejaPassword.equals(nuevaPassword)) {
            throw new NuevaPasswordInválidaException();
        } else {
            usuario.setContrasenia(nuevaPassword);
            this.usuarioRepository.actualizar(usuario);
        }
    }

    private String generarCodigoValidacion() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    private void mandarMailValidacion(Usuario unUsuario) {

        String codigo = this.generarCodigoValidacion();
        Mail mail = new Mail(codigo, "Codigo Validacion", unUsuario.getEmail(), "sistema@sistema.com");
        EnviadorDeMails enviador = new EnviadorDeMails();
        enviador.enviarMail(mail, unUsuario);

    }

}
