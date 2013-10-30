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
import org.ow2.sirocco.cloudmanager.model.cimi.Machine;
import org.ow2.sirocco.openstack.server.request.MessageContext;
import org.ow2.sirocco.openstack.server.request.Request;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 16/10/13
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */

@OpenStackManager("ServerMetadataManager")
public class ServerMetadataManager extends ServerManager {

    @Inject
    private IMachineManager manager;


    @Override
    protected Object convertToDataService(MessageContext context) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void convertToResponse(MessageContext context, Object dataService) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Object read(MessageContext context, Object dataService) throws Exception {
        Object out = null;
        Request request = context.getRequest();
        /*final String requestKey = request.getKey();

        Machine requestMachine = getMachineFromRequest(request);
        if (requestMachine != null) {
            if (requestKey != null) {
                requestMachine.getProperties().get(requestKey);
            } else if (!context.hasParamsForReadingCollection()) {
                out = requestMachine.getProperties();
            } else {
                // TODO must be checked if the EJB layer should be improved
            }
        }*/
        return out;
    }

    @Override
    protected Object create(MessageContext context, Object dataService) throws Exception {
        Machine requestMachine = getMachineFromRequest(context.getRequest());
        if (requestMachine != null) {
            requestMachine.setProperties((Map<String, String>) dataService);
        }
        return read(context, dataService);
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
