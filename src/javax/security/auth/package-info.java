/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * This package provides a framework for authentication and
 * authorization. The framework allows
 * authentication to be performed in pluggable fashion. Different
 * authentication modules can be plugged under an application without
 * requiring modifications to the application itself. The
 * authorization component allows specification of access controls
 * based on code location, code signers and code executors
 * (Subjects).
 *
 * @since JDK1.4
 */
package javax.security.auth;
