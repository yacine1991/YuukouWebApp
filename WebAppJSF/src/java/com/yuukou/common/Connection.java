/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

/**
 *
 * @author Yacine
 */
public class Connection {
    private String result;
    
    public String conhealthForAllRooms(boolean image) {


        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        // TODO process result here
        result = port.healthForAllRooms(image);
        return result;
    }

    public String congetSitesInformations() {


        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        // TODO process result here
        result = port.getSitesInformation();
        return result;
    }

    public String healthForRoom(java.lang.String idRoom, boolean image) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.healthForRoom(idRoom, image);
    }

    public String getGraphWithRequestUsingJson(java.lang.String rqt, java.lang.String rqtLqbel, java.lang.String label, java.lang.String startTime, java.lang.String endTime, int factor) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.getGraphWithRequestUsingJson(rqt, rqtLqbel, label, startTime, endTime, factor);
    }
    
    
    
}
