/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

import static sun.reflect.misc.ReflectUtil.isPackageAccessible;

final class MethodRef {
    private String signature;
    private SoftReference<Method> methodRef;
    private WeakReference<Class<?>> typeRef;

    void set(Method method) {
        if (method == null) {
            this.signature = null;
            this.methodRef = null;
            this.typeRef = null;
        }
        else {
            this.signature = method.toGenericString();
            this.methodRef = new SoftReference<>(method);
            this.typeRef = new WeakReference<Class<?>>(method.getDeclaringClass());
        }
    }

    boolean isSet() {
        return this.methodRef != null;
    }

    Method get() {
        if (this.methodRef == null) {
            return null;
        }
        Method method = this.methodRef.get();
        if (method == null) {
            method = find(this.typeRef.get(), this.signature);
            if (method == null) {
                this.signature = null;
                this.methodRef = null;
                this.typeRef = null;
                return null;
            }
            this.methodRef = new SoftReference<>(method);
        }
        return isPackageAccessible(method.getDeclaringClass()) ? method : null;
    }

    private static Method find(Class<?> type, String signature) {
        if (type != null) {
            for (Method method : type.getMethods()) {
                if (type.equals(method.getDeclaringClass())) {
                    if (method.toGenericString().equals(signature)) {
                        return method;
                    }
                }
            }
        }
        return null;
    }
}
