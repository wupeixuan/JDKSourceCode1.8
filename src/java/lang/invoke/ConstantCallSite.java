/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.invoke;

/**
 * A {@code ConstantCallSite} is a {@link CallSite} whose target is permanent, and can never be changed.
 * An {@code invokedynamic} instruction linked to a {@code ConstantCallSite} is permanently
 * bound to the call site's target.
 * @author John Rose, JSR 292 EG
 */
public class ConstantCallSite extends CallSite {
    private final boolean isFrozen;

    /**
     * Creates a call site with a permanent target.
     * @param target the target to be permanently associated with this call site
     * @throws NullPointerException if the proposed target is null
     */
    public ConstantCallSite(MethodHandle target) {
        super(target);
        isFrozen = true;
    }

    /**
     * Creates a call site with a permanent target, possibly bound to the call site itself.
     * <p>
     * During construction of the call site, the {@code createTargetHook} is invoked to
     * produce the actual target, as if by a call of the form
     * {@code (MethodHandle) createTargetHook.invoke(this)}.
     * <p>
     * Note that user code cannot perform such an action directly in a subclass constructor,
     * since the target must be fixed before the {@code ConstantCallSite} constructor returns.
     * <p>
     * The hook is said to bind the call site to a target method handle,
     * and a typical action would be {@code someTarget.bindTo(this)}.
     * However, the hook is free to take any action whatever,
     * including ignoring the call site and returning a constant target.
     * <p>
     * The result returned by the hook must be a method handle of exactly
     * the same type as the call site.
     * <p>
     * While the hook is being called, the new {@code ConstantCallSite}
     * object is in a partially constructed state.
     * In this state,
     * a call to {@code getTarget}, or any other attempt to use the target,
     * will result in an {@code IllegalStateException}.
     * It is legal at all times to obtain the call site's type using the {@code type} method.
     *
     * @param targetType the type of the method handle to be permanently associated with this call site
     * @param createTargetHook a method handle to invoke (on the call site) to produce the call site's target
     * @throws WrongMethodTypeException if the hook cannot be invoked on the required arguments,
     *         or if the target returned by the hook is not of the given {@code targetType}
     * @throws NullPointerException if the hook returns a null value
     * @throws ClassCastException if the hook returns something other than a {@code MethodHandle}
     * @throws Throwable anything else thrown by the hook function
     */
    protected ConstantCallSite(MethodType targetType, MethodHandle createTargetHook) throws Throwable {
        super(targetType, createTargetHook);
        isFrozen = true;
    }

    /**
     * Returns the target method of the call site, which behaves
     * like a {@code final} field of the {@code ConstantCallSite}.
     * That is, the target is always the original value passed
     * to the constructor call which created this instance.
     *
     * @return the immutable linkage state of this call site, a constant method handle
     * @throws IllegalStateException if the {@code ConstantCallSite} constructor has not completed
     */
    @Override public final MethodHandle getTarget() {
        if (!isFrozen)  throw new IllegalStateException();
        return target;
    }

    /**
     * Always throws an {@link UnsupportedOperationException}.
     * This kind of call site cannot change its target.
     * @param ignore a new target proposed for the call site, which is ignored
     * @throws UnsupportedOperationException because this kind of call site cannot change its target
     */
    @Override public final void setTarget(MethodHandle ignore) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns this call site's permanent target.
     * Since that target will never change, this is a correct implementation
     * of {@link CallSite#dynamicInvoker CallSite.dynamicInvoker}.
     * @return the immutable linkage state of this call site, a constant method handle
     * @throws IllegalStateException if the {@code ConstantCallSite} constructor has not completed
     */
    @Override
    public final MethodHandle dynamicInvoker() {
        return getTarget();
    }
}
