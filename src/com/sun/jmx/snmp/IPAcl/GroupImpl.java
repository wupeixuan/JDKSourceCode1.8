/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.jmx.snmp.IPAcl;



import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;
import java.net.UnknownHostException;


import java.security.Principal;
import java.security.acl.Group;


/**
 * This class is used to represent a subnet mask (a group of hosts
 * matching the same
 * IP mask).
 *
 */

class GroupImpl extends PrincipalImpl implements Group, Serializable {
  private static final long serialVersionUID = -7777387035032541168L;

  /**
   * Constructs an empty group.
   * @exception UnknownHostException Not implemented
   */
  public GroupImpl () throws UnknownHostException {
  }

  /**
   * Constructs a group using the specified subnet mask.
   *
   * @param mask The subnet mask to use to build the group.
   * @exception UnknownHostException if the subnet mask cann't be built.
   */
  public GroupImpl (String mask) throws UnknownHostException {
        super(mask);
  }

    /**
     * Adds the specified member to the group.
     *
     * @param p the principal to add to this group.
     * @return true if the member was successfully added, false if the
     *     principal was already a member.
     */
    public boolean addMember(Principal p) {
        // we don't need to add members because the ip address is a
        // subnet mask
        return true;
    }

  public int hashCode() {
        return super.hashCode();
  }

  /**
   * Compares this group to the specified object. Returns true if the object
   * passed in matches the group represented.
   *
   * @param p the object to compare with.
   * @return true if the object passed in matches the subnet mask,
   *   false otherwise.
   */
  public boolean equals (Object p) {
        if (p instanceof PrincipalImpl || p instanceof GroupImpl){
          if ((super.hashCode() & p.hashCode()) == p.hashCode()) return true;
          else return false;
        } else {
          return false;
        }
  }

  /**
   * Returns true if the passed principal is a member of the group.
   *
   * @param p the principal whose membership is to be checked.
   * @return true if the principal is a member of this group, false otherwise.
   */
  public boolean isMember(Principal p) {
        if ((p.hashCode() & super.hashCode()) == p.hashCode()) return true;
        else return false;
  }

  /**
   * Returns an enumeration which contains the subnet mask.
   *
   * @return an enumeration which contains the subnet mask.
   */
  public Enumeration<? extends Principal> members(){
        Vector<Principal> v = new Vector<Principal>(1);
        v.addElement(this);
        return v.elements();
  }

  /**
   * Removes the specified member from the group. (Not implemented)
   *
   * @param p the principal to remove from this group.
   * @return allways return true.
   */
  public boolean removeMember(Principal p) {
        return true;
  }

  /**
   * Prints a string representation of this group.
   *
   * @return  a string representation of this group.
   */
  public String toString() {
        return ("GroupImpl :"+super.getAddress().toString());
  }
}
