package com.gtarc.chariot.api.model.exception;

/**
 * Generic ISCO API exception
 * 
 * @author ckuster
 *
 */
public class ISCOException extends Exception {

	private static final long serialVersionUID = -7269954108488444889L;
	
	public ISCOException() {
		super();
	}
	
	public ISCOException(String message) {
		super(message);
	}
	
	public ISCOException(Throwable cause) {
		super(cause);
	}
	
	public ISCOException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
