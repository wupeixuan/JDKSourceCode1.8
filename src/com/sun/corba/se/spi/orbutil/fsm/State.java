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
 * This interface must be implemented by any class that is used as
 * a state in a FSM.  The FSM only needs the identity of this
 * object, so all that is really needs is the default equals implementation.
 * The toString() method should also be overridden to give a concise
 * description or name of the state.  The StateImpl class handles this.
 * <P>
 * Pre- and post- actions are taken only on completed transitions between
 * different states.  Assume that the FSM is in state A, and the FSM will
 * transition to state B under input I with action X.  If A != B and X completes
 * successfully, then after X completes execution, A.postAction is executed,
 * followed by B.preAction.
 *
 * @author Ken Cavanaugh
 */
public interface State
{
    /** Method that defines action that occurs whenever this state is entered.
    * Any exceptions thrown by this method are ignored.
    */
    void preAction( FSM fsm ) ;

    /** Method that defines action that occurs whenever this state is exited.
    * Any exceptions thrown by this method are ignored.
    */
    void postAction( FSM fsm ) ;
}

// end of State.java
