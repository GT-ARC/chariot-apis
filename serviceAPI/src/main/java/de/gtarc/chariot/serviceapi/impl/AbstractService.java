/**
 *
 */
package de.gtarc.chariot.serviceapi.impl;

import de.gtarc.chariot.serviceapi.Service;

/**
 *
 * @author cemakpolat
 *
 */
public abstract class AbstractService implements Service {


    public abstract void start();

    public abstract void run();

    public abstract void stop();

    public abstract boolean isRunning();


} //AbstractService
