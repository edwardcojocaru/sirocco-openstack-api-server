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

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 *
 */
@ResourceInterceptorBinding
public class RestResourceAbstract {

    @Context
    private UriInfo uriInfo;

    @Context
    protected HttpHeaders headers;

    @Context
    private Request request;

    private JaxRsRequestInfos infos;

    /**
     * 
     */
    public RestResourceAbstract() {
        this.infos = new JaxRsRequestInfos();
    }

    /**
     * @return the uriInfo
     */
    public UriInfo getUriInfo() {
        return this.uriInfo;
    }

    /**
     * @return the headers
     */
    public HttpHeaders getHeaders() {
        return this.headers;
    }

    /**
     * @return the request
     */
    public Request getRequest() {
        return this.request;
    }

    /**
     * @return the request
     */
    public JaxRsRequestInfos getJaxRsRequestInfos() {
        return this.infos;
    }

    public class JaxRsRequestInfos {

        /**
         * @return the uriInfo
         */
        public UriInfo getUriInfo() {
            return RestResourceAbstract.this.uriInfo;
        }

        /**
         * @return the headers
         */
        public HttpHeaders getHeaders() {
            return RestResourceAbstract.this.headers;
        }

        /**
         * @return the request
         */
        public Request getRequest() {
            return RestResourceAbstract.this.request;
        }

    }
}
