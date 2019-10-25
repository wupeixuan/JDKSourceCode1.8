/*
 * Copyright (c) 1998, 2006, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javadoc;

/**
 * Represents the root of the program structure information
 * for one run of javadoc.  From this root all other program
 * structure information can be extracted.
 * Also represents the command line information -- the
 * packages, classes and options specified by the user.
 *
 * @since 1.2
 * @author Robert Field
 */
public interface RootDoc extends Doc, DocErrorReporter {

    /**
     * Command line options.
     * <p>
     * For example, given:
     * <pre>
     *     javadoc -foo this that -bar other ...</pre>
     *
     * this method will return:
     * <pre>
     *      options()[0][0] = "-foo"
     *      options()[0][1] = "this"
     *      options()[0][2] = "that"
     *      options()[1][0] = "-bar"
     *      options()[1][1] = "other"</pre>
     *
     * @return an array of arrays of String.
     */
    String[][] options();

    /**
     * Return the packages
     * <a href="package-summary.html#included">specified</a>
     * on the command line.
     * If <code>-subpackages</code> and <code>-exclude</code> options
     * are used, return all the non-excluded packages.
     *
     * @return packages specified on the command line.
     */
    PackageDoc[] specifiedPackages();

    /**
     * Return the classes and interfaces
     * <a href="package-summary.html#included">specified</a>
     * as source file names on the command line.
     *
     * @return classes and interfaces specified on the command line.
     */
    ClassDoc[] specifiedClasses();

    /**
     * Return the
     * <a href="package-summary.html#included">included</a>
      classes and interfaces in all packages.
     *
     * @return included classes and interfaces in all packages.
     */
    ClassDoc[] classes();

    /**
     * Return a PackageDoc for the specified package name.
     *
     * @param name package name
     *
     * @return a PackageDoc holding the specified package, null if
     * this package is not referenced.
     */
    PackageDoc packageNamed(String name);

    /**
     * Return a ClassDoc for the specified class or interface name.
     *
     * @param qualifiedName
     * <a href="package-summary.html#qualified">qualified</a>
     * class or package name
     *
     * @return a ClassDoc holding the specified class, null if
     * this class is not referenced.
     */
    ClassDoc classNamed(String qualifiedName);
}
