package org.ow2.sirocco.openstack.server.domain;

import org.ow2.sirocco.openstack.server.utils.DateHelper;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

public interface ObjectCommon  {

    /**
     * Get the identifier of resource.
     *
     * @return The identifier
     */
    String getId();

    /**
     * Set the identifier of resource.
     *
     * @param id The identifier
     */
    void setId(final String id);

    /**
     * Return the value of field "name".
     *
     * @return The value
     */
    String getName();

    /**
     * Set the value of field "name".
     *
     * @param name The value
     */
    void setName(final String name);

    /**
     * Return the value of field "created".
     *
     * @return The value
     */
    @XmlJavaTypeAdapter(DateHelper.class)
    Date getCreated();

    /**
     * Set the value of field "created".
     *
     * @param created The value
     */
    void setCreated(final Date created);

    /**
     * Return the value of field "updated".
     *
     * @return The value
     */
    @XmlJavaTypeAdapter(DateHelper.class)
    Date getUpdated();

    /**
     * Set the value of field "updated".
     *
     * @param updated The value
     */
    void setUpdated(final Date updated);

}