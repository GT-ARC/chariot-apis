package com.gtarc.chariot.api;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Preconfigured Connector to the ISCO Development instance of the service cirectory.
 * It can be used as-is.
 * 
 * @author ckuster
 *
 */
public final class ChariotDevServiceDirectoryConnector extends ServiceDirectoryConnector {
	
	/**
	 * The default endpoint for the ISCO Development Virtual Machine.
	 */
	public static final URL DEFAULT_ENDPOINT;
	
	/**
	 * Preconfigured graph model name.
	 */
	public static final String GRAPH_MODEL;
	
	static {
		URL url;
		try {
			 url = new URL("http://isco-dev.aot.tu-berlin.de:3030/servicedirectory/");
		} catch (MalformedURLException e) {
			url = null;
		}
		DEFAULT_ENDPOINT = url;
		GRAPH_MODEL= "services";
	}

	public ChariotDevServiceDirectoryConnector() throws MalformedURLException {
		super(DEFAULT_ENDPOINT, GRAPH_MODEL);
	}
	
	public ChariotDevServiceDirectoryConnector(String graphmodel) throws MalformedURLException {
		super(DEFAULT_ENDPOINT, graphmodel);
	}

}
