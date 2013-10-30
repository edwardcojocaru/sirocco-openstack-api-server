/**
 *
 * SIROCCO
 * Copyright (C) 2011 France Telecom
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * $Id$
 *
 */
package org.ow2.sirocco.openstack.server.domain;

import org.ow2.sirocco.openstack.server.utils.DateHelper;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

/**
 * Abstract class of a CIMI common object.
 */
@XmlTransient
public abstract class ObjectCommonAbstract implements ObjectCommon {

    /**
     * Serial number
     */
    private static final long serialVersionUID = 1L;


    /**
     * Field "created".
     * <p>
     * The timestamp when this entity was created. The format is DateTimeUTC
     * (ISO 8601), example : 2012-02-06T08:39:57Z.
     * </p>
     */
    private Date created;

    /**
     * Field "updated".
     * <p>
     * The time at which the last explicit attribute update was made on the
     * resoure. Note, while operations such as 'stop' do implicitly modify the
     * 'state' attribute it does not change the 'updated_time'. The format is
     * DateTimeUTC (ISO 8601), example : 2012-02-06T08:39:57Z.
     * </p>
     */
    private Date updated;

    @Override
    @XmlJavaTypeAdapter(DateHelper.class)
    public Date getCreated() {
        return this.created;
    }

    @Override
    public void setCreated(final Date created) {
        this.created = created;
    }

    @Override
    @XmlJavaTypeAdapter(DateHelper.class)
    public Date getUpdated() {
        return this.updated;
    }

    @Override
    public void setUpdated(final Date updated) {
        this.updated = updated;
    }
}
