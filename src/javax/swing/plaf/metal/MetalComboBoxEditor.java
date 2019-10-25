/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.metal;

import javax.swing.*;
import javax.swing.border.*;
import java.io.Serializable;
import java.awt.*;
import java.awt.event.*;

import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 * The default editor for Metal editable combo boxes
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author Steve Wilson
 */
public class MetalComboBoxEditor extends BasicComboBoxEditor {

    public MetalComboBoxEditor() {
        super();
        //editor.removeFocusListener(this);
        editor = new JTextField("",9) {
                // workaround for 4530952
                public void setText(String s) {
                    if (getText().equals(s)) {
                        return;
                    }
                    super.setText(s);
                }
            // The preferred and minimum sizes are overriden and padded by
            // 4 to keep the size as it previously was.  Refer to bugs
            // 4775789 and 4517214 for details.
            public Dimension getPreferredSize() {
                Dimension pref = super.getPreferredSize();
                pref.height += 4;
                return pref;
            }
            public Dimension getMinimumSize() {
                Dimension min = super.getMinimumSize();
                min.height += 4;
                return min;
            }
            };

        editor.setBorder( new EditorBorder() );
        //editor.addFocusListener(this);
    }

   /**
    * The default editor border <code>Insets</code>. This field
    * might not be used.
    */
    protected static Insets editorBorderInsets = new Insets( 2, 2, 2, 0 );

    class EditorBorder extends AbstractBorder {
        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            g.translate( x, y );

            if (MetalLookAndFeel.usingOcean()) {
                g.setColor(MetalLookAndFeel.getControlDarkShadow());
                g.drawRect(0, 0, w, h - 1);
                g.setColor(MetalLookAndFeel.getControlShadow());
                g.drawRect(1, 1, w - 2, h - 3);
            }
            else {
                g.setColor( MetalLookAndFeel.getControlDarkShadow() );
                g.drawLine( 0, 0, w-1, 0 );
                g.drawLine( 0, 0, 0, h-2 );
                g.drawLine( 0, h-2, w-1, h-2 );
                g.setColor( MetalLookAndFeel.getControlHighlight() );
                g.drawLine( 1, 1, w-1, 1 );
                g.drawLine( 1, 1, 1, h-1 );
                g.drawLine( 1, h-1, w-1, h-1 );
                g.setColor( MetalLookAndFeel.getControl() );
                g.drawLine( 1, h-2, 1, h-2 );
            }

            g.translate( -x, -y );
        }

        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(2, 2, 2, 0);
            return insets;
        }
    }


    /**
     * A subclass of BasicComboBoxEditor that implements UIResource.
     * BasicComboBoxEditor doesn't implement UIResource
     * directly so that applications can safely override the
     * cellRenderer property with BasicListCellRenderer subclasses.
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with
     * future Swing releases. The current serialization support is
     * appropriate for short term storage or RMI between applications running
     * the same version of Swing.  As of 1.4, support for long term storage
     * of all JavaBeans&trade;
     * has been added to the <code>java.beans</code> package.
     * Please see {@link java.beans.XMLEncoder}.
     */
    public static class UIResource extends MetalComboBoxEditor
    implements javax.swing.plaf.UIResource {
    }
}
