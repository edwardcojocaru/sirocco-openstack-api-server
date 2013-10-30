package org.ow2.sirocco.openstack.server.request;

import org.ow2.sirocco.openstack.server.resource.RestResourceAbstract;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 24/10/13
 * Time: 11:40
 * To change this template use File | Settings | File Templates.
 */
public class MessageContextHelper {

    public static MessageContext buildContext(final RestResourceAbstract.JaxRsRequestInfos infos) {
        return MessageContextHelper.buildContext(infos, (IdRequest) null, null);
    }

    public static MessageContext buildContext(final RestResourceAbstract.JaxRsRequestInfos infos, final Object dataService) {
        return MessageContextHelper.buildContext(infos, (IdRequest) null, dataService);
    }

    public static MessageContext buildContext(final RestResourceAbstract.JaxRsRequestInfos infos, final String id) {
        return MessageContextHelper.buildContext(infos, new IdRequest(id), null);
    }

    public static MessageContext buildContext(final RestResourceAbstract.JaxRsRequestInfos infos, final String id,
                                           final Object dataService) {
        return MessageContextHelper.buildContext(infos, new IdRequest(id), dataService);
    }

    public static MessageContext buildContext(final RestResourceAbstract.JaxRsRequestInfos infos, final IdRequest ids) {
        return MessageContextHelper.buildContext(infos, ids, null);
    }

    public static MessageContext buildContext(final RestResourceAbstract.JaxRsRequestInfos infos, final IdRequest ids,
                                           final Object dataService) {
        Request request = RequestHelper.buildRequest(infos, ids, dataService);
        Response response = new Response();
        return new MessageContext(request, response);
    }
}
