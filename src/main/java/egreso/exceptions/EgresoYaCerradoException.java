package egreso.exceptions;

public class EgresoYaCerradoException extends Exception {

	public EgresoYaCerradoException() {
	}

	public EgresoYaCerradoException(String message) {
		super(message);
	}

	public EgresoYaCerradoException(Throwable cause) {
		super(cause);
	}

	public EgresoYaCerradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public EgresoYaCerradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
