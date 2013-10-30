package org.ow2.sirocco.openstack.server.domain;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 25/10/13
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "Machine")
@XmlType(propOrder = {"id", "name", "progress", "hostId", "created", "updated", "accessIPv4", "accessIPv6"})
@JsonPropertyOrder({"id", "name", "updated", "created", "hostId", "status", "progress", "accessIPv4", "accessIPv6"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Server {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    public enum ServerStatusEnum {
        ACTIVE, BUILD, DELETED, ERROR, HARD_REBOOT, PASSWORD, REBOOT, REBUILD, RESCUE, RESIZE, REVERT_RESIZE, SHUTOFF, SUSPENDED, UNKNOWN, VERIFY_RESIZE
    }

    String id;
    ServerMetadata serverMetadata;
    List<Image> images;
}
