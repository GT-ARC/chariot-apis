package com.gtarc.chariot.api.model.exception;

/**
 * ISCO API exception that indicates that it was tried to instantiate an abstract Smart City Object.
 * 
 * @author ckuster
 *
 */
public class ISCORequestException extends ISCOException {

	private static final long serialVersionUID = -7269954108488444889L;
	
	public ISCORequestException() {
		super();
	}
	
	public ISCORequestException(String message) {
		super(message);
	}
	
	public ISCORequestException(Throwable cause) {
		super(cause);
	}
	
	public ISCORequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
