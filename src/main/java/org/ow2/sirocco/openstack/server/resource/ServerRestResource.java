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
import java.util.Date;

/**
 * User: Eduard.Cojocaru
 * Date: 10/10/13
 */

@RequestScoped
@Path(ConstantsPath.SERVERS_PATH_V2)
public class ServerRestResource extends RestResourceAbstract {

    @Inject
    @OpenStackManager("ServerManager")
    private IManager machineManager;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response read(@QueryParam("image") final String imageRef,
                         @QueryParam("flavor") final String flavorRef,
                         @QueryParam("name") final String serverName,
                         @QueryParam("status") final String serverStatus,
                         @QueryParam("marker") final String markerId,
                         @QueryParam("limit") final int limit,
                         @QueryParam("changes-since") final Date from) {

        MessageContext messageContext = null; // TODO create MessageContext
        machineManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(final Object createObject) {
        // TODO add request object to domain

        MessageContext messageContext = null; // TODO create MessageContext
        machineManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @GET
    @Path("/detail")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response readDetails() {

        MessageContext messageContext = null; // TODO create MessageContext
        machineManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder

        return null;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response read(@PathParam("id") final String id) {

        MessageContext messageContext = null; // TODO create MessageContext
        machineManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") final String id, final Object updateObject) {
        // TODO add request object to domain


        MessageContext messageContext = null; // TODO create MessageContext
        machineManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") final String id) {

        MessageContext messageContext = null; // TODO create MessageContext
        machineManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }
}
