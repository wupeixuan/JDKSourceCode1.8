/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.plaf.synth;

import sun.swing.DefaultLookup;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

/**
 * SynthDefaultLookup redirects all lookup calls to the SynthContext.
 *
 * @author Scott Violet
 */
class SynthDefaultLookup extends DefaultLookup {
    public Object getDefault(JComponent c, ComponentUI ui, String key) {
        if (!(ui instanceof SynthUI)) {
            Object value = super.getDefault(c, ui, key);
            return value;
        }
        SynthContext context = ((SynthUI)ui).getContext(c);
        Object value = context.getStyle().get(context, key);
        context.dispose();
        return value;
    }
}
