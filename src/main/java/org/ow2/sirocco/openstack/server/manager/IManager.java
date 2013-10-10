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

import org.ow2.sirocco.openstack.server.request.MessageContext;

/**
 * User: Eduard.Cojocaru
 * Date: 10/10/13
 */
public interface IManager {

    /**
     * Execute request and call service with the data of context.
     *
     * @param context The current context of the REST request
     */
    void execute(MessageContext context, OperationEnum operation);

    public enum OperationEnum {
        CREATE,
        READ,
        UPDATE,
        DELETE
    }
}
