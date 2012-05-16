/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.connection;

/**
 *
 * @author Yacine
 */
public class Connection {

    private String result;

    public String conhealthForAllRooms() {
        // @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/yuukou-nagios.wmin.ac.uk_8080/YuukouServerService/YuukouServerService.wsdl")
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        // TODO process result here
        result = port.healthForAllRooms();
        return result;
    }

    public String congetSitesInformations() {


        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        // TODO process result here
        result = port.getSitesInformation();
        return result;
    }

    public String healthForRoom(java.lang.String idRoom) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.healthForRoom(idRoom);
    }

    public String healthResourcesReportForRoom(java.lang.String idRoom) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.healthResourcesReportForRoom(idRoom);
    }

    public String who() {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.who();
    }

    public String searchHistoryUser(java.lang.String idUser, boolean who, boolean last, int nbHistory) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.searchHistoryUser(idUser, who, last, nbHistory);
    }

    public String getGraphWithRequestUsingJson(java.lang.String rqtLqbel, java.lang.String label, java.lang.String startTime, java.lang.String endTime, java.lang.String addToRqt, int factor) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.getGraphWithRequestUsingJson(rqtLqbel, label, startTime, endTime, addToRqt, factor);
    }

    public String searchHistoryResource(java.lang.String idResource, boolean who, boolean last, int numberLast) {
        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        return port.searchHistoryResource(idResource, who, last, numberLast);
    }
}
