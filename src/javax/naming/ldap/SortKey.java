/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.ldap;

/**
 * A sort key and its associated sort parameters.
 * This class implements a sort key which is used by the LDAPv3
 * Control for server-side sorting of search results as defined in
 * <a href="http://www.ietf.org/rfc/rfc2891.txt">RFC 2891</a>.
 *
 * @since 1.5
 * @see SortControl
 * @author Vincent Ryan
 */
public class SortKey {

    /*
     * The ID of the attribute to sort by.
     */
    private String attrID;

    /*
     * The sort order. Ascending order, by default.
     */
    private boolean reverseOrder = false;

    /*
     * The ID of the matching rule to use for ordering attribute values.
     */
    private String matchingRuleID = null;

    /**
     * Creates the default sort key for an attribute. Entries will be sorted
     * according to the specified attribute in ascending order using the
     * ordering matching rule defined for use with that attribute.
     *
     * @param   attrID  The non-null ID of the attribute to be used as a sort
     *          key.
     */
    public SortKey(String attrID) {
        this.attrID = attrID;
    }

    /**
     * Creates a sort key for an attribute. Entries will be sorted according to
     * the specified attribute in the specified sort order and using the
     * specified matching rule, if supplied.
     *
     * @param   attrID          The non-null ID of the attribute to be used as
     *                          a sort key.
     * @param   ascendingOrder  If true then entries are arranged in ascending
     *                          order. Otherwise there are arranged in
     *                          descending order.
     * @param   matchingRuleID  The possibly null ID of the matching rule to
     *                          use to order the attribute values. If not
     *                          specified then the ordering matching rule
     *                          defined for the sort key attribute is used.
     */
    public SortKey(String attrID, boolean ascendingOrder,
                    String matchingRuleID) {

        this.attrID = attrID;
        reverseOrder = (! ascendingOrder);
        this.matchingRuleID = matchingRuleID;
    }

    /**
     * Retrieves the attribute ID of the sort key.
     *
     * @return    The non-null Attribute ID of the sort key.
     */
    public String getAttributeID() {
        return attrID;
    }

    /**
     * Determines the sort order.
     *
     * @return    true if the sort order is ascending, false if descending.
     */
    public boolean isAscending() {
        return (! reverseOrder);
    }

    /**
     * Retrieves the matching rule ID used to order the attribute values.
     *
     * @return    The possibly null matching rule ID. If null then the
     *            ordering matching rule defined for the sort key attribute
     *            is used.
     */
    public String getMatchingRuleID() {
        return matchingRuleID;
    }
}
