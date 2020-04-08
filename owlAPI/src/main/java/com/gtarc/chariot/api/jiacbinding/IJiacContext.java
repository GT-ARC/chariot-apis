package com.gtarc.chariot.api.jiacbinding;

import java.io.Serializable;

import com.gtarc.chariot.api.SCOCloudProxy;

/**
 * The JIAC V context interface. Used by {@link SCOCloudProxy} to enable for the invocation of JIAC V actions.
 * 
 * @author ckuster
 *
 */
public interface IJiacContext {

	String invokeService(String serviceName, Serializable[] parameter);

}
