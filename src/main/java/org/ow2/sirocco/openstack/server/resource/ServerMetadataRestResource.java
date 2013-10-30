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

package org.ow2.sirocco.openstack.server.resource;

import org.ow2.sirocco.openstack.server.manager.IManager;
import org.ow2.sirocco.openstack.server.manager.OpenStackManager;
import org.ow2.sirocco.openstack.server.request.MessageContext;
import org.ow2.sirocco.openstack.server.utils.ConstantsPath;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 16/10/13
 */
@ResourceInterceptorBinding
@RequestScoped
@Path(ConstantsPath.SERVER_METADATA_PATH_V2)
public class ServerMetadataRestResource extends RestResourceAbstract {

    @Inject
    @OpenStackManager("ServerMetadataManager")
    private IManager machineMetadataManager;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response read(@PathParam("id") final String id) {

        MessageContext messageContext = null; // TODO create MessageContext
        machineMetadataManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @GET
    @Path("/{key}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response readKey(@PathParam("id") final String id) {

        MessageContext messageContext = null; // TODO create MessageContext
        machineMetadataManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder

        return null;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(@PathParam("id") final String id, final Object createObject) {
        // TODO add request object to domain

        MessageContext messageContext = null; // TODO create MessageContext
        machineMetadataManager.execute(messageContext, IManager.OperationEnum.CREATE);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") final String id, final Object updateObject) {
        // TODO add request object to domain


        MessageContext messageContext = null; // TODO create MessageContext
        machineMetadataManager.execute(messageContext, IManager.OperationEnum.UPDATE);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @PUT
    @Path("/{key}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") final String id, @PathParam("key") final String key, final Object updateObject) {
        // TODO add request object to domain


        MessageContext messageContext = null; // TODO create MessageContext
        machineMetadataManager.execute(messageContext, IManager.OperationEnum.UPDATE);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @DELETE
    @Path("/{key}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") final String id, @PathParam("key") final String key) {

        MessageContext messageContext = null; // TODO create MessageContext
        machineMetadataManager.execute(messageContext, IManager.OperationEnum.DELETE);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }
}
