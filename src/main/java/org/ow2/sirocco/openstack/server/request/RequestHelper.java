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

import org.ow2.sirocco.openstack.server.resource.RestResourceAbstract;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 24/10/13
 */
public class RequestHelper {

    public static Request buildRequest(final RestResourceAbstract.JaxRsRequestInfos infos, final IdRequest ids,
                                       final Object serviceData) {
        Request request = new Request();
        //request.setParams(RequestHelper.buildRequestHeader(infos));
        request.setIds(ids);
        request.setServiceData(serviceData);
        return request;
    }


    private static List<String> transformQueryParamToList(final String paramName,
                                                          final MultivaluedMap<String, String> queryParameters) {
        List<String> params = queryParameters.get(paramName);
        return params;
    }

    public static String[] decode(String auth) {
        auth = auth.replaceFirst("[B|b]asic ", "");
        byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);
        if (decodedBytes == null || decodedBytes.length == 0) {
            return null;
        }
        return new String(decodedBytes).split(":", 2);
    }

    private static String transformQueryParamToString(final String paramName,
                                                      final MultivaluedMap<String, String> queryParameters) {
        List<String> params = RequestHelper.transformQueryParamToList(paramName, queryParameters);
        String param = null;
        if ((null != params) && (params.size() > 0)) {
            param = params.get(0);
        }
        return param;
    }
}
