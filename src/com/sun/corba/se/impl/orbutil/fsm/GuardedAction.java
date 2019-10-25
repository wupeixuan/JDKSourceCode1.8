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

package com.sun.corba.se.impl.orbutil.fsm ;

import com.sun.corba.se.spi.orbutil.fsm.Guard ;
import com.sun.corba.se.spi.orbutil.fsm.GuardBase ;
import com.sun.corba.se.spi.orbutil.fsm.Input ;
import com.sun.corba.se.spi.orbutil.fsm.Action ;
import com.sun.corba.se.spi.orbutil.fsm.State ;
import com.sun.corba.se.spi.orbutil.fsm.FSM ;

public class GuardedAction {
    private static Guard trueGuard = new GuardBase( "true" ) {
        public Guard.Result evaluate( FSM fsm, Input in )
        {
            return Guard.Result.ENABLED ;
        }
    } ;

    private Guard guard ;
    private Action action ;
    private State nextState ;

    public GuardedAction( Action action, State nextState )
    {
        this.guard = trueGuard ;
        this.action = action ;
        this.nextState = nextState ;
    }

    public GuardedAction( Guard guard, Action action, State nextState )
    {
        this.guard = guard ;
        this.action = action ;
        this.nextState = nextState ;
    }

    public String toString()
    {
        return "GuardedAction[action=" + action + " guard=" + guard +
            " nextState=" + nextState + "]" ;
    }

    public Action getAction() { return action ; }
    public Guard getGuard() { return guard ; }
    public State getNextState() { return nextState ; }
}
