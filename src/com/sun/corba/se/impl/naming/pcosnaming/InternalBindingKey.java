/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.naming.pcosnaming;

import java.io.Serializable;
import org.omg.CosNaming.NameComponent;


/**
 * Class InternalBindingKey implements the necessary wrapper code
 * around the org.omg.CosNaming::NameComponent class to implement the proper
 * equals() method and the hashCode() method for use in a hash table.
 * It computes the hashCode once and stores it, and also precomputes
 * the lengths of the id and kind strings for faster comparison.
 */
public class InternalBindingKey
        implements Serializable
{

    // computed by serialver tool
    private static final long serialVersionUID = -5410796631793704055L;

    public String id;
    public String kind;

    // Default Constructor
    public InternalBindingKey() {}

    // Normal constructor
    public InternalBindingKey(NameComponent n)
    {
        setup(n);
    }

    // Setup the object
    protected void setup(NameComponent n) {
        this.id = n.id;
        this.kind = n.kind;
    }

    // Compare the keys by comparing name's id and kind
    public boolean equals(java.lang.Object o) {
        if (o == null)
            return false;
        if (o instanceof InternalBindingKey) {
            InternalBindingKey that = (InternalBindingKey)o;
            if( this.id != null && that.id != null )
            {
                if (this.id.length() != that.id.length() )
                {
                        return false;
                }
                // If id is set is must be equal
                if (this.id.length() > 0 && this.id.equals(that.id) == false)
                {
                        return false;
                }
            }
            else
            {
                // If One is Null and the other is not then it's a mismatch
                // So, return false
                if( ( this.id == null && that.id != null )
                ||  ( this.id !=null && that.id == null ) )
                {
                        return false;
                }
            }
            if( this.kind != null && that.kind != null )
            {
                if (this.kind.length() != that.kind.length() )
                {
                        return false;
                }
                // If kind is set it must be equal
                if (this.kind.length() > 0 && this.kind.equals(that.kind) == false)
                {
                        return false;
                }
            }
            else
            {
                // If One is Null and the other is not then it's a mismatch
                // So, return false
                if( ( this.kind == null && that.kind != null )
                ||  ( this.kind !=null && that.kind == null ) )
                {
                        return false;
                }
            }
            // We have checked all the possibilities, so return true
            return true;
        } else {
            return false;
        }
    }


    // Return precomputed value
    public int hashCode() {
        int hashVal = 0;
        if (this.id.length() > 0)
        {
            hashVal += this.id.hashCode();
        }
        if (this.kind.length() > 0)
        {
            hashVal += this.kind.hashCode();
        }
        return hashVal;
    }
}
