/*
 * Copyright (c) 1999, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * This class is used by the query-building mechanism to represent negations
 * of relational expressions.
 * @serial include
 *
 * @since 1.5
 */
class NotQueryExp extends QueryEval implements QueryExp {


    /* Serial version */
    private static final long serialVersionUID = 5269643775896723397L;

    /**
     * @serial The negated {@link QueryExp}
     */
    private QueryExp exp;


    /**
     * Basic Constructor.
     */
    public NotQueryExp() {
    }

    /**
     * Creates a new NotQueryExp for negating the specified QueryExp.
     */
    public NotQueryExp(QueryExp q) {
        exp = q;
    }


    /**
     * Returns the negated query expression of the query.
     */
    public QueryExp getNegatedExp()  {
        return exp;
    }

    /**
     * Applies the NotQueryExp on a MBean.
     *
     * @param name The name of the MBean on which the NotQueryExp will be applied.
     *
     * @return  True if the query was successfully applied to the MBean, false otherwise.
     *
     * @exception BadStringOperationException
     * @exception BadBinaryOpValueExpException
     * @exception BadAttributeValueExpException
     * @exception InvalidApplicationException
     */
    public boolean apply(ObjectName name) throws BadStringOperationException, BadBinaryOpValueExpException,
        BadAttributeValueExpException, InvalidApplicationException  {
        return exp.apply(name) == false;
    }

    /**
     * Returns the string representing the object.
     */
    @Override
    public String toString()  {
        return "not (" + exp + ")";
    }
 }
