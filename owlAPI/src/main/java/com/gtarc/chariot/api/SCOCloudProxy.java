package com.gtarc.chariot.api;

import java.io.Serializable;

import com.gtarc.chariot.api.jiacbinding.IJiacContext;

/**
 * This proxy class enables for invoking JIAC V actions.
 * 
 * @author ckuster
 *
 */
public class SCOCloudProxy {
	
	private IJiacContext jiacContext = null;

	public SCOCloudProxy() {
		super();
	}
	
	/**
	 * Invoke the given SCO using JIAC V.
	 * 
	 * @param scoName The action name.
	 * @param parameter The parameter list.
	 * @return The result of the SCO.
	 */
	public String invokeService(String scoName, Serializable[] parameter) {
		return jiacContext.invokeService(scoName, parameter);
	}

	public void setJiacContext(IJiacContext jiacContext) {
		this.jiacContext = jiacContext;
	}
	
}
