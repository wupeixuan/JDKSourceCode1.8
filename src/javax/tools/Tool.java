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

package javax.tools;

import java.util.Set;
import java.io.InputStream;
import java.io.OutputStream;
import javax.lang.model.SourceVersion;

/**
 * Common interface for tools that can be invoked from a program.
 * A tool is traditionally a command line program such as a compiler.
 * The set of tools available with a platform is defined by the
 * vendor.
 *
 * <p>Tools can be located using {@link
 * java.util.ServiceLoader#load(Class)}.
 *
 * @author Neal M Gafter
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface Tool {

    /**
     * Run the tool with the given I/O channels and arguments. By
     * convention a tool returns 0 for success and nonzero for errors.
     * Any diagnostics generated will be written to either {@code out}
     * or {@code err} in some unspecified format.
     *
     * @param in "standard" input; use System.in if null
     * @param out "standard" output; use System.out if null
     * @param err "standard" error; use System.err if null
     * @param arguments arguments to pass to the tool
     * @return 0 for success; nonzero otherwise
     * @throws NullPointerException if the array of arguments contains
     * any {@code null} elements.
     */
    int run(InputStream in, OutputStream out, OutputStream err, String... arguments);

    /**
     * Gets the source versions of the Java&trade; programming language
     * supported by this tool.
     * @return a set of supported source versions
     */
    Set<SourceVersion> getSourceVersions();

}
