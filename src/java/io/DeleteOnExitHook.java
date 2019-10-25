/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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
package java.io;

import java.util.*;
import java.io.File;

/**
 * This class holds a set of filenames to be deleted on VM exit through a shutdown hook.
 * A set is used both to prevent double-insertion of the same file as well as offer
 * quick removal.
 */

class DeleteOnExitHook {
    private static LinkedHashSet<String> files = new LinkedHashSet<>();
    static {
        // DeleteOnExitHook must be the last shutdown hook to be invoked.
        // Application shutdown hooks may add the first file to the
        // delete on exit list and cause the DeleteOnExitHook to be
        // registered during shutdown in progress. So set the
        // registerShutdownInProgress parameter to true.
        sun.misc.SharedSecrets.getJavaLangAccess()
            .registerShutdownHook(2 /* Shutdown hook invocation order */,
                true /* register even if shutdown in progress */,
                new Runnable() {
                    public void run() {
                       runHooks();
                    }
                }
        );
    }

    private DeleteOnExitHook() {}

    static synchronized void add(String file) {
        if(files == null) {
            // DeleteOnExitHook is running. Too late to add a file
            throw new IllegalStateException("Shutdown in progress");
        }

        files.add(file);
    }

    static void runHooks() {
        LinkedHashSet<String> theFiles;

        synchronized (DeleteOnExitHook.class) {
            theFiles = files;
            files = null;
        }

        ArrayList<String> toBeDeleted = new ArrayList<>(theFiles);

        // reverse the list to maintain previous jdk deletion order.
        // Last in first deleted.
        Collections.reverse(toBeDeleted);
        for (String filename : toBeDeleted) {
            (new File(filename)).delete();
        }
    }
}
