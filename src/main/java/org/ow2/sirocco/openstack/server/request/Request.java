/*
 * SIROCCO
 * Copyright (C) 2013 Orange Labs
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 */

package org.ow2.sirocco.openstack.server.request;

import java.io.Serializable;

public class Request implements Serializable {

    private String id;
    private Object serviceData;
    /**
     * IDs of the request
     */
    private IdRequest idRequest = new IdRequest();

    public void setId(String id) {
        this.id = id;
    }

    public Object getServiceData() {
        return serviceData;
    }

    public void setServiceData(Object serviceData) {
        this.serviceData = serviceData;
    }

    /**
     * Get all IDs.
     *
     * @return the idRequest
     */
    public IdRequest getIds() {
        return this.idRequest;
    }

    /**
     * Set all IDs.
     *
     * @param idRequest The idRequest to set
     */
    public void setIds(final IdRequest idRequest) {
        this.idRequest = idRequest;
    }

    /**
     * Get true if one of parent ID is passed on REST request.
     *
     * @return True if one of parent ID is passed on REST request.
     * @see IdRequest
     */
    public boolean hasParentIds() {
        boolean has = false;
        if (null != this.idRequest) {
            has = has || (null != this.idRequest.getId(IdRequest.Type.RESOURCE_PARENT));
            has = has || (null != this.idRequest.getId(IdRequest.Type.RESOURCE_GRAND_PARENT));
        }
        return has;
    }

    /**
     * Get a resource ID passed on REST request by type.
     *
     * @param type The type of the ID to get
     * @return The requested ID or null if none ID exist in the given type
     * @see IdRequest.Type
     */
    public String getId(final IdRequest.Type type) {
        String id = null;
        if (null != this.idRequest) {
            id = this.idRequest.getId(type);
        }
        return id;
    }

    /**
     * Get resource ID passed on REST request.
     *
     * @return The resource ID or null if none ID passed on
     */
    public String getId() {
        return this.getId(IdRequest.Type.RESOURCE);
    }

    /**
     * Get parent resource ID passed on REST request.
     *
     * @return The parent resource ID or null if none parent ID passed on
     */
    public String getIdParent() {
        return this.getId(IdRequest.Type.RESOURCE_PARENT);
    }
}
