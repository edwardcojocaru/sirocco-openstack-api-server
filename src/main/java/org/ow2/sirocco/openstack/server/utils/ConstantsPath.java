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

package org.ow2.sirocco.openstack.server.utils;

public final class ConstantsPath {

    private ConstantsPath() {
    }

    public static final String SERVERS_V2 = "v2/{tenantId}/servers";

    public static final String SERVERS_PATH_V2 = "/" + SERVERS_V2;

    public static final String SERVER_METADATA_PATH_V2 = "/" + SERVERS_V2 + "/{id}/metadata";

    public static final String IMAGES_V2 = "v2/images";

    public static final String IMAGES_PATH_V2 = "/" + IMAGES_V2;

    public static final String IMAGE_METADATA_PATH_V2 = "/" + IMAGES_V2 + "/​{id}​/metadata/";

}
