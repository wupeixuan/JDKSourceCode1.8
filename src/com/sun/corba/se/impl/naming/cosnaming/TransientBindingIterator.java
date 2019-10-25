/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.naming.cosnaming;

// Import general CORBA classes
import org.omg.CORBA.SystemException;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;

// Get org.omg.CosNaming Types
import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingType;
import org.omg.CosNaming.BindingTypeHolder;
import org.omg.CosNaming.NameComponent;

// Get base implementation
import com.sun.corba.se.impl.naming.cosnaming.NamingContextImpl;
import com.sun.corba.se.impl.naming.cosnaming.InternalBindingValue;

// Get a hash table
import java.util.Hashtable;
import java.util.Enumeration;

/**
 * Class TransientBindingIterator implements the abstract methods
 * defined by BindingIteratorImpl, to use with the TransientNamingContext
 * implementation of the NamingContextImpl. The TransientBindingIterator
 * implementation receives a hash table of InternalBindingValues, and uses
 * an Enumeration to iterate over the contents of the hash table.
 * @see BindingIteratorImpl
 * @see TransientNamingContext
 */
public class TransientBindingIterator extends BindingIteratorImpl
{
    // There is only one POA used for both TransientNamingContext and
    // TransientBindingIteraor servants.
    private POA nsPOA;
    /**
     * Constructs a new TransientBindingIterator object.
     * @param orb a org.omg.CORBA.ORB object.
     * @param aTable A hashtable containing InternalBindingValues which is
     * the content of the TransientNamingContext.
     * @param java.lang.Exception a Java exception.
     * @exception Exception a Java exception thrown of the base class cannot
     * initialize.
   */
    public TransientBindingIterator(ORB orb, Hashtable aTable,
        POA thePOA )
        throws java.lang.Exception
    {
        super(orb);
        theHashtable = aTable;
        theEnumeration = this.theHashtable.elements();
        currentSize = this.theHashtable.size();
        this.nsPOA = thePOA;
    }

    /**
   * Returns the next binding in the NamingContext. Uses the enumeration
   * object to determine if there are more bindings and if so, returns
   * the next binding from the InternalBindingValue.
   * @param b The Binding as an out parameter.
   * @return true if there were more bindings.
   */
    final public boolean NextOne(org.omg.CosNaming.BindingHolder b)
    {
        // If there are more elements get the next element
        boolean hasMore = theEnumeration.hasMoreElements();
        if (hasMore) {
            b.value =
                ((InternalBindingValue)theEnumeration.nextElement()).theBinding;
            currentSize--;
        } else {
            // Return empty but marshalable binding
            b.value = new Binding(new NameComponent[0],BindingType.nobject);
        }
        return hasMore;
    }

    /**
     * Destroys this BindingIterator by disconnecting from the ORB
     * @exception org.omg.CORBA.SystemException One of a fixed set of CORBA
     * system exceptions.
     */
    final public void Destroy()
    {
        // Remove the object from the Active Object Map.
        try {
            byte[] objectId = nsPOA.servant_to_id( this );
            if( objectId != null ) {
                nsPOA.deactivate_object( objectId );
            }
        }
        catch( Exception e ) {
            NamingUtils.errprint("BindingIterator.Destroy():caught exception:");
            NamingUtils.printException(e);
        }
    }

    /**
     * Returns the remaining number of elements in the iterator.
     * @return the remaining number of elements in the iterator.
     */
    public final int RemainingElements() {
        return currentSize;
    }

    private int currentSize;
    private Hashtable theHashtable;
    private Enumeration theEnumeration;
}
