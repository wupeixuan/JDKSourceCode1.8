/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import javax.management.Descriptor;
import javax.management.ImmutableDescriptor;
import javax.management.JMX;

public class DescriptorCache {
    private DescriptorCache() {
    }

    static DescriptorCache getInstance() {
        return instance;
    }

    public static DescriptorCache getInstance(JMX proof) {
        if (proof != null)
            return instance;
        else
            return null;
    }

    public ImmutableDescriptor get(ImmutableDescriptor descriptor) {
        WeakReference<ImmutableDescriptor> wr = map.get(descriptor);
        ImmutableDescriptor got = (wr == null) ? null : wr.get();
        if (got != null)
            return got;
        map.put(descriptor, new WeakReference<ImmutableDescriptor>(descriptor));
        return descriptor;
    }

    public ImmutableDescriptor union(Descriptor... descriptors) {
        return get(ImmutableDescriptor.union(descriptors));
    }

    private final static DescriptorCache instance = new DescriptorCache();
    private final WeakHashMap<ImmutableDescriptor,
                              WeakReference<ImmutableDescriptor>>
        map = new WeakHashMap<ImmutableDescriptor,
                              WeakReference<ImmutableDescriptor>>();
}
