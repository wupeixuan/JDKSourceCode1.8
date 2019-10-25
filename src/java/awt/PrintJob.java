/*
 * Copyright (c) 1996, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package java.awt;

/**
 * An abstract class which initiates and executes a print job.
 * It provides access to a print graphics object which renders
 * to an appropriate print device.
 *
 * @see Toolkit#getPrintJob
 *
 * @author      Amy Fowler
 */
public abstract class PrintJob {

    /**
     * Gets a Graphics object that will draw to the next page.
     * The page is sent to the printer when the graphics
     * object is disposed.  This graphics object will also implement
     * the PrintGraphics interface.
     * @see PrintGraphics
     */
    public abstract Graphics getGraphics();

    /**
     * Returns the dimensions of the page in pixels.
     * The resolution of the page is chosen so that it
     * is similar to the screen resolution.
     */
    public abstract Dimension getPageDimension();

    /**
     * Returns the resolution of the page in pixels per inch.
     * Note that this doesn't have to correspond to the physical
     * resolution of the printer.
     */
    public abstract int getPageResolution();

    /**
     * Returns true if the last page will be printed first.
     */
    public abstract boolean lastPageFirst();

    /**
     * Ends the print job and does any necessary cleanup.
     */
    public abstract void end();

    /**
     * Ends this print job once it is no longer referenced.
     * @see #end
     */
    public void finalize() {
        end();
    }

}
