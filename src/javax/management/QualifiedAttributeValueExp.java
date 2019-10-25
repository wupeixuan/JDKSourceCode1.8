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
 * <p>Represents attributes used as arguments to relational constraints,
 * where the attribute must be in an MBean of a specified {@linkplain
 * MBeanInfo#getClassName() class}. A QualifiedAttributeValueExp may be used
 * anywhere a ValueExp is required.
 *
 * @serial include
 *
 * @since 1.5
 */
class QualifiedAttributeValueExp extends AttributeValueExp   {


    /* Serial version */
    private static final long serialVersionUID = 8832517277410933254L;

    /**
     * @serial The attribute class name
     */
    private String className;


    /**
     * Basic Constructor.
     * @deprecated see {@link AttributeValueExp#AttributeValueExp()}
     */
    @Deprecated
    public QualifiedAttributeValueExp() {
    }

    /**
     * Creates a new QualifiedAttributeValueExp representing the specified object
     * attribute, named attr with class name className.
     */
    public QualifiedAttributeValueExp(String className, String attr) {
        super(attr);
        this.className = className;
    }


    /**
     * Returns a string representation of the class name of the attribute.
     */
    public String getAttrClassName()  {
        return className;
    }

    /**
     * Applies the QualifiedAttributeValueExp to an MBean.
     *
     * @param name The name of the MBean on which the QualifiedAttributeValueExp will be applied.
     *
     * @return  The ValueExp.
     *
     * @exception BadStringOperationException
     * @exception BadBinaryOpValueExpException
     * @exception BadAttributeValueExpException
     * @exception InvalidApplicationException
     */
    @Override
    public ValueExp apply(ObjectName name) throws BadStringOperationException, BadBinaryOpValueExpException,
        BadAttributeValueExpException, InvalidApplicationException  {
        try {
            MBeanServer server = QueryEval.getMBeanServer();
            String v = server.getObjectInstance(name).getClassName();

            if (v.equals(className)) {
                return super.apply(name);
            }
            throw new InvalidApplicationException("Class name is " + v +
                                                  ", should be " + className);

        } catch (Exception e) {
            throw new InvalidApplicationException("Qualified attribute: " + e);
            /* Can happen if MBean disappears between the time we
               construct the list of MBeans to query and the time we
               evaluate the query on this MBean, or if
               getObjectInstance throws SecurityException.  */
        }
    }

    /**
     * Returns the string representing its value
     */
    @Override
    public String toString()  {
        if (className != null) {
            return className + "." + super.toString();
        } else {
            return super.toString();
        }
    }

}
