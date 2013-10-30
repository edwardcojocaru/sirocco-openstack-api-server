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
import org.ow2.sirocco.openstack.server.request.IdRequest;
import org.ow2.sirocco.openstack.server.request.MessageContext;
import org.ow2.sirocco.openstack.server.request.MessageContextHelper;
import org.ow2.sirocco.openstack.server.request.ResponseHelper;
import org.ow2.sirocco.openstack.server.utils.ConstantsPath;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 21/10/13
 */

@ResourceInterceptorBinding
@RequestScoped
@Path(ConstantsPath.IMAGES_PATH_V2)
public class ImageRestResource extends RestResourceAbstract {

    @Inject
    @OpenStackManager("ImageManager")
    private IManager imageManager;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response read() {

        MessageContext messageContext = MessageContextHelper.buildContext(this.getJaxRsRequestInfos());
        imageManager.execute(messageContext, IManager.OperationEnum.READ);
        return ResponseHelper.buildResponse(messageContext.getResponse());
    }

    @GET
    @Path("/detail")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response readDetails() {

        MessageContext messageContext = null; // TODO create MessageContext
        imageManager.execute(messageContext, IManager.OperationEnum.READ);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder

        return null;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response read(@PathParam("id") final String id) {

        IdRequest idsRequest = new IdRequest(id);
        MessageContext messageContext = MessageContextHelper.buildContext(this.getJaxRsRequestInfos(), idsRequest);
        imageManager.execute(messageContext, IManager.OperationEnum.READ);
        return ResponseHelper.buildResponse(messageContext.getResponse());
    }

    @DELETE
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") final String id) {

        MessageContext messageContext = null; // TODO create MessageContext
        imageManager.execute(messageContext, IManager.OperationEnum.DELETE);
        //ResponseHelper.buildResponse(context.getResponse());
        // TODO create response builder
        return null;
    }
}
