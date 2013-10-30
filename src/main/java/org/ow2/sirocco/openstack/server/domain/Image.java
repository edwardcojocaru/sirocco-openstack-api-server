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

package org.ow2.sirocco.openstack.server.domain;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Silvia.Pacurici
 * Date: 25/10/13
 */

@XmlRootElement(name = "Image")
@XmlType(propOrder = {"id", "name", "updated", "created", "tenant_id", "user_id", "status",
        "progress", "minDisk", "minRam", "server", "relatedImage"})
@JsonPropertyOrder({"resourceURI", "id", "name", "updated", "created", "tenant_id", "user_id", "status",
        "progress", "minDisk", "minRam", "server", "relatedImage"})
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Image extends ObjectCommonAbstract implements Serializable {
    private String id;
    private String name;
    private Server server;
    private Image relatedImage;
    private String status;
    private String tenantId;
    private String userId;
    private int progress;
    private int minDisk;
    private int minRam;

    public Image() {
    }

    public Image(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Image getRelatedImage() {
        return relatedImage;
    }

    public void setRelatedImage(Image relatedImage) {
        this.relatedImage = relatedImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getMinDisk() {
        return minDisk;
    }

    public void setMinDisk(int minDisk) {
        this.minDisk = minDisk;
    }

    public int getMinRam() {
        return minRam;
    }

    public void setMinRam(int minRam) {
        this.minRam = minRam;
    }
}
