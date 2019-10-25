/*
 * Copyright (c) 2007, 2008, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.mbeanserver;

import javax.management.openmbean.*;
import com.sun.jmx.mbeanserver.MXBeanMapping;
import com.sun.jmx.mbeanserver.DefaultMXBeanMappingFactory;
import java.lang.reflect.Type;

/**
 * <p>Defines how types are mapped for a given MXBean or set of MXBeans.
 * An {@code MXBeanMappingFactory} can be specified either through the
 * {@link MXBeanMappingFactoryClass} annotation, or through the
 * {@link javax.management.JMX.MBeanOptions JMX.MBeanOptions} argument to a
 * {@link javax.management.StandardMBean StandardMBean} constructor or MXBean
 * proxy.</p>
 *
 * <p>An {@code MXBeanMappingFactory} must return an {@code MXBeanMapping}
 * for any Java type that appears in the MXBeans that the factory is being
 * used for.  Usually it does that by handling any custom types, and
 * forwarding everything else to the {@linkplain #DEFAULT default mapping
 * factory}.</p>
 *
 * <p>Consider the {@code MyLinkedList} example from the {@link MXBeanMapping}
 * documentation.  If we are unable to change the {@code MyLinkedList} class
 * to add an {@link MXBeanMappingClass} annotation, we could achieve the same
 * effect by defining {@code MyLinkedListMappingFactory} as follows:</p>
 *
 * <pre>
 * public class MyLinkedListMappingFactory extends MXBeanMappingFactory {
 *     public MyLinkedListMappingFactory() {}
 *
 *     public MXBeanMapping mappingForType(Type t, MXBeanMappingFactory f)
 *     throws OpenDataException {
 *         if (t == MyLinkedList.class)
 *             return new MyLinkedListMapping(t);
 *         else
 *             return MXBeanMappingFactory.DEFAULT.mappingForType(t, f);
 *     }
 * }
 * </pre>
 *
 * <p>The mapping factory handles only the {@code MyLinkedList} class.
 * Every other type is forwarded to the default mapping factory.
 * This includes types such as {@code MyLinkedList[]} and
 * {@code List<MyLinkedList>}; the default mapping factory will recursively
 * invoke {@code MyLinkedListMappingFactory} to map the contained
 * {@code MyLinkedList} type.</p>
 *
 * <p>Once we have defined {@code MyLinkedListMappingFactory}, we can use
 * it in an MXBean interface like this:</p>
 *
 * <pre>
 * {@literal @MXBeanMappingFactoryClass}(MyLinkedListMappingFactory.class)
 * public interface SomethingMXBean {
 *     public MyLinkedList getSomething();
 * }
 * </pre>
 *
 * <p>Alternatively we can annotate the package that {@code SomethingMXBean}
 * appears in, or we can supply the factory to a {@link
 * javax.management.StandardMBean StandardMBean} constructor or MXBean
 * proxy.</p>
 *
 * @see <a href="../MXBean.html#custom">MXBean specification, section
 * "Custom MXBean type mappings"</a>
 */
public abstract class MXBeanMappingFactory {
    /**
     * <p>Construct an instance of this class.</p>
     */
    protected MXBeanMappingFactory() {}

    /**
     * <p>Mapping factory that applies the default rules for MXBean
     * mappings, as described in the <a
     * href="../MXBean.html#MXBean-spec">MXBean specification</a>.</p>
     */
    public static final MXBeanMappingFactory DEFAULT =
            new DefaultMXBeanMappingFactory();

    /**
     * <p>Return the mapping for the given Java type.  Typically, a
     * mapping factory will return mappings for types it handles, and
     * forward other types to another mapping factory, most often
     * the {@linkplain #DEFAULT default one}.</p>
     * @param t the Java type to be mapped.
     * @param f the original mapping factory that was consulted to do
     * the mapping.  A mapping factory should pass this parameter intact
     * if it forwards a type to another mapping factory.  In the example,
     * this is how {@code MyLinkedListMappingFactory} works for types
     * like {@code MyLinkedList[]} and {@code List<MyLinkedList>}.
     * @return the mapping for the given type.
     * @throws OpenDataException if this type cannot be mapped.  This
     * exception is appropriate if the factory is supposed to handle
     * all types of this sort (for example, all linked lists), but
     * cannot handle this particular type.
     */
    public abstract MXBeanMapping mappingForType(Type t, MXBeanMappingFactory f)
    throws OpenDataException;
}
