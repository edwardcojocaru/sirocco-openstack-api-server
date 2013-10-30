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

import org.ow2.sirocco.cloudmanager.core.api.IdentityContext;
import org.ow2.sirocco.openstack.server.request.RequestHelper;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.HttpHeaders;
import java.io.Serializable;
import java.util.List;

@Interceptor
@ResourceInterceptorBinding
public class IdentityInterceptor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    IdentityContext identityContext;

    @AroundInvoke
    public Object retrieveUserNameAndTenantId(final InvocationContext ctx) throws Exception {
        if (ctx.getTarget() instanceof RestResourceAbstract) {
            RestResourceAbstract resourceBase = (RestResourceAbstract) ctx.getTarget();
            HttpHeaders headers = resourceBase.getHeaders();
            List<String> values = headers.getRequestHeader("tenantId");
            if (values != null && !values.isEmpty()) {
                this.identityContext.setTenantId(values.get(0));
            }
            values = headers.getRequestHeader("Authorization");
            if (values != null && !values.isEmpty()) {
                String userPassword[] = RequestHelper.decode(values.get(0));
                this.identityContext.setUserName(userPassword[0]);
            }

            this.identityContext.setUserName("admin");
            this.identityContext.setTenantId("1");
        }
        return ctx.proceed();
    }

}