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

import javax.swing.Painter;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * TableScrollPaneCorner - A simple component that paints itself using the table
 * header background painter. It is used to fill the top right corner of
 * scrollpane.
 *
 * @author Created by Jasper Potts (Jan 28, 2008)
 */
class TableScrollPaneCorner extends JComponent implements UIResource{

    /**
     * Paint the component using the Nimbus Table Header Background Painter
     */
    @Override protected void paintComponent(Graphics g) {
        Painter painter = (Painter) UIManager.get(
            "TableHeader:\"TableHeader.renderer\"[Enabled].backgroundPainter");
        if (painter != null){
            if (g instanceof Graphics2D){
                painter.paint((Graphics2D)g,this,getWidth()+1,getHeight());
            } else {
                // paint using image to not Graphics2D to support
                // Java 1.1 printing API
                BufferedImage img =  new BufferedImage(getWidth(),getHeight(),
                        BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = (Graphics2D)img.getGraphics();
                painter.paint(g2,this,getWidth()+1,getHeight());
                g2.dispose();
                g.drawImage(img,0,0,null);
                img = null;
            }
        }
    }
}
