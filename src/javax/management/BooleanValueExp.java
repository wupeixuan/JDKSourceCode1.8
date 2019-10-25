/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.management;


/**
 * This class represents a boolean value. A BooleanValueExp may be
 * used anywhere a ValueExp is required.
 * @serial include
 *
 * @since 1.5
 */
class BooleanValueExp extends QueryEval implements ValueExp {

    /* Serial version */
    private static final long serialVersionUID = 7754922052666594581L;

    /**
     * @serial The boolean value
     */
    private boolean val = false;


    /** Creates a new BooleanValueExp representing the boolean literal {@code val}.*/
    BooleanValueExp(boolean val) {
        this.val = val;
    }

    /**Creates a new BooleanValueExp representing the Boolean object {@code val}.*/
    BooleanValueExp(Boolean val) {
        this.val = val.booleanValue();
    }


    /** Returns the  Boolean object representing the value of the BooleanValueExp object.*/
    public Boolean getValue()  {
        return Boolean.valueOf(val);
    }

    /**
     * Returns the string representing the object.
     */
    public String toString()  {
        return String.valueOf(val);
    }

    /**
     * Applies the ValueExp on a MBean.
     *
     * @param name The name of the MBean on which the ValueExp will be applied.
     *
     * @return  The <CODE>ValueExp</CODE>.
     *
     * @exception BadStringOperationException
     * @exception BadBinaryOpValueExpException
     * @exception BadAttributeValueExpException
     * @exception InvalidApplicationException
     */
    public ValueExp apply(ObjectName name) throws BadStringOperationException, BadBinaryOpValueExpException,
        BadAttributeValueExpException, InvalidApplicationException  {
        return this;
    }

    @Deprecated
    public void setMBeanServer(MBeanServer s) {
        super.setMBeanServer(s);
    }


 }
