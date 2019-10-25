/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package java.sql;

/**
 * An object that is used to identify a generic SQL type, called a JDBC type or
 * a vendor specific data type.
 *
 * @since 1.8
 */
public interface SQLType {

    /**
     * Returns the {@code SQLType} name that represents a SQL data type.
     *
     * @return The name of this {@code SQLType}.
     */
    String getName();

    /**
     * Returns the name of the vendor that supports this data type. The value
     * returned typically is the package name for this vendor.
     *
     * @return The name of the vendor for this data type
     */
    String getVendor();

    /**
     * Returns the vendor specific type number for the data type.
     *
     * @return An Integer representing the vendor specific data type
     */
    Integer getVendorTypeNumber();
}
