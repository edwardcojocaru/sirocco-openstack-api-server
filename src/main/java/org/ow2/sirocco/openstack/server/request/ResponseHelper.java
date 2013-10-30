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
package org.ow2.sirocco.openstack.server.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * Utility to build REST response with the data of Openstack response.
 *
 * @see Response
 */
public class ResponseHelper {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseHelper.class);

    /**
     * Build REST response with a Openstack response.
     *
     * @param serviceResponse The Openstack response
     * @return The REST response
     */
    public static Response buildResponse(final org.ow2.sirocco.openstack.server.request.Response serviceResponse) {
        ResponseBuilder builder;
        int status = serviceResponse.getStatus();

        // Make builder with status
        if (0 == status) {
            builder = Response.serverError();
            ResponseHelper.LOGGER.error("Openstack Response Status is null");
        } else {
            builder = Response.status(serviceResponse.getStatus());
        }
        // Add entity (body)
        if (null != serviceResponse.getResponseData()) {
            builder.entity(serviceResponse.getResponseData());
        }
        // Add message error (body)
        if (null != serviceResponse.getErrorMessage()) {
            builder.entity(serviceResponse.getErrorMessage());
        }
        Response response = builder.build();
        return response;
    }
}
