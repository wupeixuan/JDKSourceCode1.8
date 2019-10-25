/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

#include <stdio.h>
#include <string.h>
#include <jni.h>

#include "jli_util.h"

/*
 * Returns a pointer to a block of at least 'size' bytes of memory.
 * Prints error message and exits if the memory could not be allocated.
 */
void *
JLI_MemAlloc(size_t size)
{
    void *p = malloc(size);
    if (p == 0) {
        perror("malloc");
        exit(1);
    }
    return p;
}

/*
 * Equivalent to realloc(size).
 * Prints error message and exits if the memory could not be reallocated.
 */
void *
JLI_MemRealloc(void *ptr, size_t size)
{
    void *p = realloc(ptr, size);
    if (p == 0) {
        perror("realloc");
        exit(1);
    }
    return p;
}

/*
 * Wrapper over strdup(3C) which prints an error message and exits if memory
 * could not be allocated.
 */
char *
JLI_StringDup(const char *s1)
{
    char *s = strdup(s1);
    if (s == NULL) {
        perror("strdup");
        exit(1);
    }
    return s;
}

/*
 * Very equivalent to free(ptr).
 * Here to maintain pairing with the above routines.
 */
void
JLI_MemFree(void *ptr)
{
    free(ptr);
}

/*
 * debug helpers we use
 */
static jboolean _launcher_debug = JNI_FALSE;

void
JLI_TraceLauncher(const char* fmt, ...)
{
    va_list vl;
    if (_launcher_debug != JNI_TRUE) return;
    va_start(vl, fmt);
    vprintf(fmt,vl);
    va_end(vl);
}

void
JLI_SetTraceLauncher()
{
   if (getenv(JLDEBUG_ENV_ENTRY) != 0) {
        _launcher_debug = JNI_TRUE;
        JLI_TraceLauncher("----%s----\n", JLDEBUG_ENV_ENTRY);
   }
}

jboolean
JLI_IsTraceLauncher()
{
   return _launcher_debug;
}

int
JLI_StrCCmp(const char *s1, const char* s2)
{
   return JLI_StrNCmp(s1, s2, JLI_StrLen(s2));
}
