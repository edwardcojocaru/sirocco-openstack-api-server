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

package org.ow2.sirocco.openstack.server.manager;

import org.ow2.sirocco.cloudmanager.core.api.IMachineImageManager;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineImage;
import org.ow2.sirocco.openstack.server.converter.ImageConverter;
import org.ow2.sirocco.openstack.server.domain.Image;
import org.ow2.sirocco.openstack.server.request.MessageContext;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 21/10/13
 */

@OpenStackManager("ImageManager")
public class ImageManager extends AbstractManager {

    @Inject
    private IMachineImageManager manager;

    @Override
    protected Object convertToDataService(MessageContext context) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void convertToResponse(MessageContext context, Object dataService) throws Exception {
        Object responseData;
        ImageConverter converter = new ImageConverter();
        if (dataService instanceof Vector) {
            responseData = converter.toOpenstackCollection(dataService);
        } else {
            responseData = converter.toOpenstackObject(dataService);
        }
        context.getResponse().setResponseData(responseData);
        context.getResponse().setStatus(Response.Status.OK);
    }

    @Override
    protected Object read(MessageContext context, Object dataService) throws Exception {
        Object out = null;
        final String requestId = context.getRequest().getId();
        if (requestId != null) {
            out = this.manager.getMachineImageById(requestId);
        } else if (!context.hasParamsForReadingCollection()) {
            out = this.manager.getMachineImages();
        } else {
            // TODO must be checked if the EJB layer should be improved
        }
        return out;
    }

    @Override
    protected Object create(MessageContext context, Object dataService) throws Exception {
        return this.manager.createMachineImage((MachineImage) dataService);
    }

    @Override
    protected Object update(MessageContext context, Object dataService) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Object delete(MessageContext context, Object dataService) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
