package egreso.exceptions;

public class EgresoNoTieneSoloArticulosException extends Exception {

	public EgresoNoTieneSoloArticulosException() {
	}

	public EgresoNoTieneSoloArticulosException(String message) {
		super(message);
	}

	public EgresoNoTieneSoloArticulosException(Throwable cause) {
		super(cause);
	}

	public EgresoNoTieneSoloArticulosException(String message, Throwable cause) {
		super(message, cause);
	}

	public EgresoNoTieneSoloArticulosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
