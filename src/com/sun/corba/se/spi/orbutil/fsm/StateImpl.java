/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.orbutil.fsm ;

import com.sun.corba.se.impl.orbutil.fsm.NameBase ;

import java.util.Map ;
import java.util.HashMap ;
import java.util.Set ;
import java.util.HashSet ;

import com.sun.corba.se.impl.orbutil.fsm.GuardedAction ;
import com.sun.corba.se.impl.orbutil.fsm.NameBase ;

/** Base class for all states in a StateEngine.  This must be used
* as the base class for all states in transitions added to a StateEngine.
*/
public class StateImpl extends NameBase implements State {
    private Action defaultAction ;
    private State defaultNextState ;
    private Map inputToGuardedActions ;

    public StateImpl( String name )
    {
        super( name ) ;
        defaultAction = null ;
        inputToGuardedActions = new HashMap() ;
    }

    public void preAction( FSM fsm )
    {
    }

    public void postAction( FSM fsm )
    {
    }

    // Methods for use only by StateEngineImpl.

    public State getDefaultNextState()
    {
        return defaultNextState ;
    }

    public void setDefaultNextState( State defaultNextState )
    {
        this.defaultNextState = defaultNextState ;
    }

    public Action getDefaultAction()
    {
        return defaultAction ;
    }

    public void setDefaultAction( Action defaultAction )
    {
        this.defaultAction = defaultAction ;
    }

    public void addGuardedAction( Input in, GuardedAction ga )
    {
        Set gas = (Set)inputToGuardedActions.get( in ) ;
        if (gas == null) {
            gas = new HashSet() ;
            inputToGuardedActions.put( in, gas ) ;
        }

        gas.add( ga ) ;
    }

    public Set getGuardedActions( Input in )
    {
        return (Set)inputToGuardedActions.get( in ) ;
    }
}
