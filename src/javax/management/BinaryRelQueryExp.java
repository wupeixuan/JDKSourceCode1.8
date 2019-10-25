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
 * This class is used by the query-building mechanism to represent binary
 * operations.
 * @serial include
 *
 * @since 1.5
 */
class BinaryRelQueryExp extends QueryEval implements QueryExp {

    /* Serial version */
    private static final long serialVersionUID = -5690656271650491000L;

    /**
     * @serial The operator
     */
    private int relOp;

    /**
     * @serial The first value
     */
    private ValueExp exp1;

    /**
     * @serial The second value
     */
    private ValueExp exp2;


    /**
     * Basic Constructor.
     */
    public BinaryRelQueryExp() {
    }

    /**
     * Creates a new BinaryRelQueryExp with operator op applied on v1 and
     * v2 values.
     */
    public BinaryRelQueryExp(int op, ValueExp v1, ValueExp v2) {
        relOp = op;
        exp1  = v1;
        exp2  = v2;
    }


    /**
     * Returns the operator of the query.
     */
    public int getOperator()  {
        return relOp;
    }

    /**
     * Returns the left value of the query.
     */
    public ValueExp getLeftValue()  {
        return exp1;
    }

    /**
     * Returns the right value of the query.
     */
    public ValueExp getRightValue()  {
        return exp2;
    }

    /**
     * Applies the BinaryRelQueryExp on an MBean.
     *
     * @param name The name of the MBean on which the BinaryRelQueryExp will be applied.
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
        Object val1 = exp1.apply(name);
        Object val2 = exp2.apply(name);
        boolean numeric = val1 instanceof NumericValueExp;
        boolean bool = val1 instanceof BooleanValueExp;
        if (numeric) {
            if (((NumericValueExp)val1).isLong()) {
                long lval1 = ((NumericValueExp)val1).longValue();
                long lval2 = ((NumericValueExp)val2).longValue();

                switch (relOp) {
                case Query.GT:
                    return lval1 > lval2;
                case Query.LT:
                    return lval1 < lval2;
                case Query.GE:
                    return lval1 >= lval2;
                case Query.LE:
                    return lval1 <= lval2;
                case Query.EQ:
                    return lval1 == lval2;
                }
            } else {
                double dval1 = ((NumericValueExp)val1).doubleValue();
                double dval2 = ((NumericValueExp)val2).doubleValue();

                switch (relOp) {
                case Query.GT:
                    return dval1 > dval2;
                case Query.LT:
                    return dval1 < dval2;
                case Query.GE:
                    return dval1 >= dval2;
                case Query.LE:
                    return dval1 <= dval2;
                case Query.EQ:
                    return dval1 == dval2;
                }
            }

        } else if (bool) {

            boolean bval1 = ((BooleanValueExp)val1).getValue().booleanValue();
            boolean bval2 = ((BooleanValueExp)val2).getValue().booleanValue();

            switch (relOp) {
            case Query.GT:
                return bval1 && !bval2;
            case Query.LT:
                return !bval1 && bval2;
            case Query.GE:
                return bval1 || !bval2;
            case Query.LE:
                return !bval1 || bval2;
            case Query.EQ:
                return bval1 == bval2;
            }

        } else {
            String sval1 = ((StringValueExp)val1).getValue();
            String sval2 = ((StringValueExp)val2).getValue();

            switch (relOp) {
            case Query.GT:
                return sval1.compareTo(sval2) > 0;
            case Query.LT:
                return sval1.compareTo(sval2) < 0;
            case Query.GE:
                return sval1.compareTo(sval2) >= 0;
            case Query.LE:
                return sval1.compareTo(sval2) <= 0;
            case Query.EQ:
                return sval1.compareTo(sval2) == 0;
            }
        }

        return false;
    }

    /**
     * Returns the string representing the object.
     */
    @Override
    public String toString()  {
        return "(" + exp1 + ") " + relOpString() + " (" + exp2 + ")";
    }

    private String relOpString() {
        switch (relOp) {
        case Query.GT:
            return ">";
        case Query.LT:
            return "<";
        case Query.GE:
            return ">=";
        case Query.LE:
            return "<=";
        case Query.EQ:
            return "=";
        }

        return "=";
    }

 }
