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
package org.ow2.sirocco.openstack.server.converter;

import org.ow2.sirocco.cloudmanager.model.cimi.MachineImage;
import org.ow2.sirocco.openstack.server.domain.Image;
import org.ow2.sirocco.openstack.server.request.MessageContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Convert the data of the Openstack model and the service model in both directions.
 * <p>
 * Converted classes:
 * <ul>
 * <li>Openstack model: {@link Image}</li>
 * <li>Service model: {@link org.ow2.sirocco.cloudmanager.model.cimi.MachineImage}</li>
 * </ul>
 * </p>
 */
public class ImageConverter {


    public List<Image> toOpenstackCollection(final Object dataService) {
        List<Image> images = new ArrayList();
        for (Object imageObj : (Vector) dataService) {
            images.add(toOpenstackObject(imageObj));
        }
        return images;
    }

    public Image toOpenstackObject(final Object dataService) {
        Image image = new Image();
        this.copyToOpenstack((MachineImage) dataService, image);
        return image;
    }

    /**
     * Copy data from a service object to a Openstack object.
     *
     * @param dataService   Source service object
     * @param dataOpenstack Destination Openstack object
     */
    protected void copyToOpenstack(final MachineImage dataService, final Image dataOpenstack) {

        if (null != dataService.getRelatedImage()) {
            dataOpenstack.setRelatedImage(new Image(dataService.getRelatedImage()
                    .getId().toString()));
        }
        dataOpenstack.setName(dataService.getName());
        dataOpenstack.setStatus(dataService.getState().toString());
        dataOpenstack.setCreated(dataService.getCreated());
        dataOpenstack.setUpdated(dataService.getUpdated());
        dataOpenstack.setTenantId(String.valueOf(dataService.getTenant().getId()));
        dataOpenstack.setMinDisk(dataService.getCloudProviderAccount().getCloudProvider().);

        String userId = String.valueOf(dataService.getTenant().getUsers().get(0).getId());
        dataOpenstack.setUserId(userId);

        if (null != dataService.getId()) {
            dataOpenstack.setId(String.valueOf(dataService.getId()));
        }
    }

}
