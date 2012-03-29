package com.mkyong.common;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String result;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String connection() {


        jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
        jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
        // TODO process result here
        result = port.who();
        return result;


    }
}