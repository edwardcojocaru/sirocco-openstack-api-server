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

package org.ow2.sirocco.openstack.server.request;

import java.io.Serializable;
import java.util.LinkedList;

public class MessageContext implements Serializable {

    public Request request;
    public Response response;
    private Object callServiceHelper;

    public MessageContext() {

    }

    public MessageContext(final Request request, final Response response) {
        super();
        this.request = request;
        this.response = response;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public void setCallServiceHelper(Object callServiceHelper) {
        this.callServiceHelper = callServiceHelper;
    }

    public Object getCallServiceHelper() {
        return callServiceHelper;
    }

    public boolean hasParamsForReadingCollection() {
        boolean has = false;
      /*  if ((false == this.getRequest().getParams().getCimiFirst().isEmpty())) {
            has = true;
        } else if ((false == this.getRequest().getParams().getCimiLast().isEmpty())) {
            has = true;
        } else if ((false == this.getRequest().getParams().getCimiFilter().isEmpty())) {
            has = true;
        } else if ((false == this.getRequest().getParams().getCimiSelect().isEmpty())) {
            has = true;
        }*/
        return has;
    }
}
