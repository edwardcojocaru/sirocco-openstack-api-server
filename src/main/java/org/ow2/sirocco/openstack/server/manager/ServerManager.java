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

import org.ow2.sirocco.cloudmanager.core.api.IMachineManager;
import org.ow2.sirocco.cloudmanager.model.cimi.MachineCreate;
import org.ow2.sirocco.openstack.server.request.MessageContext;

import javax.inject.Inject;

/**
 * User: Eduard.Cojocaru
 * Date: 10/10/13
 */
@OpenStackManager("ServerManager")
public class ServerManager extends AbstractManager {

    @Inject
    private IMachineManager manager;

    @Override
    protected Object convertToDataService(MessageContext context) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Object read(MessageContext context, Object dataService) throws Exception {
        Object out = null;
        final String requestId = context.getRequest().getId();
        if (requestId != null) {
            this.manager.getMachineById(requestId);
        } else if (!context.hasParamsForReadingCollection()) {
            out = this.manager.getMachines();
        } else {
//            QueryResult<?> results = this.manager.getMachines(context.valueOfFirst(), context.valueOfLast(),
//                    context.valuesOfFilter(), context.valuesOfSelect());
//            out = results.getItems();

            // TODO must be checked if the EJB layer should be improved
        }
        return out;
    }

    @Override
    protected Object create(MessageContext context, Object dataService) throws Exception {
        return this.manager.createMachine((MachineCreate) dataService);
    }

    @Override
    protected Object update(MessageContext context, Object dataService) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Object delete(MessageContext context, Object dataService) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void convertToResponse(MessageContext context, Object dataService) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
