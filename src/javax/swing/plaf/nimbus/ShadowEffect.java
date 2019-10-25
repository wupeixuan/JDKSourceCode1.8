/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.plaf.nimbus;

import java.awt.Color;

/**
 * ShadowEffect - base class with all the standard properties for shadow effects
 *
 * @author Created by Jasper Potts (Jun 18, 2007)
 */
abstract class ShadowEffect extends Effect {
    protected Color color = Color.BLACK;
    /** Opacity a float 0-1 for percentage */
    protected float opacity = 0.75f;
    /** Angle in degrees between 0-360 */
    protected int angle = 135;
    /** Distance in pixels */
    protected int distance = 5;
    /** The shadow spread between 0-100 % */
    protected int spread = 0;
    /** Size in pixels */
    protected int size = 5;

    // =================================================================================================================
    // Bean methods

    Color getColor() {
        return color;
    }

    void setColor(Color color) {
        Color old = getColor();
        this.color = color;
    }

    float getOpacity() {
        return opacity;
    }

    void setOpacity(float opacity) {
        float old = getOpacity();
        this.opacity = opacity;
    }

    int getAngle() {
        return angle;
    }

    void setAngle(int angle) {
        int old = getAngle();
        this.angle = angle;
    }

    int getDistance() {
        return distance;
    }

    void setDistance(int distance) {
        int old = getDistance();
        this.distance = distance;
    }

    int getSpread() {
        return spread;
    }

    void setSpread(int spread) {
        int old = getSpread();
        this.spread = spread;
    }

    int getSize() {
        return size;
    }

    void setSize(int size) {
        int old = getSize();
        this.size = size;
    }
}
