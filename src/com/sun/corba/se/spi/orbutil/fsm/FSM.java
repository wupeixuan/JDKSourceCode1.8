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

/**
 * An FSM is used to represent an instance of a finite state machine
 * which has a transition function represented by an instance of
 * StateEngine.  An instance of an FSM may be created either by calling
 * StateEngine.makeFSM( startState ) on a state engine, or by extending FSMImpl and
 * using a constructor.  Using FSMImpl as a base class is convenient if
 * additional state is associated with the FSM beyond that encoded
 * by the current state.  This is especially convenient if an action
 * needs some additional information.  For example, counters are best
 * handled by special actions rather than encoding a bounded counter
 * in a state machine.  It is also possible to create a class that
 * implements the FSM interface by delegating to an FSM instance
 * created by StateEngine.makeFSM.
 *
 * @author Ken Cavanaugh
 */
public interface FSM
{
    /** Get the current state of this FSM.
    */
    public State getState() ;

    /** Perform the action and transition to the next state based
    * on the current state of the FSM and the input.
    */
    public void doIt( Input in ) ;
}

// end of FSM.java
