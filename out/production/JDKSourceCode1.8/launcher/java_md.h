/*
 * Copyright (c) 1998, 2005, Oracle and/or its affiliates. All rights reserved.
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

#ifndef JAVA_MD_H
#define JAVA_MD_H

#include <jni.h>
#include <windows.h>
#include <io.h>
#include "manifest_info.h"
#include "jli_util.h"

#define PATH_SEPARATOR  ';'
#define FILESEP         "\\"
#define FILE_SEPARATOR  '\\'
#define IS_FILE_SEPARATOR(c) ((c) == '\\' || (c) == '/')
#define MAXPATHLEN      MAX_PATH
#define MAXNAMELEN      MAX_PATH


/*
 * Support for doing cheap, accurate interval timing.
 */
extern jlong CounterGet(void);
extern jlong Counter2Micros(jlong counts);


/*
 * Function prototypes.
 */
char *LocateJRE(manifest_info *info);
void ExecJRE(char *jre, char **argv);
int UnsetEnv(char *name);

#endif /* JAVA_MD_H */
