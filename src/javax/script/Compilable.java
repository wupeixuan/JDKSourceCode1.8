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

package javax.script;

import java.util.Map;
import java.io.Reader;

/**
 * The optional interface implemented by ScriptEngines whose methods compile scripts
 * to a form that can be executed repeatedly without recompilation.
 *
 * @author Mike Grogan
 * @since 1.6
 */
public interface Compilable {
    /**
     * Compiles the script (source represented as a <code>String</code>) for
     * later execution.
     *
     * @param script The source of the script, represented as a <code>String</code>.
     *
     * @return An instance of a subclass of <code>CompiledScript</code> to be executed later using one
     * of the <code>eval</code> methods of <code>CompiledScript</code>.
     *
     * @throws ScriptException if compilation fails.
     * @throws NullPointerException if the argument is null.
     *
     */

    public CompiledScript compile(String script) throws
            ScriptException;

    /**
     * Compiles the script (source read from <code>Reader</code>) for
     * later execution.  Functionality is identical to
     * <code>compile(String)</code> other than the way in which the source is
     * passed.
     *
     * @param script The reader from which the script source is obtained.
     *
     * @return An instance of a subclass of <code>CompiledScript</code> to be executed
     * later using one of its <code>eval</code> methods of <code>CompiledScript</code>.
     *
     * @throws ScriptException if compilation fails.
     * @throws NullPointerException if argument is null.
     */
    public CompiledScript compile(Reader script) throws
            ScriptException;
}
