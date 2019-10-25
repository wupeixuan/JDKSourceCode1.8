/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws;


/**
 * A WebServiceFeature is used to represent a feature that can be
 * enabled or disabled for a web service.
 * <p>
 * The JAX-WS specification will define some standard features and
 * JAX-WS implementors are free to define additional features if
 * necessary.  Vendor specific features may not be portable so
 * caution should be used when using them. Each Feature definition
 * MUST define a <code>public static final String ID</code>
 * that can be used in the Feature annotation to refer
 * to the feature. This ID MUST be unique across all features
 * of all vendors.  When defining a vendor specific feature ID,
 * use a vendor specific namespace in the ID string.
 *
 * @see javax.xml.ws.RespectBindingFeature
 * @see javax.xml.ws.soap.AddressingFeature
 * @see javax.xml.ws.soap.MTOMFeature
 *
 * @since 2.1
 */
public abstract class WebServiceFeature {
   /**
    * Each Feature definition MUST define a public static final
    * String ID that can be used in the Feature annotation to refer
    * to the feature.
    */
   // public static final String ID = "some unique feature Identifier";

   /**
    * Get the unique identifier for this WebServiceFeature.
    *
    * @return the unique identifier for this feature.
    */
   public abstract String getID();

   /**
    * Specifies if the feature is enabled or disabled
    */
   protected boolean enabled = false;


   protected WebServiceFeature(){}


   /**
    * Returns <code>true</code> if this feature is enabled.
    *
    * @return <code>true</code> if and only if the feature is enabled .
    */
   public boolean isEnabled() {
       return enabled;
   }
}
