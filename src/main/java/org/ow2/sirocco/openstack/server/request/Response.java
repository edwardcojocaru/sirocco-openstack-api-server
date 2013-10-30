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

import javax.ws.rs.core.Response.Status;
import java.io.Serializable;

public class Response implements Serializable {
    private int status;
    private String errorMessage;
    private boolean committed;
    public Object responseData;

    /**
     * Get the status code.
     *
     * @return The status code
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Set the status code and commit the response.
     *
     * @param status The status code
     */
    public void setStatus(final int status) {
        this.status = status;
        this.committed = true;
    }

    /**
     * Set the status code and commit the response.
     *
     * @param status The status code
     */
    public void setStatus(final Status status) {
        this.setStatus(status.getStatusCode());
    }

    /**
     * Returns a boolean indicating if the response has been committed.
     * <p>
     * A committed response has already had its status code.
     * </p>
     *
     * @return the committed
     */
    public boolean isCommitted() {
        return this.committed;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }
}
