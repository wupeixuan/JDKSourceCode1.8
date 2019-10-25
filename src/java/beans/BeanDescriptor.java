/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
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

package java.beans;

import java.lang.ref.Reference;

/**
 * A BeanDescriptor provides global information about a "bean",
 * including its Java class, its displayName, etc.
 * <p>
 * This is one of the kinds of descriptor returned by a BeanInfo object,
 * which also returns descriptors for properties, method, and events.
 */

public class BeanDescriptor extends FeatureDescriptor {

    private Reference<? extends Class<?>> beanClassRef;
    private Reference<? extends Class<?>> customizerClassRef;

    /**
     * Create a BeanDescriptor for a bean that doesn't have a customizer.
     *
     * @param beanClass  The Class object of the Java class that implements
     *          the bean.  For example sun.beans.OurButton.class.
     */
    public BeanDescriptor(Class<?> beanClass) {
        this(beanClass, null);
    }

    /**
     * Create a BeanDescriptor for a bean that has a customizer.
     *
     * @param beanClass  The Class object of the Java class that implements
     *          the bean.  For example sun.beans.OurButton.class.
     * @param customizerClass  The Class object of the Java class that implements
     *          the bean's Customizer.  For example sun.beans.OurButtonCustomizer.class.
     */
    public BeanDescriptor(Class<?> beanClass, Class<?> customizerClass) {
        this.beanClassRef = getWeakReference(beanClass);
        this.customizerClassRef = getWeakReference(customizerClass);

        String name = beanClass.getName();
        while (name.indexOf('.') >= 0) {
            name = name.substring(name.indexOf('.')+1);
        }
        setName(name);
    }

    /**
     * Gets the bean's Class object.
     *
     * @return The Class object for the bean.
     */
    public Class<?> getBeanClass() {
        return (this.beanClassRef != null)
                ? this.beanClassRef.get()
                : null;
    }

    /**
     * Gets the Class object for the bean's customizer.
     *
     * @return The Class object for the bean's customizer.  This may
     * be null if the bean doesn't have a customizer.
     */
    public Class<?> getCustomizerClass() {
        return (this.customizerClassRef != null)
                ? this.customizerClassRef.get()
                : null;
    }

    /*
     * Package-private dup constructor
     * This must isolate the new object from any changes to the old object.
     */
    BeanDescriptor(BeanDescriptor old) {
        super(old);
        beanClassRef = old.beanClassRef;
        customizerClassRef = old.customizerClassRef;
    }

    void appendTo(StringBuilder sb) {
        appendTo(sb, "beanClass", this.beanClassRef);
        appendTo(sb, "customizerClass", this.customizerClassRef);
    }
}
