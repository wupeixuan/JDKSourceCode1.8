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


int     DoSplashLoadMemory(void* pdata, int size); /* requires preloading the file */
int     DoSplashLoadFile(const char* filename);
void    DoSplashInit(void);
void    DoSplashClose(void);
void    DoSplashSetFileJarName(const char* fileName, const char* jarName);
void    DoSplashSetScaleFactor(float scaleFactor);
char*   DoSplashGetScaledImageName(const char* jarName, const char* fileName,
                                    float* scaleFactor);
