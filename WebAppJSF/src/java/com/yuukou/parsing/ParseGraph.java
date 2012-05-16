package com.yuukou.parsing;

import com.yuukou.common.YuukouServlet;
import com.yuukou.connection.Connection;
import com.yuukou.stats.Graph;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Yacine
 */
public class ParseGraph {

    

    public byte[] getImageFromJSON(String timeStart, String timeEnd, String addToRequest, int factorStr) throws IOException {
        Connection c = new Connection();
        int factor = factorStr;
        JSONParser jp = new JSONParser();
        Object obj = null;
        int i;
        byte[] tabImageByte = null;

        String responseGetGraph = c.getGraphWithRequestUsingJson("start_time_session", "label", timeStart, timeEnd, addToRequest, factor);

        try {
            obj = jp.parse(responseGetGraph);

        } catch (ParseException ex) {
            Logger.getLogger(YuukouServlet.class.getName()).log(Level.SEVERE, null, ex);           
        }

        JSONObject jo = (JSONObject) obj;

        if (jo.get("JSONState").equals("OK")) {


            JSONObject jso = (JSONObject) jo.get("JSONContents");
            String ImageType = jso.get("ImageType").toString();


            JSONArray joo3 = (JSONArray) jso.get("Image");

            tabImageByte = new byte[joo3.size()];

            for (i = 0; i < joo3.size(); i++) {

                Long ll = (Long) joo3.get(i);
                String test = String.valueOf(ll);
                tabImageByte[i] = Byte.parseByte(test);


            }

            //g.setImageFile(convertByteToImage(tabImageByte, "test", g.getImageType()));
        }

        return tabImageByte;
    }
}
