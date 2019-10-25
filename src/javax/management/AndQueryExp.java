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
 * This class is used by the query building mechanism to represent conjunctions
 * of relational expressions.
 * @serial include
 *
 * @since 1.5
 */
class AndQueryExp extends QueryEval implements QueryExp {

    /* Serial version */
    private static final long serialVersionUID = -1081892073854801359L;

    /**
     * @serial The first QueryExp of the conjunction
     */
    private QueryExp exp1;

    /**
     * @serial The second QueryExp of the conjunction
     */
    private QueryExp exp2;


    /**
     * Default constructor.
     */
    public AndQueryExp() {
    }

    /**
     * Creates a new AndQueryExp with q1 and q2 QueryExp.
     */
    public AndQueryExp(QueryExp q1, QueryExp q2) {
        exp1 = q1;
        exp2 = q2;
    }


    /**
     * Returns the left query expression.
     */
    public QueryExp getLeftExp()  {
        return exp1;
    }

    /**
     * Returns the right query expression.
     */
    public QueryExp getRightExp()  {
        return exp2;
    }

    /**
     * Applies the AndQueryExp on a MBean.
     *
     * @param name The name of the MBean on which the AndQueryExp will be applied.
     *
     * @return  True if the query was successfully applied to the MBean, false otherwise.
     *
     *
     * @exception BadStringOperationException The string passed to the method is invalid.
     * @exception BadBinaryOpValueExpException The expression passed to the method is invalid.
     * @exception BadAttributeValueExpException The attribute value passed to the method is invalid.
     * @exception InvalidApplicationException  An attempt has been made to apply a subquery expression to a
     * managed object or a qualified attribute expression to a managed object of the wrong class.
     */
    public boolean apply(ObjectName name) throws BadStringOperationException, BadBinaryOpValueExpException,
        BadAttributeValueExpException, InvalidApplicationException  {
        return exp1.apply(name) && exp2.apply(name);
    }

   /**
    * Returns a string representation of this AndQueryExp
    */
    @Override
    public String toString() {
        return "(" + exp1 + ") and (" + exp2 + ")";
    }
}
