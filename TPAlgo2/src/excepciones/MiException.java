package excepciones;

public class MiException extends Exception {
	public static final long serialVersionUID = 700L;
	
	public MiException(String mensaje) {
		super(mensaje);
	}

}
