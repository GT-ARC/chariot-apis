/**
 *
 */
package de.gtarc.chariot.serviceapi;

import de.gtarc.commonapi.Description;

/**
 *
 * @author cemakpolat
 *
 */
public interface ServiceDescription extends Description {

    String getServiceType();

    void setServiceType(String value);

    String getServiceProvider();
    void setServiceProvider(String value);

} // ServiceDescription
