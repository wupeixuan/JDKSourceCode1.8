/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.annotation.Native;

/**
 * The <code>DisplayMode</code> class encapsulates the bit depth, height,
 * width, and refresh rate of a <code>GraphicsDevice</code>. The ability to
 * change graphics device's display mode is platform- and
 * configuration-dependent and may not always be available
 * (see {@link GraphicsDevice#isDisplayChangeSupported}).
 * <p>
 * For more information on full-screen exclusive mode API, see the
 * <a href="https://docs.oracle.com/javase/tutorial/extra/fullscreen/index.html">
 * Full-Screen Exclusive Mode API Tutorial</a>.
 *
 * @see GraphicsDevice
 * @see GraphicsDevice#isDisplayChangeSupported
 * @see GraphicsDevice#getDisplayModes
 * @see GraphicsDevice#setDisplayMode
 * @author Michael Martak
 * @since 1.4
 */

public final class DisplayMode {

    private Dimension size;
    private int bitDepth;
    private int refreshRate;

    /**
     * Create a new display mode object with the supplied parameters.
     * @param width the width of the display, in pixels
     * @param height the height of the display, in pixels
     * @param bitDepth the bit depth of the display, in bits per
     *        pixel.  This can be <code>BIT_DEPTH_MULTI</code> if multiple
     *        bit depths are available.
     * @param refreshRate the refresh rate of the display, in hertz.
     *        This can be <code>REFRESH_RATE_UNKNOWN</code> if the
     *        information is not available.
     * @see #BIT_DEPTH_MULTI
     * @see #REFRESH_RATE_UNKNOWN
     */
    public DisplayMode(int width, int height, int bitDepth, int refreshRate) {
        this.size = new Dimension(width, height);
        this.bitDepth = bitDepth;
        this.refreshRate = refreshRate;
    }

    /**
     * Returns the height of the display, in pixels.
     * @return the height of the display, in pixels
     */
    public int getHeight() {
        return size.height;
    }

    /**
     * Returns the width of the display, in pixels.
     * @return the width of the display, in pixels
     */
    public int getWidth() {
        return size.width;
    }

    /**
     * Value of the bit depth if multiple bit depths are supported in this
     * display mode.
     * @see #getBitDepth
     */
    @Native public final static int BIT_DEPTH_MULTI = -1;

    /**
     * Returns the bit depth of the display, in bits per pixel.  This may be
     * <code>BIT_DEPTH_MULTI</code> if multiple bit depths are supported in
     * this display mode.
     *
     * @return the bit depth of the display, in bits per pixel.
     * @see #BIT_DEPTH_MULTI
     */
    public int getBitDepth() {
        return bitDepth;
    }

    /**
     * Value of the refresh rate if not known.
     * @see #getRefreshRate
     */
    @Native public final static int REFRESH_RATE_UNKNOWN = 0;

    /**
     * Returns the refresh rate of the display, in hertz.  This may be
     * <code>REFRESH_RATE_UNKNOWN</code> if the information is not available.
     *
     * @return the refresh rate of the display, in hertz.
     * @see #REFRESH_RATE_UNKNOWN
     */
    public int getRefreshRate() {
        return refreshRate;
    }

    /**
     * Returns whether the two display modes are equal.
     * @return whether the two display modes are equal
     */
    public boolean equals(DisplayMode dm) {
        if (dm == null) {
            return false;
        }
        return (getHeight() == dm.getHeight()
            && getWidth() == dm.getWidth()
            && getBitDepth() == dm.getBitDepth()
            && getRefreshRate() == dm.getRefreshRate());
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object dm) {
        if (dm instanceof DisplayMode) {
            return equals((DisplayMode)dm);
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return getWidth() + getHeight() + getBitDepth() * 7
            + getRefreshRate() * 13;
    }

}
